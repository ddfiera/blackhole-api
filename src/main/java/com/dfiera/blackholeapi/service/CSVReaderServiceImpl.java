package com.dfiera.blackholeapi.service;

import com.dfiera.blackholeapi.entity.StockDataCSV;
import com.dfiera.blackholeapi.repository.StockDataCSVRepository;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CSVReaderServiceImpl implements CSVReaderService{

    private final StockDataCSVRepository stockDataCSVRepository;

    public CSVReaderServiceImpl(StockDataCSVRepository stockDataCSVRepository) {
        this.stockDataCSVRepository = stockDataCSVRepository;
    }

    @Override
    public void parseCSV(File file) {
        BeanListProcessor<StockDataCSV> rowProcessor = new BeanListProcessor<>(StockDataCSV.class);

        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setRowProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);
        parserSettings.setSkipEmptyLines(true);
        parserSettings.setLineSeparatorDetectionEnabled(true);

        CsvParser parser = new CsvParser(parserSettings);

        parser.parse(file);

        List<StockDataCSV> beans = rowProcessor.getBeans();

        String company = file.getName().replaceAll(".csv", "");

        List<StockDataCSV> stockDataCSVList = stockDataCSVRepository.findByCompany(company);


        for(StockDataCSV data: beans){
            data.setCompany(company);

            boolean flag = true;

            if(!stockDataCSVList.isEmpty()) {
                for(StockDataCSV stockDataCSV : stockDataCSVList) {
                    if(stockDataCSV.equalsTo(data)) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                stockDataCSVRepository.save(data);
            }
        }
        file.delete();
    }
}
