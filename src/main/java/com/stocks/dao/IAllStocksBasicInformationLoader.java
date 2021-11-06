package com.stocks.dao;

import com.stocks.dao.dto.StockBasicInformation;
import com.stocks.dao.dto.StocksBasicInformation;

public interface IAllStocksBasicInformationLoader {
    StocksBasicInformation load();
}
