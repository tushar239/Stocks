package com.stocks.service;

import com.stocks.dao.dto.Exchange;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockSymbol;

import java.util.List;

public class AllStockBasicInformationRetriever implements IAllStockBasicInformationRetriever {

    @Override
    public List<StockBasicInformation> retrieveAll() {
        // TODO: write code to retrieve basic information Orders.xls
        StockBasicInformation sbi1 = new StockBasicInformation();
        StockSymbol ss1 = new StockSymbol();
        ss1.setExchange(Exchange.BSE);
        ss1.setSymbol("517569");

        StockSymbol ss2 = new StockSymbol();
        ss2.setExchange(Exchange.NSE);
        ss2.setSymbol("KEI");

        sbi1.setStockSymbols(List.of(ss1, ss2));

        List<StockBasicInformation> stocks = List.of(sbi1);

        return stocks;
    }
}
