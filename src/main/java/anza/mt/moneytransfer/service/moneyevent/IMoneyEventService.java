/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anza.mt.moneytransfer.service.moneyevent;

import anza.mt.moneytransfer.model.PaymentEvent;

/**
 *
 * @author andrey_zatvornitskiy
 */
public interface IMoneyEventService {

    public PaymentEvent getLastPaymentEvent();
    public void startPaymentEventThread();
    void addMoneyEventToQueue(PaymentEvent paymentEvent);

}
