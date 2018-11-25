package com.dfiera.blackholeapi.web;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.entity.StockDataCSV;
import com.dfiera.blackholeapi.service.CSVReaderService;
import com.dfiera.blackholeapi.service.DataRetrievalService;
import com.dfiera.blackholeapi.service.StockDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class ApiController {

    private final StockDataService stockDataService;
    private final CSVReaderService csvReaderService;
    private final DataRetrievalService dataRetrievalService;

    public ApiController(final StockDataService stockDataService,
                         final CSVReaderService csvReaderService,
                         final DataRetrievalService dataRetrievalService) {
        this.stockDataService = stockDataService;
        this.csvReaderService = csvReaderService;
        this.dataRetrievalService = dataRetrievalService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/get/stocks", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<StockData>> getStockData() {

        List<StockData> stockDataList = dataRetrievalService.retrieveAllData();

        if (stockDataList == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(stockDataList, HttpStatus.OK);
    }

    @GetMapping(value = "/populate")
    @ResponseBody
    public void populateDB(@RequestParam(value = "stocks") String[] stocks) {

        for (String stock : stocks) {
            StockData stockData = dataRetrievalService.retrieveData(stock);

            dataRetrievalService.saveData(stockData);
        }
    }

    @GetMapping(value = "/get/data", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<StockDataCSV>> getData() {

        List<StockDataCSV> stockDataCSVList = stockDataService.retrieveAllData();

        if (stockDataCSVList == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(stockDataCSVList, HttpStatus.OK);
    }

    @GetMapping(value = "/get/data/{company}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<StockDataCSV>> getDataByCompany(@PathVariable("company") String company){

        List<StockDataCSV> stockDataCSVList = stockDataService.retrieveDataByCompany(company);

        if (stockDataCSVList == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(stockDataCSVList, HttpStatus.OK);
    }

    @PostMapping(value = "/post/data", consumes = "multipart/form-data")
    public String uploadData(@RequestParam("file") MultipartFile file) throws IOException {
        InputStream in = file.getInputStream();
        File currFile = new File("data.csv");
        String path = currFile.getAbsolutePath();

        FileOutputStream f = new FileOutputStream(path);
        int ch = 0;
        while ((ch = in.read()) != -1) {
            f.write(ch);
        }
        f.flush();
        f.close();

        File parsingFile = new File(path);

        csvReaderService.parseCSV(parsingFile);
        return "redirect:/";
    }
}
