package com.stocks.service;

import com.stocks.dao.DailyStockInformationLoader;
import com.stocks.dao.dto.Exchange;
import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;

public class DailyStockInformationLoaderService implements IDailyStockInformationLoaderService {
    private DailyStockInformationLoader dailyStockInformationLoader;

    public DailyStockInformationLoaderService(DailyStockInformationLoader dailyStockInformationLoader) {
        this.dailyStockInformationLoader = dailyStockInformationLoader;
    }

    @Override
    public StockInformation execute() {
        //StockBasicInformation stockBasicInformation = ;// TODO: retrieve from the service
        StockBasicInformation stockBasicInformation = new StockBasicInformation();
        stockBasicInformation.setExchange(Exchange.BSE);
        stockBasicInformation.setSymbol("517569");
        stockBasicInformation.setName("KEI Industries Ltd.");

        // TODO: put timeframe in properties file
        StockDailyInformation stockDailyInformation = dailyStockInformationLoader.load("TIME_SERIES_DAILY_ADJUSTED", stockBasicInformation.getSymbol()+".BSE");
        System.out.println(stockDailyInformation);

        // TODO: create spring bean
        DailyStockInformationMapper mapper = new DailyStockInformationMapper();
        StockInformation stockInformation = mapper.map(stockBasicInformation, stockDailyInformation);

        return stockInformation;
    }
}
