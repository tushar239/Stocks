package com.stocks.dao.dto;

public class StockSymbol {
    private String symbol;
    private Exchange exchange;
    private String companyName;

    public StockSymbol(String symbol, Exchange exchange, String companyName) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.companyName = companyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public String getCompanyName() {
        return companyName;
    }
}
