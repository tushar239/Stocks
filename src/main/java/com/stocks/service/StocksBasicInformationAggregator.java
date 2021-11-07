package com.stocks.service;

import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StocksBasicInformation;

import java.util.HashMap;
import java.util.Map;

public class StocksBasicInformationAggregator implements IStocksBasicInformationAggregator<StocksBasicInformation> {
    @Override
    public StocksBasicInformation aggregate(StocksBasicInformation stocks) {

        /*final Map<String, StockBasicInformation> companyNameStockInformation = new HashMap<>();

        stocks.getStream().forEach(stock -> {
            if(companyNameStockInformation.containsKey(stock.getName())) {
                // TODO: add aggregation logic
            } else {
                companyNameStockInformation.put(stock.getName(), stock);
            }
        });

        final StocksBasicInformation aggregatedStocksBasicInformation = new StocksBasicInformation();
        companyNameStockInformation.forEach((key, value) -> aggregatedStocksBasicInformation.add(value));*/

        final StocksBasicInformation aggregatedStocksBasicInformation = new StocksBasicInformation();
        stocks.getStream().forEach(stock -> aggregatedStocksBasicInformation.add(stock));
        return aggregatedStocksBasicInformation;
    }
}
