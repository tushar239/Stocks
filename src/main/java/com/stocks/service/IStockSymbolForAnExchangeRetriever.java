package com.stocks.service;

import com.stocks.dao.dto.Exchange;
import com.stocks.service.dto.StockSymbol;

import java.util.List;
import java.util.Optional;

public interface IStockSymbolForAnExchangeRetriever<I1 extends List<StockSymbol>, I2 extends Exchange, O extends StockSymbol> {
    Optional<O> retrieve(I1 stockSymbols, I2 exchange);
}
