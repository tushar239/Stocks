package com.stocks.dao.dto.dailystockinfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class MetaData {
    @JsonProperty("1. Information")
    private String the1Information;
    @JsonProperty("2. Symbol")
    private String the2Symbol;
    @JsonProperty("3. Last Refreshed")
    private LocalDate the3LastRefreshed;
    @JsonProperty("4. Output Size")
    private String the4OutputSize;
    @JsonProperty("5. Time Zone")
    private String the5TimeZone;

    public String getThe1Information() {
        return the1Information;
    }

    public void setThe1Information(String the1Information) {
        this.the1Information = the1Information;
    }

    public String getThe2Symbol() {
        return the2Symbol;
    }

    public void setThe2Symbol(String the2Symbol) {
        this.the2Symbol = the2Symbol;
    }

    public LocalDate getThe3LastRefreshed() {
        return the3LastRefreshed;
    }

    public void setThe3LastRefreshed(LocalDate the3LastRefreshed) {
        this.the3LastRefreshed = the3LastRefreshed;
    }

    public String getThe4OutputSize() {
        return the4OutputSize;
    }

    public void setThe4OutputSize(String the4OutputSize) {
        this.the4OutputSize = the4OutputSize;
    }

    public String getThe5TimeZone() {
        return the5TimeZone;
    }

    public void setThe5TimeZone(String the5TimeZone) {
        this.the5TimeZone = the5TimeZone;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "the1Information='" + the1Information + '\'' +
                ", the2Symbol='" + the2Symbol + '\'' +
                ", the3LastRefreshed=" + the3LastRefreshed +
                ", the4OutputSize='" + the4OutputSize + '\'' +
                ", the5TimeZone='" + the5TimeZone + '\'' +
                '}';
    }
}
