/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anza.mt.moneytransfer.service.moneyevent.impl;

import anza.mt.moneytransfer.dao.moneyevent.IMoneyEvent;
import anza.mt.moneytransfer.dao.moneyevent.impl.MoneyEventImpl;
import anza.mt.moneytransfer.model.MoneyEvent;
import anza.mt.moneytransfer.model.PaymentEvent;
import anza.mt.moneytransfer.service.moneyevent.IMoneyEventService;
import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrey_zatvornitskiy
 */
public class MoneyEventServiceImpl implements IMoneyEventService, Runnable {

    private final IMoneyEvent iMoneyEvent;
    private final static MoneyEventServiceImpl moneyEventServiceImpl = createService();
    private final BlockingQueue<PaymentEvent> blockingQueue = new LinkedBlockingDeque<>();

    private MoneyEventServiceImpl() {
        this.iMoneyEvent = MoneyEventImpl.getMoneyEventDaoImpl();
    }

    private static MoneyEventServiceImpl createService() {
        return new MoneyEventServiceImpl();
    }

    public static MoneyEventServiceImpl getMoneyEventServiceImpl() {
        return moneyEventServiceImpl;
    }

    @Override
    public void startPaymentEventThread() {
        new Thread(this).start();
    }

    @Override
    public void addMoneyEventToQueue(PaymentEvent paymentEvent) {
        try {
            this.blockingQueue.put(paymentEvent);
        } catch (InterruptedException ex) {
            Logger.getLogger(MoneyEventServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PaymentEvent getLastPaymentEvent() {
        return iMoneyEvent.getLastMoneyEvent().stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("SIZE OF - " + blockingQueue.size());
                System.out.println("Running");

                PaymentEvent paymentEvent;

                while ((paymentEvent = blockingQueue.take()) != null) {
                    MoneyEvent moneyEvent = iMoneyEvent.getLastMoneyEvent().stream()
                            .findFirst()
                            .orElse(null);

                    if (paymentEvent instanceof MoneyEvent) {
                        ((MoneyEvent) paymentEvent).setEventDate(Calendar.getInstance().getTime());
                        ((MoneyEvent) paymentEvent).setInsertDate(Calendar.getInstance().getTime());
                        if (moneyEvent != null) {

                            System.out.println(moneyEvent.toString());
                            ((MoneyEvent) paymentEvent).setPrevSum(moneyEvent.getActualSum());
                            ((MoneyEvent) paymentEvent).setActualSum(moneyEvent.getActualSum() + ((MoneyEvent) paymentEvent).getSumSpent());
                        }
                    }

                    iMoneyEvent.saveMoneyEvent(paymentEvent);

                }
            } catch (InterruptedException e) {
                //handle error
            }
        }
    }

}
