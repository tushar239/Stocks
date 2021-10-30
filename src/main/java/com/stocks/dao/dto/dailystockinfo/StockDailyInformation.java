package com.stocks.dao.dto.dailystockinfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDailyInformation {

    @JsonProperty("Meta Data")
    private MetaData metaData;
    @JsonProperty("Time Series (Daily)")
    private Map<Date, TimeSeriesDaily> timeSeriesDaily;

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Map<Date, TimeSeriesDaily> getTimeSeriesDaily() {
        return timeSeriesDaily;
    }

    public void setTimeSeriesDaily(Map<Date, TimeSeriesDaily> timeSeriesDaily) {
        this.timeSeriesDaily = timeSeriesDaily;
    }

    @Override
    public String toString() {
        return "StockDailyInformation{" +
                "metaData=" + metaData +
                ", timeSeriesDaily=" + timeSeriesDaily +
                '}';
    }
}
