package com.stocks.service.dto;

import java.util.*;
import java.util.stream.Stream;

public class StockBasicInformation {
    private String name;
    private Set<StockSymbol> stockSymbols = new HashSet<>();
    private double quantity;
    private double buyingPrice;

    // TODO: put comparator logic in another class. This logic can change based on TargetPriceType amd TimeFrame also in future.
    private Set<TargetPrice> targets = new TreeSet<>((o1, o2) -> {
        if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    });

    // TODO: put comparator logic in another class. This logic can change based on StopLossPriceType and TimeFrame also in future.
    private Set<StopLossPrice> stopLosses = new TreeSet<>((o1, o2) -> {
        if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    });

    // TODO: put comparator logic in another class. This logic can change based on TimeFrame also in future.
    private Set<DemandZonePrice> demandZones = new TreeSet<>((o1, o2) -> {
        if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    });

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StockSymbol> getStockSymbols() {
        return stockSymbols;
    }

    public void addStockSymbol(StockSymbol stockSymbol) {
        this.stockSymbols.add(stockSymbol);
    }

    public void addAllStockSymbols(Collection<StockSymbol> stockSymbols) {
        this.stockSymbols.addAll(stockSymbols);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Stream<TargetPrice> getTargets() {
        return targets.stream();
    }

    public void addTarget(TargetPrice targetPrice) {
        targets.add(targetPrice);
    }

    public void addAllTargets(Collection<TargetPrice> targetPrices) {
        targets.addAll(targetPrices);
    }

    public Stream<StopLossPrice> getStopLosses() {
        return stopLosses.stream();
    }

    public void addStopLoss(StopLossPrice stopLossPrice) {
        stopLosses.add(stopLossPrice);
    }

    public void addAllStopLosses(Collection<StopLossPrice> stopLossPrices) {
        stopLosses.addAll(stopLossPrices);
    }

    public Stream<DemandZonePrice> getDemandZones() {
        return demandZones.stream();
    }

    public void addDemandZone(DemandZonePrice demandZonePrice) {
        demandZones.add(demandZonePrice);
    }

    public void addAllDemandZones(Collection<DemandZonePrice> demandZonePrices) {
        demandZones.addAll(demandZonePrices);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockBasicInformation that = (StockBasicInformation) o;
        return Double.compare(that.quantity, quantity) == 0 &&
                Double.compare(that.buyingPrice, buyingPrice) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(stockSymbols, that.stockSymbols) &&
                Objects.equals(targets, that.targets) &&
                Objects.equals(stopLosses, that.stopLosses) &&
                Objects.equals(demandZones, that.demandZones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stockSymbols, quantity, buyingPrice, targets, stopLosses, demandZones);
    }

    @Override
    public String toString() {
        return "StockBasicInformation{" +
                "name='" + name + '\'' +
                ", stockSymbols=" + stockSymbols +
                ", quantity=" + quantity +
                ", buyingPrice=" + buyingPrice +
                ", targets=" + targets +
                ", stopLosses=" + stopLosses +
                ", demandZones=" + demandZones +
                '}';
    }
}
