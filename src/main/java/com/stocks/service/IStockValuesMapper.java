package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.TimeSeriesDaily;
import com.stocks.service.dto.StockValues;

public interface IStockValuesMapper {
    StockValues map(TimeSeriesDaily timeSeriesDaily);
}
