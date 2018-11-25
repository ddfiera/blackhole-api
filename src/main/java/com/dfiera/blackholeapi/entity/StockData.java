package com.dfiera.blackholeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockData {

    @Id
    private String id;
    private Quote quote;
    private List<Chart> chart;

    public StockData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public List<Chart> getChart() {
        return chart;
    }

    public void setChart(List<Chart> chart) {
        this.chart = chart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockData stockData = (StockData) o;
        return Objects.equals(id, stockData.id) &&
                Objects.equals(quote, stockData.quote) &&
                Objects.equals(chart, stockData.chart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quote, chart);
    }

    @Override
    public String toString() {
        return "StockData{" +
                "id='" + id + '\'' +
                ", quote=" + quote +
                ", chart=" + chart +
                '}';
    }
}
