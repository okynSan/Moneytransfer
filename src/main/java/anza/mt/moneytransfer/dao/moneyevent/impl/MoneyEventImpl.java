/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anza.mt.moneytransfer.dao.moneyevent.impl;

import anza.mt.moneytransfer.dao.moneyevent.IMoneyEvent;
import anza.mt.moneytransfer.model.MoneyEvent;
import anza.mt.moneytransfer.model.PaymentEvent;
import anza.mt.moneytransfer.util.HibernateUtil;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author andrey_zatvornitskiy
 */
public class MoneyEventImpl implements IMoneyEvent {

    private final static MoneyEventImpl moneyEventDaoImpl = createDaoImpl();

    @Override
    public List<MoneyEvent> getLastMoneyEvent() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery(""
                + " From MoneyEvent me "
                + " order by me.moneyEventId desc"
                + "  ");

        List<MoneyEvent> resultList = q.setMaxResults(1)
                .getResultList();

        return resultList;
    }

    @Override
    public void saveMoneyEvent(PaymentEvent paymentEvent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save((MoneyEvent) paymentEvent);
            System.out.println("ID = " + ((MoneyEvent) paymentEvent).getMoneyEventId());
            session.getTransaction().commit();

        } catch (HibernateException hibernateException) {
            System.out.println(hibernateException.toString());
        }
    }

    private static MoneyEventImpl createDaoImpl() {
        return new MoneyEventImpl();
    }

    public static MoneyEventImpl getMoneyEventDaoImpl() {
        return moneyEventDaoImpl;
    }

}
