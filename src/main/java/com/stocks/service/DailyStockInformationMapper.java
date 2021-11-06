package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.dao.dto.dailystockinfo.TimeSeriesDaily;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;
import com.stocks.service.dto.StockValues;
import com.stocks.service.dto.TimeFrameEnum;

import java.util.*;

public class DailyStockInformationMapper implements IStockInformationMapper {

    @Override
    public StockInformation map(StockBasicInformation stockBasicInformation, StockDailyInformation stockDailyInformation) {
        StockInformation stockInformation = new StockInformation();
        stockInformation.setStockBasicInformation(stockBasicInformation);
        stockInformation.setTimeFrame(TimeFrameEnum._DAY);

        Map<Date, TimeSeriesDaily> timeSeriesDaily = stockDailyInformation.getTimeSeriesDaily();
        final SortedMap<Date, StockValues> stockValuesByDate = new TreeMap<>(Collections.reverseOrder());

        // TODO: create spring bean
        final StockValuesMapper stockValuesMapper = new StockValuesMapper();
        timeSeriesDaily.entrySet().stream()
                .forEach(entry -> stockValuesByDate.put(entry.getKey(), stockValuesMapper.map(entry.getValue())));

        stockInformation.setStockValues(stockValuesByDate);

        return stockInformation;
    }
}
