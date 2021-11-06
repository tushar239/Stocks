package com.stocks.dao;

import com.stocks.dao.dto.StockSymbol;
import com.stocks.dao.dto.StockSymbols;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Deprecated
public interface IStockSymbolLoader {
    StockSymbols load(String companyName);
}
