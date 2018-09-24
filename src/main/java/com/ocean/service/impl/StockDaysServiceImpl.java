package com.ocean.service.impl;

import com.ocean.dao.StockDaysInfoMapper;
import com.ocean.data.SpiderData;
import com.ocean.pojo.StockDaysInfo;
import com.ocean.service.IStockDaysService;
import com.ocean.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "stockDaysService")
public class StockDaysServiceImpl implements IStockDaysService {

    @Autowired
    private StockDaysInfoMapper stockDaysInfoMapper;
    @Autowired
    private SpiderData spiderData;

    @Override
    public List findByCondition(StockDaysInfo stockInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("code", stockInfo.getCode());
        params.put("datastr", stockInfo.getDatastr());

        return stockDaysInfoMapper.findByCondition(params);
    }

    @Override
    public void save(StockDaysInfo stockInfo) {
        stockDaysInfoMapper.insertSelective(stockInfo);
    }

    @Override
    public void delete(StockDaysInfo stockInfo) {
        stockDaysInfoMapper.deleteByPrimaryKey(stockInfo.getPkid());
    }

    @Override
    public List<StockDaysInfo> doSomething(int day) {
        List<StockDaysInfo> stockList = spiderData.getStockDaysInfo(true,day);
        for (StockDaysInfo stock : stockList) {
            StockDaysInfo tmp = new StockDaysInfo();
            tmp.setCode(stock.getCode());
            tmp.setDatastr(DateUtil.getYesterday());
            List list = findByCondition(tmp);
            if (null != list && list.size() > 0) {
                StockDaysInfo tmp2 = (StockDaysInfo) list.get(0);
                tmp2.setTimes(tmp2.getTimes()+1);
                tmp2.setDatastr(DateUtil.getToday());
                stockDaysInfoMapper.updateByPrimaryKeySelective(tmp2);
            } else {
                save(stock);
            }
        }
        System.out.println(stockList.size() + " is done ");
        return stockList;
    }
}
