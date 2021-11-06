package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;

import java.util.Optional;

public interface IDailyStockInformationLoaderService {
    Optional<StockInformation> execute(StockBasicInformation sbi);
}
