package com.dfiera.blackholeapi.repository;

import com.dfiera.blackholeapi.entity.StockData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDataRepository extends MongoRepository<StockData, String> {
    List<StockData> findByCompany(String company);
}
