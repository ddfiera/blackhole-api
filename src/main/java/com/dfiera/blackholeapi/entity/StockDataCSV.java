package com.dfiera.blackholeapi.entity;

import com.univocity.parsers.annotations.Parsed;
import org.springframework.data.annotation.Id;

import java.util.Objects;

public class StockDataCSV {

    @Id
    private String id;

    private String company;
    @Parsed(index = 0)
    private String date;
    @Parsed(index = 1)
    private String time;
    @Parsed(index = 2)
    private Double openBid;
    @Parsed(index = 3)
    private Double highBid;
    @Parsed(index = 4)
    private Double lowBid;
    @Parsed(index = 5)
    private Double closeBid;
    private Long volume;
    private Long marketCap;
    private Float peRatio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getOpenBid() {
        return openBid;
    }

    public void setOpenBid(Double openBid) {
        this.openBid = openBid;
    }

    public Double getHighBid() {
        return highBid;
    }

    public void setHighBid(Double highBid) {
        this.highBid = highBid;
    }

    public Double getLowBid() {
        return lowBid;
    }

    public void setLowBid(Double lowBid) {
        this.lowBid = lowBid;
    }

    public Double getCloseBid() {
        return closeBid;
    }

    public void setCloseBid(Double closeBid) {
        this.closeBid = closeBid;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Float getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Float peRatio) {
        this.peRatio = peRatio;
    }

    public boolean equalsTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDataCSV stockDataCSV = (StockDataCSV) o;
        return  Objects.equals(company, stockDataCSV.company) &&
                Objects.equals(date, stockDataCSV.date) &&
                Objects.equals(time, stockDataCSV.time) &&
                Objects.equals(openBid, stockDataCSV.openBid) &&
                Objects.equals(highBid, stockDataCSV.highBid) &&
                Objects.equals(lowBid, stockDataCSV.lowBid) &&
                Objects.equals(closeBid, stockDataCSV.closeBid) &&
                Objects.equals(volume, stockDataCSV.volume) &&
                Objects.equals(marketCap, stockDataCSV.marketCap) &&
                Objects.equals(peRatio, stockDataCSV.peRatio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDataCSV stockDataCSV = (StockDataCSV) o;
        return  Objects.equals(id, stockDataCSV.id) &&
                Objects.equals(company, stockDataCSV.company) &&
                Objects.equals(date, stockDataCSV.date) &&
                Objects.equals(time, stockDataCSV.time) &&
                Objects.equals(openBid, stockDataCSV.openBid) &&
                Objects.equals(highBid, stockDataCSV.highBid) &&
                Objects.equals(lowBid, stockDataCSV.lowBid) &&
                Objects.equals(closeBid, stockDataCSV.closeBid) &&
                Objects.equals(volume, stockDataCSV.volume) &&
                Objects.equals(marketCap, stockDataCSV.marketCap) &&
                Objects.equals(peRatio, stockDataCSV.peRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, date, time, openBid, highBid, lowBid, closeBid, volume, marketCap, peRatio);
    }

    @Override
    public String toString() {
        return "StockDataCSV{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", openBid=" + openBid +
                ", highBid=" + highBid +
                ", lowBid=" + lowBid +
                ", closeBid=" + closeBid +
                ", volume=" + volume +
                ", marketCap=" + marketCap +
                ", peRatio=" + peRatio +
                '}';
    }
}
