package com.ocean.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ocean.pojo.StockDaysInfo;
import com.ocean.pojo.StockInfo;
import com.ocean.util.DateUtil;
import com.ocean.util.FileUtils;
import com.ocean.util.Native2AsciiUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/19.
 */
@Component
public class SpiderData {
//    public static void main(String[] args) throws Exception {
//        SpiderData data = new SpiderData();
////        List<StockInfo> list = data.getData(false);
////        System.out.println(list);
//
//        data.getDataInfoFromJqkaCenter(true, 6);
//    }

    private JSONObject getDataInfo(boolean writeFlag) throws Exception {
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建一个GET对象
        HttpGet get = new HttpGet("http://search.10jqka.com.cn/stockpick/search?ts=1&f=1&qs=stockhome_topbar_click&w=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF");
//        HttpGet get = new HttpGet("https://www.iwencai.com/stockpick/load-data?typed=0&preParams=&ts=1&f=1&qs=result_original&selfsectsn=&querytype=stock&searchfilter=&tid=stockpick&w=%E8%BF%9E%E7%BB%AD5%E6%A4%A9%E9%98%B3%E7%BA%BF&queryarea=");

        //分页查询接口
        //https://www.iwencai.com/stockpick/cache?token=acf787b490e742d6d4245b7f3bfe5519&p=2&perpage=30&showType=[%22%22,%22%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22]


        //        HttpGet get = new HttpGet("http://search.10jqka.com.cn/asyn/search?q=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF&queryType=stock&app=qnas&qid=");
        //        HttpGet get = new HttpGet("http://search.10jqka.com.cn/robot-index/get-robot-data?version=1.6&source=ths_mobile_iwencai&user_id=0&user_name=0&question=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF+&secondary_intent=stock&add_info=%7B%22urp%22%3A%7B%22scene%22%3A3%2C%22company%22%3A1%2C%22business%22%3A1%7D%7D&_=1537234463780");
        get.setHeader("Accept", "application/json");
        get.setHeader("Accept-Encoding", "gzip, deflate");
        get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        get.setHeader("Connection", "keep-alive");
        get.setHeader("Host", "search.10jqka.com.cn");
        get.setHeader("hexin-v", "AutYeJrGNJI7GmhGG4d52QF0egTWAP-KeRTDNl1oxyqB_AHy5dCP0onkU4Ru");
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        get.setHeader("Referer", "http://search.10jqka.com.cn/html/wencaimobileresult/result.html?q=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF%20&queryType=stock");
        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);

        //取响应的结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity, "utf-8");
        String json = Native2AsciiUtils.ascii2Native(string).replace("\\万", "万").replace("\\亿", "亿");
        String jsonString = json.substring(json.indexOf("var allResult =") + "var allResult =".length(), json.indexOf("\"isVertical\":false};") + "\"isVertical\":false};".length() - 1);
//        System.out.println(jsonString);
        JSONObject jsonObject = JSON.parseObject(jsonString);

        if (writeFlag) {
            String file = "src/main/resources/data/bak.txt";
            FileUtils.fileChaseFW(file, jsonString, true);
        }

        response.close();
        httpClient.close();

        return jsonObject;
    }


    private JSONObject getDataInfoFromJqkaCenter(boolean writeFlag, int day) throws Exception {
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建一个GET对象
        HttpGet get = new HttpGet("http://search.10jqka.com.cn/stockpick/search?ts=1&f=1&qs=stockhome_topbar_click&w=%E8%BF%9E%E7%BB%AD" + day + "%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF");
//        HttpGet get = new HttpGet("https://www.iwencai.com/stockpick/load-data?typed=0&preParams=&ts=1&f=1&qs=result_original&selfsectsn=&querytype=stock&searchfilter=&tid=stockpick&w=%E8%BF%9E%E7%BB%AD5%E6%A4%A9%E9%98%B3%E7%BA%BF&queryarea=");

        //分页查询接口
        //https://www.iwencai.com/stockpick/cache?token=acf787b490e742d6d4245b7f3bfe5519&p=2&perpage=30&showType=[%22%22,%22%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22]


        //        HttpGet get = new HttpGet("http://search.10jqka.com.cn/asyn/search?q=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF&queryType=stock&app=qnas&qid=");
        //        HttpGet get = new HttpGet("http://search.10jqka.com.cn/robot-index/get-robot-data?version=1.6&source=ths_mobile_iwencai&user_id=0&user_name=0&question=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF+&secondary_intent=stock&add_info=%7B%22urp%22%3A%7B%22scene%22%3A3%2C%22company%22%3A1%2C%22business%22%3A1%7D%7D&_=1537234463780");
        get.setHeader("Accept", "application/json");
        get.setHeader("Accept-Encoding", "gzip, deflate");
        get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        get.setHeader("Connection", "keep-alive");
        get.setHeader("Host", "search.10jqka.com.cn");
        get.setHeader("hexin-v", "AutYeJrGNJI7GmhGG4d52QF0egTWAP-KeRTDNl1oxyqB_AHy5dCP0onkU4Ru");
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        get.setHeader("Referer", "http://search.10jqka.com.cn/html/wencaimobileresult/result.html?q=%E8%BF%9E%E7%BB%AD6%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF%20&queryType=stock");
        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);

        //取响应的结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity, "utf-8");
        String json = Native2AsciiUtils.ascii2Native(string).replace("\\万", "万").replace("\\亿", "亿");
        String jsonString = json.substring(json.indexOf("var allResult =") + "var allResult =".length(), json.indexOf("\"isVertical\":false};") + "\"isVertical\":false};".length() - 1);
//        System.out.println(jsonString);
        JSONObject jsonObject = JSON.parseObject(jsonString);

        if (writeFlag) {
            JSONArray result = (JSONArray) jsonObject.get("result");
            String file = "src/main/resources/data/bak" + day + ".txt";
            FileUtils.fileChaseFW(file, JSON.toJSONString(result), true);
        }

        response.close();
        httpClient.close();
        String token = (String) jsonObject.get("token");

        if (null != token && !"".equals(token)) {
            return getDataFromJqkaCache(token, writeFlag, day);
        }

        return jsonObject;
    }

    private JSONObject getDataFromJqkaCache(String token, boolean writeFlag, int day) throws Exception {
        //创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建一个GET对象
        HttpGet get = new HttpGet("https://www.iwencai.com/stockpick/cache?token=" + token + "&p=1&perpage=600&showType=[%22%22,%22%22,%22onTable%22,%22onTable%22,%22onTable%22,%22onTable%22]");
        get.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        get.setHeader("Accept-Encoding", "gzip, deflate, br");
        get.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        get.setHeader("Cache-Control", "no-cache");
        get.setHeader("Connection", "keep-alive");
        get.setHeader("Host", "www.iwencai.com");
        get.setHeader("hexin-v", "AiEKzgI23li1nnKsbhpDW4fCMOY4zpGnv0g5_oPyHFWHpksQyx6lkE-SSY0Q");
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        get.setHeader("Referer", "http://search.10jqka.com.cn/html/wencaimobileresult/result.html?q=%E8%BF%9E%E7%BB%AD" + day + "%E5%A4%A9%E7%9A%84%E9%98%B3%E7%BA%BF");

        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);

        //取响应的结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity, "utf-8");
        String json = Native2AsciiUtils.ascii2Native(string).replace("\\万", "万").replace("\\亿", "亿");
//        String jsonString = json.substring(json.indexOf("var allResult =") + "var allResult =".length(), json.indexOf("\"isVertical\":false};") + "\"isVertical\":false};".length() - 1);
//        System.out.println(jsonString);
        JSONObject jsonObject = JSON.parseObject(json);

        if (writeFlag) {
            JSONArray result = (JSONArray) jsonObject.get("result");
            String file = "src/main/resources/data/bak" + day + ".txt";
            FileUtils.fileChaseFW(file, JSON.toJSONString(result), true);
        }

        response.close();
        httpClient.close();

        return jsonObject;
    }

    public List<StockInfo> getData(boolean writeFlag) {
        List<StockInfo> stockList = new ArrayList<>();
        try {
            JSONObject jsonObject = getDataInfoFromJqkaCenter(writeFlag, 6);

            if (writeFlag) {
                JSONArray result = (JSONArray) jsonObject.get("result");
                String file = "src/main/resources/data/bak.txt";
                FileUtils.fileChaseFW(file, JSON.toJSONString(result), true);
            }

            String today = DateUtil.getToday();

            List list = (List) jsonObject.get("result");
            for (int i = 0; i < list.size(); i++) {
                List l = (List) list.get(i);
                StockInfo stock = new StockInfo();
                stock.setCode((String) l.get(0));
                stock.setName((String) l.get(1));
                stock.setNewprice((String) l.get(2));
                stock.setIncrease((String) l.get(3));
                stock.setDatastr(today);
                stock.setKeystr("1");

                stock.setTimes(6);
                stock.setStatus("T");
                stock.setIsdelete("N");


                stock.setCreatetime(new Date());
                stock.setModifytime(new Date());

                stockList.add(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stockList;
    }

    public List<StockDaysInfo> getStockDaysInfo(boolean writeFlag, int day) {
        List<StockDaysInfo> stockList = new ArrayList<>();
        try {
            JSONObject jsonObject = getDataInfoFromJqkaCenter(writeFlag, day);
            String today = DateUtil.getToday();

            List list = (List) jsonObject.get("result");
            for (int i = 0; i < list.size(); i++) {
                List l = (List) list.get(i);
                StockDaysInfo stock = new StockDaysInfo();
                stock.setCode((String) l.get(0));
                stock.setName((String) l.get(1));
                stock.setNewprice((String) l.get(2));
                stock.setIncrease((String) l.get(3));
                stock.setDatastr(today);
                stock.setKeystr("1");
                stock.setDays(day);

                stock.setTimes(day);
                stock.setStatus("T");
                stock.setIsdelete("N");

                stock.setCreatetime(new Date());
                stock.setModifytime(new Date());

                stockList.add(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stockList;
    }
}
