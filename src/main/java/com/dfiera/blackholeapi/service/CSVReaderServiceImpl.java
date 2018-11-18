package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockData;
import com.dfiera.blackholeapi.repository.StockDataRepository;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CSVReaderServiceImpl implements CSVReaderService{

    private final StockDataRepository stockDataRepository;

    public CSVReaderServiceImpl(StockDataRepository stockDataRepository) {
        this.stockDataRepository = stockDataRepository;
    }

    @Override
    public void parseCSV(File file) {
        BeanListProcessor<StockData> rowProcessor = new BeanListProcessor<>(StockData.class);

        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setRowProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);
        parserSettings.setSkipEmptyLines(true);
        parserSettings.setLineSeparatorDetectionEnabled(true);

        CsvParser parser = new CsvParser(parserSettings);

        parser.parse(file);

        List<StockData> beans = rowProcessor.getBeans();

        String company = file.getName().replaceAll(".csv", "");

        List<StockData> stockDataList = stockDataRepository.findByCompany(company);


        for(StockData data: beans){
            data.setCompany(company);

            boolean flag = true;

            if(!stockDataList.isEmpty()) {
                for(StockData stockData: stockDataList) {
                    if(stockData.equalsTo(data)) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                stockDataRepository.save(data);
            }
        }
        file.delete();
    }
}
