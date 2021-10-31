package com.stocks.service.dto;

import com.stocks.dao.dto.Exchange;

import java.util.Objects;

public class StockBasicInformation {
    private String name;
    private String symbol;
    private Exchange exchange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        StockBasicInformation that = (StockBasicInformation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(symbol, that.symbol) &&
                exchange == that.exchange;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, exchange);
    }

    @Override
    public String toString() {
        return "StockBasicInformation{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", exchange=" + exchange +
                '}';
    }
}
