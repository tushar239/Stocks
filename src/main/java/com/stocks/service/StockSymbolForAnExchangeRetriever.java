package com.stocks.service;

import com.stocks.dao.dto.Exchange;
import com.stocks.service.dto.StockSymbol;

import java.util.Collection;
import java.util.Optional;

public class StockSymbolForAnExchangeRetriever implements IStockSymbolForAnExchangeRetriever<Collection<StockSymbol>, Exchange, StockSymbol> {

    @Override
    public Optional<StockSymbol> retrieve(Collection<StockSymbol> stockSymbols, Exchange exchange) {
        return stockSymbols.stream().filter(stockSymbol -> stockSymbol.getExchange().equals(exchange)).findFirst();
    }
}
