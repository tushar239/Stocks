package com.stocks.dao.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StocksBasicInformation {
    private List<StockBasicInformation> stocks = new LinkedList<>();

    public List<StockBasicInformation> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockBasicInformation> stocks) {
        this.stocks = stocks;
    }

    public void add(StockBasicInformation stockBasicInformation) {
        stocks.add(stockBasicInformation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StocksBasicInformation that = (StocksBasicInformation) o;
        return Objects.equals(stocks, that.stocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stocks);
    }

    @Override
    public String toString() {
        return "StocksBasicInformation{" +
                "stocks=" + stocks +
                '}';
    }
}
