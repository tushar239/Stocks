package com.stocks.service;

import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;

import java.util.List;

public interface IAllStocksBasicInformationRetriever extends IBasicInformationRetriever<Object, StockBasicInformation>{
    List<StockBasicInformation> retrieveAll();
}
