package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockData;

import java.util.List;

public interface DataRetrievalService {

    StockData retrieveData(String company);

    void saveData(StockData stockData);

    List<StockData> retrieveAllData();
}
