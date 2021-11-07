package com.stocks.service;

import com.stocks.dao.IAllStocksBasicInformationLoader;
import com.stocks.dao.dto.Exchange;
import com.stocks.service.dto.StocksBasicInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockSymbol;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class AllStocksBasicInformationRetriever implements IAllStocksBasicInformationRetriever {

    private IAllStocksBasicInformationLoader allStocksBasicInformationLoader;

    public AllStocksBasicInformationRetriever(IAllStocksBasicInformationLoader allStocksBasicInformationLoader) {
        this.allStocksBasicInformationLoader = allStocksBasicInformationLoader;
    }

    @Override
    public StocksBasicInformation retrieveAll() {

        StocksBasicInformation stocksBasicInformation = new StocksBasicInformation();

        final List<com.stocks.dao.dto.StockBasicInformation> stocks = allStocksBasicInformationLoader.load().getStocks();

        for (com.stocks.dao.dto.StockBasicInformation stock : stocks) {
            StockBasicInformation stockBasicInformation = new StockBasicInformation();

            List<StockSymbol> stockSymbols = new LinkedList<>();

            final String bseSymbol = stock.getBseSymbol();
            if(StringUtils.isNotEmpty(bseSymbol)) {
                StockSymbol ss = new StockSymbol();
                ss.setExchange(Exchange.BSE);
                ss.setSymbol(bseSymbol);
                stockSymbols.add(ss);
            }

            final String nseSymbol = stock.getNseSymbol();
            if(StringUtils.isNotEmpty(nseSymbol)) {
                StockSymbol ss = new StockSymbol();
                ss.setExchange(Exchange.NSE);
                ss.setSymbol(nseSymbol);
                stockSymbols.add(ss);
            }

            stockBasicInformation.setStockSymbols(stockSymbols);

            stocksBasicInformation.add(stockBasicInformation);
        }

        // TODO: write code to retrieve basic information Orders.xls
        /*StockBasicInformation sbi1 = new StockBasicInformation();
        StockSymbol ss1 = new StockSymbol();
        ss1.setExchange(Exchange.BSE);
        ss1.setSymbol("517569");

        StockSymbol ss2 = new StockSymbol();
        ss2.setExchange(Exchange.NSE);
        ss2.setSymbol("KEI");

        sbi1.setStockSymbols(List.of(ss1, ss2));

        List<StockBasicInformation> stocksBasicInformation = List.of(sbi1);*/

        return stocksBasicInformation;
    }
}
