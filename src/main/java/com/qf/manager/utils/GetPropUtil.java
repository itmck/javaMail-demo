package com.qf.manager.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Create by it_mck 2018/10/19 16:51
 *
 * @Description: 获取配置文件工具类
 * @Version: 1.0
 */
public class GetPropUtil {

    /**
     *
     *
     * @param resourcesName 配置文件的名称
     * @param key 要获取的key
     * @return
     */
    private static String getProp(String resourcesName,String key) {

        Properties prop = new Properties();
        try {
            prop.load(ClassLoader.getSystemResourceAsStream(resourcesName));
            return (String)prop.get(key);
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            System.out.println("空指针异常, 找不到这个配置文件");
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            System.out.println("流读取异常");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取配置文件信息: " + resourcesName + " 失败");
            return null;
        }
    }


    public static void main(String[] args) {

        String prop = GetPropUtil.getProp("db.properties", "javaMail.userName");
        System.out.println(prop);
    }

}
