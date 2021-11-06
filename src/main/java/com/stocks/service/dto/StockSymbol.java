package com.stocks.service.dto;

import com.stocks.dao.dto.Exchange;

import java.util.Objects;

public class StockSymbol {
    private String symbol;
    private Exchange exchange;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockSymbol that = (StockSymbol) o;
        return Objects.equals(symbol, that.symbol) &&
                exchange == that.exchange;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, exchange);
    }

    @Override
    public String toString() {
        return "StockSymbol{" +
                "symbol='" + symbol + '\'' +
                ", exchange=" + exchange +
                '}';
    }
}
