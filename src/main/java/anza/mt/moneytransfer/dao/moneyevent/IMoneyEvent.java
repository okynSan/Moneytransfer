/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anza.mt.moneytransfer.dao.moneyevent;

import anza.mt.moneytransfer.model.MoneyEvent;
import anza.mt.moneytransfer.model.PaymentEvent;
import java.util.List;

/**
 *
 * @author andrey_zatvornitskiy
 */
public interface IMoneyEvent {

    List<MoneyEvent> getLastMoneyEvent();
    void saveMoneyEvent(PaymentEvent paymentEvent);

}
