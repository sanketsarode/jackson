package com.jackson.test;

import java.util.Date;

public class Transaction {

    private String type = null;
    private Date date = null;

    public Transaction(String type, Date date) {
        this.type = type;
        this.date = date;
    }

    public Transaction() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}