package com.stocks.dao;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;

public interface IDailyStockInformationLoader {

    StockDailyInformation load(String timeFrame, String symbol);
}
