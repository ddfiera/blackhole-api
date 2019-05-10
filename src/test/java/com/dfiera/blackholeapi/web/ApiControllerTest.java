package com.dfiera.blackholeapi.web;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.service.CSVReaderService;
import com.dfiera.blackholeapi.service.DataRetrievalService;
import com.dfiera.blackholeapi.service.StockDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiControllerTest {

    @MockBean
    private StockDataService stockDataService;
    @MockBean
    private CSVReaderService csvReaderService;
    @MockBean
    private DataRetrievalService dataRetrievalService;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    StockData stockData;

    @Before
    public void setUp() throws Exception {
        stockData = new StockData();
        stockData.setId("1");

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void homeShouldReturn200StatusCode() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void getStockDataShouldReturnAvailableData() throws Exception {
        when(dataRetrievalService.retrieveAllData()).thenReturn(Collections.singletonList(stockData));

        mockMvc.perform(get("/get/stocks"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{ 'id': '1' }]"));
    }

    @Test
    public void getStockDataShouldReturn204StatusCode() throws Exception {
        when(dataRetrievalService.retrieveAllData()).thenReturn(null);

        mockMvc.perform(get("/get/stocks"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void populateDB() throws Exception {
        when(dataRetrievalService.retrieveData(anyString())).thenReturn(stockData);

        mockMvc.perform(get("/populate?stocks=AAPL"))
                .andExpect(status().isOk());

        verify(dataRetrievalService, times(1)).saveData(any());
    }
}