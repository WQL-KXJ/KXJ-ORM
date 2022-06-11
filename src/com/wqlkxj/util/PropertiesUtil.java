package com.wqlkxj.util;

import com.wqlkxj.bean.ConnectionPojo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.util
 * @Date 2022/5/25 16:59
 * @Version 1.0
 */
public class PropertiesUtil {

    static Properties properties =new Properties();
    static ConnectionPojo connectionPojo;

    //获取配置文件对象
    public static ConnectionPojo getConnectionPojo()  {

        try {
            properties.load(ClassLoader.getSystemResourceAsStream("DBConfig.properties"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return new ConnectionPojo(properties);
    }
}
