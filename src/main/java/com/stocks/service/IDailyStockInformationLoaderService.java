package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockInformation;

public interface IDailyStockInformationLoaderService {
    StockInformation execute();
}
