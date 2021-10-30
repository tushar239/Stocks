package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;

public interface IDailyStockInformationLoaderService {
    StockDailyInformation execute();
}
