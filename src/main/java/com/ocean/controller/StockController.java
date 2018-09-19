package com.ocean.controller;

import com.ocean.pojo.StockInfo;
import com.ocean.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/stock"})
public class StockController {

    @Autowired
    private IStockService stockService;

    @RequestMapping(value = {"/do"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<StockInfo> doSomething(){
        List<StockInfo> list =  stockService.doSomething();
       return list;
    }
}
