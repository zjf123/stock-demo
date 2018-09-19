package com.ocean.service;

import com.ocean.pojo.StockInfo;

import java.util.List;

public interface IStockService {
    List findByCondition(StockInfo stockInfo);

    void save(StockInfo stockInfo);

    void delete(StockInfo stockInfo);

    List<StockInfo> doSomething();
}
