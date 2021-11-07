package com.stocks.service.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TargetPrice {
    private double price;
    private Set<TargetPriceTypeEnum> types = new HashSet<>();
    private String comment;
    private TimeFrameEnum timeFrame;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<TargetPriceTypeEnum> getTypes() {
        return types;
    }

    public void setTypes(Set<TargetPriceTypeEnum> types) {
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
        TargetPrice that = (TargetPrice) o;
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
        return "TargetPrice{" +
                "price=" + price +
                ", types=" + types +
                ", timeFrame=" + timeFrame +
                ", comment='" + comment + '\'' +
                '}';
    }
}
