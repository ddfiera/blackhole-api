package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.repository.StockDataRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DataRetrievalServiceImplTest {

    @Mock
    private StockDataRepository stockDataRepository;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private DataRetrievalServiceImpl dataRetrievalService;

    StockData stockData = new StockData();

    @Before
    public void setUp() {
        stockData.setId("1");
    }

    @Test
    public void retrieveDataShouldQueryExternalAPI() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(stockData);
        dataRetrievalService.retrieveData("AAPL");
        verify(restTemplate, times(1)).getForObject(anyString(), any());
    }

    @Test
    public void saveDataShouldStoreDataToDatabase() {
        when(stockDataRepository.save(any())).thenReturn(stockData);
        dataRetrievalService.saveData(stockData);
        verify(stockDataRepository, times(1)).save(any());
    }

    @Test
    public void retrieveAllDataShouldReturnAllDatabaseEntries() {
        when(stockDataRepository.findAll()).thenReturn(Collections.singletonList(stockData));

        List<StockData> stockDataList = dataRetrievalService.retrieveAllData();
        assert(stockDataList.get(0).getId()).equals("1");
    }
}