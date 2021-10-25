package com.stocks;

import com.stocks.dao.dto.Exchange;
import com.stocks.dao.dto.StockSymbol;
import com.stocks.dao.dto.StockSymbols;

import java.util.Optional;

public interface IStockSymbolExtractor {
    Optional<StockSymbol> extract(StockSymbols stockSymbols, Exchange exchange);
}
