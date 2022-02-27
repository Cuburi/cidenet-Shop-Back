package com.CidenetShop.CidenetShopBackend.emailPassword.dto;

public class ActiveAccountDTO {
    private String tokenActive;

    public ActiveAccountDTO() {
    }

    public ActiveAccountDTO(String tokenActive) {
        this.tokenActive = tokenActive;
    }

    public String getTokenActive() {
        return tokenActive;
    }

    public void setTokenActive(String tokenActive) {
        this.tokenActive = tokenActive;
    }
}
