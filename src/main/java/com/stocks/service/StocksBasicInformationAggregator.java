package com.stocks.service;

import com.stocks.service.dto.StocksBasicInformation;

public class StocksBasicInformationAggregator implements IStocksBasicInformationAggregator<StocksBasicInformation> {
    @Override
    public StocksBasicInformation aggregate(StocksBasicInformation stocks) {
        // TODO: add aggregation logic
        return stocks;
    }
}
