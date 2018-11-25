package com.dfiera.blackholeapi.repository;

import com.dfiera.blackholeapi.entity.StockDataCSV;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDataCSVRepository extends MongoRepository<StockDataCSV, String> {
    List<StockDataCSV> findByCompany(String company);
}
