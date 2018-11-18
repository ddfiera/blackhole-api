package com.dfiera.blackholeapi.web;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.service.CSVReaderService;
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

    public ApiController(final StockDataService stockDataService,
                         final CSVReaderService csvReaderService) {
        this.stockDataService = stockDataService;
        this.csvReaderService = csvReaderService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/get/data", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<StockData>> getData(){

        List<StockData> stockDataList = stockDataService.retrieveAllData();

        if(stockDataList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(stockDataList, HttpStatus.OK);
    }

    @GetMapping(value = "/get/data/{company}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<StockData>> getDataByCompany(@PathVariable("company") String company){

        List<StockData> stockDataList = stockDataService.retrieveDataByCompany(company);

        if(stockDataList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(stockDataList, HttpStatus.OK);
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
