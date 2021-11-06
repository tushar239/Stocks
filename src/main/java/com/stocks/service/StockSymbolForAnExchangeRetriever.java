package com.stocks.service;

import com.stocks.dao.dto.Exchange;
import com.stocks.service.dto.StockSymbol;

import java.util.List;
import java.util.Optional;

public class StockSymbolForAnExchangeRetriever implements IStockSymbolForAnExchangeRetriever<List<StockSymbol>, Exchange, StockSymbol> {

    @Override
    public Optional<StockSymbol> retrieve(List<StockSymbol> stockSymbols, Exchange exchange) {
        return stockSymbols.stream().filter(stockSymbol -> stockSymbol.getExchange().equals(exchange)).findFirst();
    }
}
