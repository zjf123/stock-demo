package com.ocean.service.impl;

import com.ocean.dao.StockInfoMapper;
import com.ocean.data.SpiderData;
import com.ocean.pojo.StockInfo;
import com.ocean.service.IStockService;
import com.ocean.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "stockService")
public class StockServiceImpl implements IStockService {

    @Autowired
    private StockInfoMapper stockInfoMapper;
    @Autowired
    private SpiderData spiderData;

    @Override
    public List findByCondition(StockInfo stockInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", stockInfo.getCode());
        params.put("datastr", stockInfo.getDatastr());

        return stockInfoMapper.findByCondition(params);
    }

    @Override
    public void save(StockInfo stockInfo) {
        stockInfoMapper.insertSelective(stockInfo);
    }

    @Override
    public void delete(StockInfo stockInfo) {
        stockInfoMapper.deleteByPrimaryKey(stockInfo.getPkid());
    }

    @Override
    public List<StockInfo> doSomething() {
        List<StockInfo> stockList = spiderData.getData(true);
        for (StockInfo stock : stockList) {
            StockInfo tmp = new StockInfo();
            tmp.setCode(stock.getCode());
            tmp.setDatastr(DateUtil.getYesterday());
            List list = findByCondition(tmp);
            if (null != list && list.size() > 0) {
                StockInfo tmp2 = (StockInfo) list.get(0);
                tmp2.setTimes(tmp2.getTimes()+1);
                tmp2.setDatastr(DateUtil.getToday());
                stockInfoMapper.updateByPrimaryKeySelective(tmp2);
            } else {
                save(stock);
            }
        }
        System.out.println(stockList.size() + " is done ");
        return stockList;
    }
}
