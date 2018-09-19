package com.ocean.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * TODO 描述
 * Created by bd007 on 2018/9/19.
 */
public class FileUtils {

    /**
     * 写入TXT，追加写入
     * @param filePath
     * @param content
     */
    public static void fileChaseFW(String filePath, String content,boolean newLineFlag) {
        try {
            //构造函数中的第二个参数true表示以追加形式写文件
            FileWriter fw = new FileWriter(filePath,true);
            BufferedWriter bw= new BufferedWriter(fw);
            if(newLineFlag) {
                bw.write("=============================" + DateUtil.getDate(new Date()) + "================================");
                bw.newLine();
            }
            bw.write(content);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            System.out.println("文件写入失败！" + e);
        }
    }

    public static void main(String[] args) {
        String file ="src/main/resources/data/bak.txt";
        FileUtils.fileChaseFW(file,"123",true);
    }
}
