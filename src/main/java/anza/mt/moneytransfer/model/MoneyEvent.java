/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anza.mt.moneytransfer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andrey_zatvornitskiy
 */
@Entity
@Table(name = "money_event")
public class MoneyEvent extends PaymentEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "money_event_id")
    private Integer moneyEventId;

    @Column(name = "actual_sum")
    private Float actualSum;

    @Column(name = "prev_sum")
    private Float prevSum;

    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @Column(name = "sum_spent")
    private Float sumSpent;

    @Column(name = "insert_date")
    @Temporal(TemporalType.DATE)
    private Date insertDate;

    @Column(name = "is_checked")
    private Boolean isChecked;

    public MoneyEvent() {
    }

    public MoneyEvent(Integer moneyEventId) {
        this.moneyEventId = moneyEventId;
    }

    public MoneyEvent(Integer moneyEventId, Date eventDate, Float sumSpent, Date insertDate) {
        this.moneyEventId = moneyEventId;
        this.eventDate = eventDate;
        this.sumSpent = sumSpent;
        this.insertDate = insertDate;
    }

    public Integer getMoneyEventId() {
        return moneyEventId;
    }

    public void setMoneyEventId(Integer moneyEventId) {
        this.moneyEventId = moneyEventId;
    }

    public Float getActualSum() {
        return actualSum;
    }

    public void setActualSum(Float actualSum) {
        this.actualSum = actualSum;
    }

    public Float getPrevSum() {
        return prevSum;
    }

    public void setPrevSum(Float prevSum) {
        this.prevSum = prevSum;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Float getSumSpent() {
        return sumSpent;
    }

    public void setSumSpent(Float sumSpent) {
        this.sumSpent = sumSpent;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moneyEventId != null ? moneyEventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoneyEvent)) {
            return false;
        }
        MoneyEvent other = (MoneyEvent) object;
        if ((this.moneyEventId == null && other.moneyEventId != null) || (this.moneyEventId != null && !this.moneyEventId.equals(other.moneyEventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MoneyEvent{" + "moneyEventId=" + moneyEventId + ", actualSum=" + actualSum + ", prevSum=" + prevSum + ", eventDate=" + eventDate + ", sumSpent=" + sumSpent + ", insertDate=" + insertDate + ", isChecked=" + isChecked + '}';
    }

}
