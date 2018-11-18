package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockData;

import java.util.List;

public interface StockDataService {

    List<StockData> retrieveAllData();

    List<StockData> retrieveDataByCompany(String company);

    void addData(StockData stockData);
}
