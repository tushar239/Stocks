package com.stocks.service;

import com.stocks.dao.DailyStockInformationLoader;
import com.stocks.dao.dto.Exchange;
import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;
import com.stocks.service.dto.StockSymbol;

import java.util.List;
import java.util.Optional;

public class DailyStockInformationLoaderService implements IDailyStockInformationLoaderService {
    private DailyStockInformationLoader dailyStockInformationLoader;

    public DailyStockInformationLoaderService(DailyStockInformationLoader dailyStockInformationLoader) {
        this.dailyStockInformationLoader = dailyStockInformationLoader;
    }

    @Override
    public Optional<StockInformation> execute(StockBasicInformation sbi) {

        // TODO: create spring bean
        final DailyStockInformationMapper mapper = new DailyStockInformationMapper();

        final Optional<StockDailyInformation> stockDailyInformation = getStockDailyInformation(sbi.getStockSymbols());
        final Optional<StockInformation> stockInformation = stockDailyInformation.map(sdi -> mapper.map(sbi, sdi));
        return stockInformation;
    }

    private StockDailyInformation getStockDailyInformation(StockSymbol stockSymbol) {
        // TODO: put timeframe in properties file
        return dailyStockInformationLoader.load("TIME_SERIES_DAILY_ADJUSTED", stockSymbol.getSymbol() + ".BSE");
    }

    private Optional<StockDailyInformation> getStockDailyInformation(List<StockSymbol> stockSymbols) {
        StockDailyInformation stockDailyInformation = null;

        IStockSymbolForAnExchangeRetriever<List<StockSymbol>, Exchange, StockSymbol> stockSymbolForAnExchangeRetriever = new StockSymbolForAnExchangeRetriever();

        Optional<StockSymbol> bseStockSymbol= stockSymbolForAnExchangeRetriever.retrieve(stockSymbols, Exchange.BSE);
        Optional<StockSymbol> nseStockSymbol= stockSymbolForAnExchangeRetriever.retrieve(stockSymbols, Exchange.NSE);

        if(bseStockSymbol.isPresent()) {
            try {
                stockDailyInformation = getStockDailyInformation(bseStockSymbol.get());
            } catch (Exception e) {
                if(nseStockSymbol.isPresent()) {
                    stockDailyInformation = getStockDailyInformation(nseStockSymbol.get());
                }
            }
        } else {
            if(nseStockSymbol.isPresent()) {
                stockDailyInformation = getStockDailyInformation(nseStockSymbol.get());
            }
        }
        return Optional.ofNullable(stockDailyInformation);
    }
}
