package com.ocean.service;

import com.alibaba.fastjson.JSON;
import com.ocean.pojo.StockDaysInfo;
import com.ocean.pojo.StockInfo;
import com.ocean.util.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/10/17.
 */
@Slf4j
@Component
public class ScheduledService {
    @Autowired
    private IStockService stockService;
    @Autowired
    private IStockDaysService stockDaysService;

    @Resource
    private EmailSender emailSender;

    @Scheduled(cron = "0 50 15 ? * *")
    public void scheduled(){
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());

        List<StockInfo> list =  stockService.doSomething();
        List<StockDaysInfo> list2 =  stockDaysService.doSomething(5);

        emailSender.send("stock tips 6 days", JSON.toJSONString(list));
//        emailSender.send("stock tips 5 days", JSON.toJSONString(list2));

    }
//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
//    }
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled2() {
//        log.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
//    }
}
