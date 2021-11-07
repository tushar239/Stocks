package com.stocks.service;

public interface IStocksBasicInformationAggregator<I> {

    I aggregate(I input);
}
