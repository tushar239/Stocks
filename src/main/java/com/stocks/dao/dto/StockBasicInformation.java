package com.stocks.dao.dto;

import java.util.Date;
import java.util.Objects;

public class StockBasicInformation {
    private String name;

    private String bseSymbol;
    private String nseSymbol;

    private Double dailyStopLoss1;
    private Double weeklyStopLoss1;
    private Double monthlyStopLoss1;

    private Double dailyStopLoss2;
    private Double weeklyStopLoss2;
    private Double monthlyStopLoss2;

    private Double dailyStopLoss3;
    private Double weeklyStopLoss3;
    private Double monthlyStopLoss3;

    private Double dailyDemandZoneValue;
    private Double weeklyDemandZoneValue;
    private Double monthlyDemandZoneValue;

    private Double dailyTarget1;
    private Double weeklyTarget1;
    private Double monthlyTarget1;

    private Double dailyTarget2;
    private Double weeklyTarget2;
    private Double monthlyTarget2;

    private Double dailyTarget3;
    private Double weeklyTarget3;
    private Double monthlyTarget3;

    private Date purchaseDate;

    private Double quantity;

    private String timeFrames;

    private String comment1;
    private String comment2;
    private Double buyingPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBseSymbol() {
        return bseSymbol;
    }

    public void setBseSymbol(String bseSymbol) {
        this.bseSymbol = bseSymbol;
    }

    public String getNseSymbol() {
        return nseSymbol;
    }

    public void setNseSymbol(String nseSymbol) {
        this.nseSymbol = nseSymbol;
    }

    public Double getDailyStopLoss1() {
        return dailyStopLoss1;
    }

    public void setDailyStopLoss1(Double dailyStopLoss1) {
        this.dailyStopLoss1 = dailyStopLoss1;
    }

    public Double getWeeklyStopLoss1() {
        return weeklyStopLoss1;
    }

    public void setWeeklyStopLoss1(Double weeklyStopLoss1) {
        this.weeklyStopLoss1 = weeklyStopLoss1;
    }

    public Double getMonthlyStopLoss1() {
        return monthlyStopLoss1;
    }

    public void setMonthlyStopLoss1(Double monthlyStopLoss1) {
        this.monthlyStopLoss1 = monthlyStopLoss1;
    }

    public Double getDailyStopLoss2() {
        return dailyStopLoss2;
    }

    public void setDailyStopLoss2(Double dailyStopLoss2) {
        this.dailyStopLoss2 = dailyStopLoss2;
    }

    public Double getWeeklyStopLoss2() {
        return weeklyStopLoss2;
    }

    public void setWeeklyStopLoss2(Double weeklyStopLoss2) {
        this.weeklyStopLoss2 = weeklyStopLoss2;
    }

    public Double getMonthlyStopLoss2() {
        return monthlyStopLoss2;
    }

    public void setMonthlyStopLoss2(Double monthlyStopLoss2) {
        this.monthlyStopLoss2 = monthlyStopLoss2;
    }

    public Double getDailyStopLoss3() {
        return dailyStopLoss3;
    }

    public void setDailyStopLoss3(Double dailyStopLoss3) {
        this.dailyStopLoss3 = dailyStopLoss3;
    }

    public Double getWeeklyStopLoss3() {
        return weeklyStopLoss3;
    }

    public void setWeeklyStopLoss3(Double weeklyStopLoss3) {
        this.weeklyStopLoss3 = weeklyStopLoss3;
    }

    public Double getMonthlyStopLoss3() {
        return monthlyStopLoss3;
    }

    public void setMonthlyStopLoss3(Double monthlyStopLoss3) {
        this.monthlyStopLoss3 = monthlyStopLoss3;
    }

    public Double getDailyDemandZoneValue() {
        return dailyDemandZoneValue;
    }

    public void setDailyDemandZoneValue(Double dailyDemandZoneValue) {
        this.dailyDemandZoneValue = dailyDemandZoneValue;
    }

    public Double getWeeklyDemandZoneValue() {
        return weeklyDemandZoneValue;
    }

    public void setWeeklyDemandZoneValue(Double weeklyDemandZoneValue) {
        this.weeklyDemandZoneValue = weeklyDemandZoneValue;
    }

    public Double getMonthlyDemandZoneValue() {
        return monthlyDemandZoneValue;
    }

    public void setMonthlyDemandZoneValue(Double monthlyDemandZoneValue) {
        this.monthlyDemandZoneValue = monthlyDemandZoneValue;
    }

    public Double getDailyTarget1() {
        return dailyTarget1;
    }

    public void setDailyTarget1(Double dailyTarget1) {
        this.dailyTarget1 = dailyTarget1;
    }

    public Double getWeeklyTarget1() {
        return weeklyTarget1;
    }

    public void setWeeklyTarget1(Double weeklyTarget1) {
        this.weeklyTarget1 = weeklyTarget1;
    }

    public Double getMonthlyTarget1() {
        return monthlyTarget1;
    }

    public void setMonthlyTarget1(Double monthlyTarget1) {
        this.monthlyTarget1 = monthlyTarget1;
    }

    public Double getDailyTarget2() {
        return dailyTarget2;
    }

    public void setDailyTarget2(Double dailyTarget2) {
        this.dailyTarget2 = dailyTarget2;
    }

    public Double getWeeklyTarget2() {
        return weeklyTarget2;
    }

    public void setWeeklyTarget2(Double weeklyTarget2) {
        this.weeklyTarget2 = weeklyTarget2;
    }

    public Double getMonthlyTarget2() {
        return monthlyTarget2;
    }

    public void setMonthlyTarget2(Double monthlyTarget2) {
        this.monthlyTarget2 = monthlyTarget2;
    }

    public Double getDailyTarget3() {
        return dailyTarget3;
    }

    public void setDailyTarget3(Double dailyTarget3) {
        this.dailyTarget3 = dailyTarget3;
    }

    public Double getWeeklyTarget3() {
        return weeklyTarget3;
    }

    public void setWeeklyTarget3(Double weeklyTarget3) {
        this.weeklyTarget3 = weeklyTarget3;
    }

    public Double getMonthlyTarget3() {
        return monthlyTarget3;
    }

    public void setMonthlyTarget3(Double monthlyTarget3) {
        this.monthlyTarget3 = monthlyTarget3;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getTimeFrames() {
        return timeFrames;
    }

    public void setTimeFrames(String timeFrames) {
        this.timeFrames = timeFrames;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockBasicInformation that = (StockBasicInformation) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(bseSymbol, that.bseSymbol) &&
                Objects.equals(nseSymbol, that.nseSymbol) &&
                Objects.equals(dailyStopLoss1, that.dailyStopLoss1) &&
                Objects.equals(weeklyStopLoss1, that.weeklyStopLoss1) &&
                Objects.equals(monthlyStopLoss1, that.monthlyStopLoss1) &&
                Objects.equals(dailyStopLoss2, that.dailyStopLoss2) &&
                Objects.equals(weeklyStopLoss2, that.weeklyStopLoss2) &&
                Objects.equals(monthlyStopLoss2, that.monthlyStopLoss2) &&
                Objects.equals(dailyStopLoss3, that.dailyStopLoss3) &&
                Objects.equals(weeklyStopLoss3, that.weeklyStopLoss3) &&
                Objects.equals(monthlyStopLoss3, that.monthlyStopLoss3) &&
                Objects.equals(dailyDemandZoneValue, that.dailyDemandZoneValue) &&
                Objects.equals(weeklyDemandZoneValue, that.weeklyDemandZoneValue) &&
                Objects.equals(monthlyDemandZoneValue, that.monthlyDemandZoneValue) &&
                Objects.equals(dailyTarget1, that.dailyTarget1) &&
                Objects.equals(weeklyTarget1, that.weeklyTarget1) &&
                Objects.equals(monthlyTarget1, that.monthlyTarget1) &&
                Objects.equals(dailyTarget2, that.dailyTarget2) &&
                Objects.equals(weeklyTarget2, that.weeklyTarget2) &&
                Objects.equals(monthlyTarget2, that.monthlyTarget2) &&
                Objects.equals(dailyTarget3, that.dailyTarget3) &&
                Objects.equals(weeklyTarget3, that.weeklyTarget3) &&
                Objects.equals(monthlyTarget3, that.monthlyTarget3) &&
                Objects.equals(purchaseDate, that.purchaseDate) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(timeFrames, that.timeFrames) &&
                Objects.equals(comment1, that.comment1) &&
                Objects.equals(comment2, that.comment2) &&
                Objects.equals(buyingPrice, that.buyingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bseSymbol, nseSymbol, dailyStopLoss1, weeklyStopLoss1, monthlyStopLoss1, dailyStopLoss2, weeklyStopLoss2, monthlyStopLoss2, dailyStopLoss3, weeklyStopLoss3, monthlyStopLoss3, dailyDemandZoneValue, weeklyDemandZoneValue, monthlyDemandZoneValue, weeklyTarget1, monthlyTarget1, dailyTarget2, weeklyTarget2, monthlyTarget2, dailyTarget3, weeklyTarget3, monthlyTarget3, purchaseDate, quantity, timeFrames, comment1, comment2, buyingPrice);
    }

    @Override
    public String toString() {
        return "StockBasicInformation{" +
                "name='" + name + '\'' +
                ", bseSymbol='" + bseSymbol + '\'' +
                ", nseSymbol='" + nseSymbol + '\'' +
                ", dailyStopLoss1=" + dailyStopLoss1 +
                ", weeklyStopLoss1=" + weeklyStopLoss1 +
                ", monthlyStopLoss1=" + monthlyStopLoss1 +
                ", dailyStopLoss2=" + dailyStopLoss2 +
                ", weeklyStopLoss2=" + weeklyStopLoss2 +
                ", monthlyStopLoss2=" + monthlyStopLoss2 +
                ", dailyStopLoss3=" + dailyStopLoss3 +
                ", weeklyStopLoss3=" + weeklyStopLoss3 +
                ", monthlyStopLoss3=" + monthlyStopLoss3 +
                ", dailyDemandZoneValue=" + dailyDemandZoneValue +
                ", weeklyDemandZoneValue=" + weeklyDemandZoneValue +
                ", monthlyDemandZoneValue=" + monthlyDemandZoneValue +
                ", dailyTarget1=" + dailyTarget1 +
                ", weeklyTarget1=" + weeklyTarget1 +
                ", monthlyTarget1=" + monthlyTarget1 +
                ", dailyTarget2=" + dailyTarget2 +
                ", weeklyTarget2=" + weeklyTarget2 +
                ", monthlyTarget2=" + monthlyTarget2 +
                ", dailyTarget3=" + dailyTarget3 +
                ", weeklyTarget3=" + weeklyTarget3 +
                ", monthlyTarget3=" + monthlyTarget3 +
                ", purchaseDate=" + purchaseDate +
                ", quantity=" + quantity +
                ", timeFrames='" + timeFrames + '\'' +
                ", comment1='" + comment1 + '\'' +
                ", comment2='" + comment2 + '\'' +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
