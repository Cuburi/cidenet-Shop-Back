package com.CidenetShop.CidenetShopBackend.emailPassword.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;


public class EmailSaleValuesDTO {
    private String mailFrom;
    private String mailTo;
    private String subject;
    private String userName;
    private String totalPrice;
    private ArrayList<String> products;

    public EmailSaleValuesDTO() {

    }

    public EmailSaleValuesDTO(String mailFrom, String mailTo, String subject, String userName, String totalPrice, ArrayList<String> products) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.subject = subject;
        this.userName = userName;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }
}
