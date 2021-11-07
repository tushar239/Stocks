package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;
import com.stocks.service.dto.StockSymbols;

import java.util.Optional;

public interface IDailyStockInformationRetrieverService {
    Optional<StockInformation> execute(StockBasicInformation stockBasicInformation);
}
