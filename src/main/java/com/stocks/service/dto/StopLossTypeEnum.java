package com.stocks.service.dto;

public enum StopLossTypeEnum {
    UNDECLARED, PREV_CANDLE_LOW,
    _20_MA_LOW, _50_EMA_LOW, _100_EMA_LOW, _150_EMA_LOW, _200_EMA_LOW,
    PREV_TRIANGLE_LOW,
    SUPER_TREND,
    CCI_BELOW_0,
    ICHIMOKU_CLOUD_BOTTOM,
    PARABOLIC_SAR;
}
