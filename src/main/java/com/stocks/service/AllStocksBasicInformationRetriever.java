package com.stocks.service;

import com.stocks.dao.IAllStocksBasicInformationLoader;
import com.stocks.dao.dto.Exchange;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockSymbol;
import com.stocks.service.dto.StockSymbols;
import com.stocks.service.dto.StocksBasicInformation;
import org.apache.commons.lang3.StringUtils;

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

            stockBasicInformation.setName(stock.getName());

            stockBasicInformation.setBuyingPrice(stock.getBuyingPrice() != null ? stock.getBuyingPrice() : 0);
            stockBasicInformation.setQuantity(stock.getQuantity() != null ? stock.getQuantity() : 0);

            StockSymbols stockSymbols = getStockSymbols(stock);
            stockBasicInformation.addAllStockSymbols(stockSymbols.getStockSymbols());

            stocksBasicInformation.add(stockBasicInformation);
        }

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

    // TODO: put it in another class
    private StockSymbols getStockSymbols(com.stocks.dao.dto.StockBasicInformation stock) {
        StockSymbols stockSymbols = new StockSymbols();

        final String bseSymbol = stock.getBseSymbol();
        if (StringUtils.isNotEmpty(bseSymbol)) {
            StockSymbol stockSymbol = new StockSymbol();
            stockSymbol.setExchange(Exchange.BSE);
            stockSymbol.setSymbol(bseSymbol);
            stockSymbols.add(stockSymbol);
        }

        final String nseSymbol = stock.getNseSymbol();
        if (StringUtils.isNotEmpty(nseSymbol)) {
            StockSymbol stockSymbol = new StockSymbol();
            stockSymbol.setExchange(Exchange.NSE);
            stockSymbol.setSymbol(nseSymbol);
            stockSymbols.add(stockSymbol);
        }

        return stockSymbols;
    }
}
