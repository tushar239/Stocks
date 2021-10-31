package com.stocks.service;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;

public interface IStockInformationMapper {
    StockInformation map(StockBasicInformation stockBasicInformation, StockDailyInformation stockDailyInformation);
}
