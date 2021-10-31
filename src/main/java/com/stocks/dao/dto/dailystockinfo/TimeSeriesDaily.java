package com.stocks.dao.dto.dailystockinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSeriesDaily {
    @JsonProperty("1. open")
    private Double the1Open;
    @JsonProperty("2. high")
    private Double the2High;
    @JsonProperty("3. low")
    private Double the3Low;
    @JsonProperty("4. close")
    private Double the4Close;
    @JsonProperty("5. volume")
    private Long the5Volume;

    public Double getThe1Open() {
        return the1Open;
    }

    public void setThe1Open(Double value) {
        this.the1Open = value;
    }

    public Double getThe2High() {
        return the2High;
    }

    public void setThe2High(Double value) {
        this.the2High = value;
    }

    public Double getThe3Low() {
        return the3Low;
    }

    public void setThe3Low(Double value) {
        this.the3Low = value;
    }

    public Double getThe4Close() {
        return the4Close;
    }

    public void setThe4Close(Double value) {
        this.the4Close = value;
    }

    public Long getThe5Volume() {
        return the5Volume;
    }

    public void setThe5Volume(Long value) {
        this.the5Volume = value;
    }

    @Override
    public String toString() {
        return "TimeSeriesDaily{" +
                "the1Open='" + the1Open + '\'' +
                ", the2High='" + the2High + '\'' +
                ", the3Low='" + the3Low + '\'' +
                ", the4Close='" + the4Close + '\'' +
                ", the5Volume='" + the5Volume + '\'' +
                '}';
    }
}
