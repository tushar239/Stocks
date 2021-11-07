package com.stocks.service.dto;

import java.util.Objects;

public class DemandZonePrice {
    private double price;
    private String comment;
    private TimeFrameEnum timeFrame;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        DemandZonePrice that = (DemandZonePrice) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(comment, that.comment) &&
                timeFrame == that.timeFrame;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, comment, timeFrame);
    }

    @Override
    public String toString() {
        return "DemandZonePrice{" +
                "price=" + price +
                ", comment='" + comment + '\'' +
                ", timeFrame=" + timeFrame +
                '}';
    }
}
