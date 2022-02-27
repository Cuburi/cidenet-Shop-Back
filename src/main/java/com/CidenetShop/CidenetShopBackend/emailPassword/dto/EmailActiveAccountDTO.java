package com.CidenetShop.CidenetShopBackend.emailPassword.dto;

public class EmailActiveAccountDTO {
    private String mailFrom;
    private String mailTo;
    private String subject;
    private String userName;
    private String tokenActive;

    public EmailActiveAccountDTO() {
    }

    public EmailActiveAccountDTO(String mailFrom, String mailTo, String subject, String userName, String tokenActive) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.subject = subject;
        this.userName = userName;
        this.tokenActive = tokenActive;
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

    public String getTokenActive() {
        return tokenActive;
    }

    public void setTokenActive(String tokenActive) {
        this.tokenActive = tokenActive;
    }
}
