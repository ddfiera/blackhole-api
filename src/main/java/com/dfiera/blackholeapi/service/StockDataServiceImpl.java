package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockDataCSV;
import com.dfiera.blackholeapi.repository.StockDataCSVRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockDataServiceImpl implements StockDataService {

    private final StockDataCSVRepository stockDataCSVRepository;

    public StockDataServiceImpl(StockDataCSVRepository stockDataCSVRepository) {
        this.stockDataCSVRepository = stockDataCSVRepository;
    }

    @Override
    public List<StockDataCSV> retrieveAllData() {
        return stockDataCSVRepository.findAll();
    }

    @Override
    public List<StockDataCSV> retrieveDataByCompany(String company){
        return stockDataCSVRepository.findByCompany(company);
    }

    @Override
    public void addData(StockDataCSV stockDataCSV){
        stockDataCSVRepository.save(stockDataCSV);
    }
}
