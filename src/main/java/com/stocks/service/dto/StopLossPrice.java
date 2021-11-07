package com.stocks.service.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StopLossPrice {
    private double price;
    private Set<StopLossTypeEnum> types = new HashSet<>();
    private String comment;
    private TimeFrameEnum timeFrame;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<StopLossTypeEnum> getTypes() {
        return types;
    }

    public void setTypes(Set<StopLossTypeEnum> types) {
        this.types = types;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TimeFrameEnum getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrameEnum timeFrame) {
        this.timeFrame = timeFrame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopLossPrice that = (StopLossPrice) o;
        return Objects.equals(price, that.price) &&
                Objects.equals(types, that.types) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(timeFrame, that.timeFrame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, types, comment, timeFrame);
    }

    @Override
    public String toString() {
        return "StopLossPrice{" +
                "price=" + price +
                ", types=" + types +
                ", timeFrame=" + timeFrame +
                ", comment='" + comment + '\'' +
                '}';
    }
}
