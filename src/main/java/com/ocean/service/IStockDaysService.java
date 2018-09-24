package com.ocean.service;

import com.ocean.pojo.StockDaysInfo;

import java.util.List;

public interface IStockDaysService {
    List findByCondition(StockDaysInfo stockInfo);

    void save(StockDaysInfo stockInfo);

    void delete(StockDaysInfo stockInfo);

    List<StockDaysInfo> doSomething(int day);
}
