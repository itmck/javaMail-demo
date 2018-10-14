package com.qf.manager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Create by it_mck 2018/10/14 1:56
 *
 * @Description: 时间+uuid+自定义后缀
 * @Version: 1.0
 */
public class UUIDUtils {

    public static String getUUID(){


        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = format.format(date);
        return s+UUID.randomUUID().toString().replace("-","")+"mck";
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        String s = format.format(date);
        System.out.println(s+UUID.randomUUID().toString().replace("-","")+"mck");
    }
}
