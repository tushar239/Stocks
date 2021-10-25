package com.stocks;

import com.stocks.dao.dto.Exchange;
import com.stocks.dao.dto.StockSymbol;
import com.stocks.dao.dto.StockSymbols;

import java.util.Optional;

public class StockSymbolExtractor implements IStockSymbolExtractor {
    @Override
    public Optional<StockSymbol> extract(StockSymbols stockSymbols, Exchange exchange) {
        return stockSymbols.getStockSymbols().stream().filter(stockSymbol -> stockSymbol.getExchange() == exchange).findFirst();
    }
}
