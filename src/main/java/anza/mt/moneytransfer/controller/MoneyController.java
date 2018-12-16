/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anza.mt.moneytransfer.controller;

import anza.mt.moneytransfer.model.MoneyEvent;
import anza.mt.moneytransfer.model.PaymentEvent;
import anza.mt.moneytransfer.service.moneyevent.IMoneyEventService;
import anza.mt.moneytransfer.service.moneyevent.impl.MoneyEventServiceImpl;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author andrey_zatvornitskiy
 */
@Path("/money")
public class MoneyController {

    private static IMoneyEventService iMoneyEventService = MoneyEventServiceImpl
            .getMoneyEventServiceImpl();

    public MoneyController() {
        iMoneyEventService.startPaymentEventThread();
    }

    @Path("saveBankEvent")
    @POST
    public void saveBankEvent(MoneyEvent moneyEvent) {
        iMoneyEventService.addMoneyEventToQueue(moneyEvent);
    }

    @Path("getLastPaymentEvent")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentEvent getLastPaymentEvent() {
        return iMoneyEventService.getLastPaymentEvent();
    }

}
