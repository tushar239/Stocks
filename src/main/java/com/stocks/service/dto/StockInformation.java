package com.stocks.service.dto;

import com.stocks.dao.dto.Exchange;

import java.util.*;

public class StockInformation {
    private StockBasicInformation stockBasicInformation;

    private TimeFrameEnum timeFrame;

    private SortedMap<Date, StockValues> stockValues;

    public StockBasicInformation getStockBasicInformation() {
        return stockBasicInformation;
    }

    public void setStockBasicInformation(StockBasicInformation stockBasicInformation) {
        this.stockBasicInformation = stockBasicInformation;
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
        return Objects.equals(stockBasicInformation, that.stockBasicInformation) &&
                timeFrame == that.timeFrame &&
                Objects.equals(stockValues, that.stockValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockBasicInformation, timeFrame, stockValues);
    }

    @Override
    public String toString() {
        return "StockInformation{" +
                "stockBasicInformation=" + stockBasicInformation +
                ", timeFrame=" + timeFrame +
                ", stockValues=" + stockValues +
                '}';
    }
}
