package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockDataCSV;

import java.util.List;

public interface StockDataService {

    List<StockDataCSV> retrieveAllData();

    List<StockDataCSV> retrieveDataByCompany(String company);

    void addData(StockDataCSV stockDataCSV);
}
