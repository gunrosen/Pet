package com.pet.todo.domain;


import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Gun on 8/31/18.
 */
@Table(name = "payments")
public class Payment {

    @Column(name = "customerNumber")
    private int customerNumber;

    @Column(name = "checkNumber")
    private String checkNumber;

    @Column(name = "paymentDate")
    private Date paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
