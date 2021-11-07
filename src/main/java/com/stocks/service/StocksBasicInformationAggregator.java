package com.stocks.service;

import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StocksBasicInformation;

import java.util.HashMap;
import java.util.Map;

public class StocksBasicInformationAggregator implements IStocksBasicInformationAggregator<StocksBasicInformation> {
    @Override
    public StocksBasicInformation aggregate(StocksBasicInformation stocks) {

        final Map<String, StockBasicInformation> companyNameStockInformation = new HashMap<>();

        stocks.getStream().forEach(newStockInfo -> {
            if(companyNameStockInformation.containsKey(newStockInfo.getName())) {
                // TODO: add aggregation logic like aggregating all targets, stop losses, demand zones, comments, most importantly average buying price and quantity

                final StockBasicInformation existingStockInfo = companyNameStockInformation.get(newStockInfo.getName());
                final double totalQuantity = getTotalQuantity(newStockInfo, existingStockInfo);
                final double averageBuyingPrice = getAverageBuyingPrice(newStockInfo, existingStockInfo, totalQuantity);

                existingStockInfo.setQuantity(totalQuantity);
                existingStockInfo.setBuyingPrice(averageBuyingPrice);

            } else {
                companyNameStockInformation.put(newStockInfo.getName(), newStockInfo);
            }
        });

        final StocksBasicInformation aggregatedStocksBasicInformation = new StocksBasicInformation();
        companyNameStockInformation.forEach((companyName, stockInformation) -> aggregatedStocksBasicInformation.add(stockInformation));

/*        final StocksBasicInformation aggregatedStocksBasicInformation = new StocksBasicInformation();
        stocks.getStream().forEach(stock -> aggregatedStocksBasicInformation.add(stock));*/
        return aggregatedStocksBasicInformation;
    }

    private double getAverageBuyingPrice(StockBasicInformation stock, StockBasicInformation sbi, double totalQuantity) {
        return ((sbi.getBuyingPrice() * sbi.getQuantity()) + (stock.getBuyingPrice() * stock.getQuantity())) / totalQuantity;
    }

    private double getTotalQuantity(StockBasicInformation stock, StockBasicInformation sbi) {
        return sbi.getQuantity() +  stock.getQuantity();
    }
}
