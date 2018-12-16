/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManeyEvent;

import anza.mt.moneytransfer.dao.moneyevent.IMoneyEvent;
import anza.mt.moneytransfer.dao.moneyevent.impl.MoneyEventImpl;
import org.junit.Test;

/**
 *
 * @author andrey_zatvornitskiy
 */
public class MoneyEventTest {

    @Test
    public void getAllBankEventsTest() {
        IMoneyEvent iMoneyEvent = new MoneyEventImpl();
        iMoneyEvent.getLastMoneyEvent();

    }
}
