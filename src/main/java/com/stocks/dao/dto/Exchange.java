package com.stocks.dao.dto;

public enum Exchange {
    BSE("BSE"), NSE("NSE");

    private String exchange;

    Exchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }
}
