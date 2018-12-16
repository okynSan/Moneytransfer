/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import anza.mt.moneytransfer.controller.MoneyController;
import anza.mt.moneytransfer.model.MoneyEvent;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrey_zatvornitskiy
 */
public class MoneyControllerTest {

    public static MoneyController moneyController = new MoneyController();

    @Test
    public void saveMonetEvTest() throws Exception {
        MoneyEvent moneyEvent = new MoneyEvent();
        moneyEvent.setSumSpent(10F);
        moneyEvent.setActualSum(100F);
        moneyController.saveBankEvent(moneyEvent);
    }

    @Test
    public void saveAdnGetMoneyEvent() throws InterruptedException {
        MoneyEvent moneyEvent = new MoneyEvent();
        moneyEvent.setSumSpent(10F);
        moneyEvent.setActualSum(100F);
        moneyController.saveBankEvent(moneyEvent);
        Thread.sleep(10000);
        MoneyEvent moneyEventSaved = (MoneyEvent) moneyController.getLastPaymentEvent();
        assertNotNull(moneyEventSaved.getMoneyEventId());
    }
}
