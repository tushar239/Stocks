package com.stocks.service.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StockSymbols {
    private Set<StockSymbol> stockSymbols = new HashSet<>();

    public void add(StockSymbol stockSymbol) {
        this.stockSymbols.add(stockSymbol);
    }

    public void addAll(Collection<StockSymbol> stockSymbols) {
        this.stockSymbols.addAll(stockSymbols);
    }

    public Set<StockSymbol> getStockSymbols() {
        return stockSymbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockSymbols that = (StockSymbols) o;
        return Objects.equals(stockSymbols, that.stockSymbols);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockSymbols);
    }

    @Override
    public String toString() {
        return "StockSymbols{" +
                "stockSymbols=" + stockSymbols +
                '}';
    }
}
