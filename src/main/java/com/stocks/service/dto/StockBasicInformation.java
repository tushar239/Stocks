package com.stocks.service.dto;

import java.util.List;
import java.util.Objects;

public class StockBasicInformation {
    private String name;
    private List<StockSymbol> stockSymbols;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StockSymbol> getStockSymbols() {
        return stockSymbols;
    }

    public void setStockSymbols(List<StockSymbol> stockSymbols) {
        this.stockSymbols = stockSymbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockBasicInformation that = (StockBasicInformation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(stockSymbols, that.stockSymbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stockSymbols);
    }

    @Override
    public String toString() {
        return "StockBasicInformation{" +
                "name='" + name + '\'' +
                ", stockSymbols=" + stockSymbols +
                '}';
    }
}
