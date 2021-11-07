package com.stocks.service.dto;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StocksBasicInformation {
    private List<StockBasicInformation> stocks;

    public StocksBasicInformation() {
        this.stocks = new LinkedList<>();
    }

    public void add(StockBasicInformation stock) {
        this.stocks.add(stock);
    }

    public void addAll(Collection<StockBasicInformation> stocks) {
        this.stocks.addAll(stocks);
    }

    public Stream<StockBasicInformation> getStream() {
        return stocks.stream();
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
