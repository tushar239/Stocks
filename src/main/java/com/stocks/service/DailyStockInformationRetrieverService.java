package com.stocks.service;

import com.stocks.dao.IDailyStockInformationLoader;
import com.stocks.dao.dto.Exchange;
import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;
import com.stocks.service.dto.StockSymbol;
import com.stocks.service.mapper.DailyStockInformationMapper;

import java.util.Collection;
import java.util.Optional;

public class DailyStockInformationRetrieverService implements IDailyStockInformationRetrieverService {
    private IDailyStockInformationLoader dailyStockInformationLoader;

    public DailyStockInformationRetrieverService(IDailyStockInformationLoader dailyStockInformationLoader) {
        this.dailyStockInformationLoader = dailyStockInformationLoader;
    }

    @Override
    public Optional<StockInformation> execute(StockBasicInformation stockBasicInformation) {

        // TODO: create spring bean
        final DailyStockInformationMapper mapper = new DailyStockInformationMapper();

        final Optional<StockDailyInformation> stockDailyInformation = getStockDailyInformation(stockBasicInformation.getStockSymbols());
        final Optional<StockInformation> stockInformation = stockDailyInformation.map(sdi -> mapper.map(stockBasicInformation, sdi));
        return stockInformation;
    }

    private StockDailyInformation getStockDailyInformation(StockSymbol stockSymbol) {
        // TODO: put timeframe in properties file
        return dailyStockInformationLoader.load("TIME_SERIES_DAILY_ADJUSTED", stockSymbol.getSymbol() + ".BSE");
    }

    private Optional<StockDailyInformation> getStockDailyInformation(Collection<StockSymbol> stockSymbols) {
        StockDailyInformation stockDailyInformation = null;

        IStockSymbolForAnExchangeRetriever<Collection<StockSymbol>, Exchange, StockSymbol> stockSymbolForAnExchangeRetriever = new StockSymbolForAnExchangeRetriever();

        Optional<StockSymbol> bseStockSymbol = stockSymbolForAnExchangeRetriever.retrieve(stockSymbols, Exchange.BSE);
        Optional<StockSymbol> nseStockSymbol = stockSymbolForAnExchangeRetriever.retrieve(stockSymbols, Exchange.NSE);

        if (bseStockSymbol.isPresent()) {
            try {
                stockDailyInformation = getStockDailyInformation(bseStockSymbol.get());
                if (stockDailyInformation.getTimeSeriesDaily() == null) {
                    stockDailyInformation = getStockDailyInformation(nseStockSymbol.get());
                }
            } catch (Exception e) {
                // TODO: convert it into ServiceException
                throw new RuntimeException("Error while retrieving stock information from external service");
            }
        } else {
            if (nseStockSymbol.isPresent()) {
                stockDailyInformation = getStockDailyInformation(nseStockSymbol.get());
            }
        }
        return Optional.ofNullable(stockDailyInformation);
    }
}
