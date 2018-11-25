package com.dfiera.blackholeapi.entity;

import java.util.Objects;

public class Chart {

    private String date;
    private Double open;
    private Double close;
    private Double high;
    private Double low;
    private Long volume;

    public Chart() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chart chart = (Chart) o;
        return Objects.equals(date, chart.date) &&
                Objects.equals(open, chart.open) &&
                Objects.equals(close, chart.close) &&
                Objects.equals(high, chart.high) &&
                Objects.equals(low, chart.low) &&
                Objects.equals(volume, chart.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, open, close, high, low, volume);
    }

    @Override
    public String toString() {
        return "Chart{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", volume=" + volume +
                '}';
    }
}
