package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.TimeSeriesDaily;
import com.stocks.service.dto.StockValues;

public class StockValuesMapper implements IStockValuesMapper {

    @Override
    public StockValues map(TimeSeriesDaily timeSeriesDaily) {
        StockValues stockValues = new StockValues();
        stockValues.setVolume(timeSeriesDaily.getThe5Volume());
        stockValues.setOpenPrice(timeSeriesDaily.getThe1Open());
        stockValues.setClosePrice(timeSeriesDaily.getThe4Close());
        stockValues.setHighPrice(timeSeriesDaily.getThe2High());
        stockValues.setLowPrice(timeSeriesDaily.getThe3Low());
        return stockValues;
    }
}
