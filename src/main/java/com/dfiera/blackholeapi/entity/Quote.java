package com.dfiera.blackholeapi.entity;

import java.util.Objects;

public class Quote {

    private String symbol;
    private String companyName;
    private String sector;
    private Double open;
    private Double close;
    private Double high;
    private Double low;
    private Long latestVolume;
    private Long avgTotalVolume;
    private Long marketCap;
    private Double peRatio;

    public Quote() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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

    public Long getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(Long latestVolume) {
        this.latestVolume = latestVolume;
    }

    public Long getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(Long avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Double peRatio) {
        this.peRatio = peRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(symbol, quote.symbol) &&
                Objects.equals(companyName, quote.companyName) &&
                Objects.equals(sector, quote.sector) &&
                Objects.equals(open, quote.open) &&
                Objects.equals(close, quote.close) &&
                Objects.equals(high, quote.high) &&
                Objects.equals(low, quote.low) &&
                Objects.equals(latestVolume, quote.latestVolume) &&
                Objects.equals(avgTotalVolume, quote.avgTotalVolume) &&
                Objects.equals(marketCap, quote.marketCap) &&
                Objects.equals(peRatio, quote.peRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, companyName, sector, open, close, high, low, latestVolume, avgTotalVolume, marketCap, peRatio);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sector='" + sector + '\'' +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", latestVolume=" + latestVolume +
                ", avgTotalVolume=" + avgTotalVolume +
                ", marketCap=" + marketCap +
                ", peRatio=" + peRatio +
                '}';
    }
}
