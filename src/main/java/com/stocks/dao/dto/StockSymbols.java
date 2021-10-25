package com.stocks.dao.dto;

import java.util.LinkedList;
import java.util.List;

public class StockSymbols {
    private List<StockSymbol> stockSymbols;

    public StockSymbols() {
        this.stockSymbols = new LinkedList<>();
    }

    public void add(StockSymbol stockSymbol) {
        stockSymbols.add(stockSymbol);
    }

    public List<StockSymbol> getStockSymbols() {
        return stockSymbols;
    }
}
