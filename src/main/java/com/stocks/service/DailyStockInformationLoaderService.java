package com.stocks.service;

import com.stocks.dao.DailyStockInformationLoader;
import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;

public class DailyStockInformationLoaderService implements IDailyStockInformationLoaderService {
    private DailyStockInformationLoader dailyStockInformationLoader;

    public DailyStockInformationLoaderService(DailyStockInformationLoader dailyStockInformationLoader) {
        this.dailyStockInformationLoader = dailyStockInformationLoader;
    }

    @Override
    public StockDailyInformation execute() {
        StockDailyInformation stockDailyInformation = dailyStockInformationLoader.load("TIME_SERIES_DAILY_ADJUSTED", "517569.BSE");
        System.out.println(stockDailyInformation);
        return stockDailyInformation;
    }
}
