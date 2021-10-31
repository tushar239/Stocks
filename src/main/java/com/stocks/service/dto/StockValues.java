package com.stocks.service.dto;

import java.util.Objects;

public class StockValues {
    private Double openPrice;
    private Double closePrice;
    private Double highPrice;
    private Double lowPrice;
    private Long volume;

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockValues that = (StockValues) o;
        return Objects.equals(openPrice, that.openPrice) &&
                Objects.equals(closePrice, that.closePrice) &&
                Objects.equals(highPrice, that.highPrice) &&
                Objects.equals(lowPrice, that.lowPrice) &&
                Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openPrice, closePrice, highPrice, lowPrice, volume);
    }

    @Override
    public String toString() {
        return "StockValues{" +
                "openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", volume=" + volume +
                '}';
    }
}
