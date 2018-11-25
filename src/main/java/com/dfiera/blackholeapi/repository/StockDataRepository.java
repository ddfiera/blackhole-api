package com.dfiera.blackholeapi.repository;

import com.dfiera.blackholeapi.entity.StockData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDataRepository extends MongoRepository<StockData, String> {
}
