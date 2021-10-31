package com.stocks.service.dto;

import com.stocks.dao.dto.Exchange;

import java.util.*;

public class StockInformation {
    private String symbol;
    private String name;
    private Exchange exchange;

    private TimeFrameEnum timeFrame;

    private SortedMap<Date, StockValues> stockValues;

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeFrameEnum getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrameEnum timeFrame) {
        this.timeFrame = timeFrame;
    }

    public SortedMap<Date, StockValues> getStockValues() {
        return stockValues;
    }

    public void setStockValues(SortedMap<Date, StockValues> stockValues) {
        this.stockValues = stockValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockInformation that = (StockInformation) o;
        return Objects.equals(symbol, that.symbol) &&
                Objects.equals(name, that.name) &&
                exchange == that.exchange &&
                timeFrame == that.timeFrame &&
                Objects.equals(stockValues, that.stockValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, name, exchange, timeFrame, stockValues);
    }

    @Override
    public String toString() {
        return "StockInformation{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", exchange=" + exchange +
                ", timeFrame=" + timeFrame +
                ", stockValues=" + stockValues +
                '}';
    }
}
