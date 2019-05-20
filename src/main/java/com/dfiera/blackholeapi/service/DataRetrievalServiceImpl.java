package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.repository.StockDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DataRetrievalServiceImpl implements DataRetrievalService {

    private final StockDataRepository stockDataRepository;
    private final RestTemplate restTemplate;

    public DataRetrievalServiceImpl(final StockDataRepository stockDataRepository,
                                    final RestTemplate restTemplate) {
        this.stockDataRepository = stockDataRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public StockData retrieveData(String company) {

        String url = "https://api.iextrading.com/1.0/stock/" + company + "/batch?types=quote,chart&filter=symbol,companyName,sector,date,open,close,high,low,latestVolume,avgTotalVolume,marketCap,peRatio,volume&range=5y";

        return this.restTemplate.getForObject(url, StockData.class);
    }

    @Override
    public void saveData(StockData stockData) {
        stockDataRepository.save(stockData);
    }

    @Override
    public List<StockData> retrieveAllData() {
        return stockDataRepository.findAll();
    }
}
