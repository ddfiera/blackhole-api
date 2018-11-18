package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.repository.StockDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockDataServiceImpl implements StockDataService {

    private final StockDataRepository stockDataRepository;

    public StockDataServiceImpl(StockDataRepository stockDataRepository) {
        this.stockDataRepository = stockDataRepository;
    }

    @Override
    public List<StockData> retrieveAllData() {
        return stockDataRepository.findAll();
    }

    @Override
    public List<StockData> retrieveDataByCompany(String company){
        return stockDataRepository.findByCompany(company);
    }

    @Override
    public void addData(StockData stockData){
        stockDataRepository.save(stockData);
    }
}
