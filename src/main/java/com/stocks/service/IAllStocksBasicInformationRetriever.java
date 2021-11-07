package com.stocks.service;

import com.stocks.service.dto.StocksBasicInformation;

public interface IAllStocksBasicInformationRetriever extends IBasicInformationRetriever<Object, StocksBasicInformation>{
    StocksBasicInformation retrieveAll();
}
