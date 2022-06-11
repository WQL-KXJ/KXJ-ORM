package com.wqlkxj.bean;

import java.util.Properties;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.util
 * @Date 2022/5/25 16:47
 * @Version 1.0
 */
public class ConnectionPojo {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Integer poolMaxCacheConnections;
    private Integer poolMaxFreeConnections;
    private Integer poolTimeToWait;

    public ConnectionPojo(Properties properties){
        this.driver = properties.getProperty("driver");
        this.url = properties.getProperty("url");
        this.username = properties.getProperty("username");
        this.password = properties.getProperty("password");
        this.poolMaxCacheConnections = Integer.valueOf(properties.getProperty("poolMaxCacheConnections"));
        this.poolMaxFreeConnections =   Integer.valueOf(properties.getProperty("poolMaxFreeConnections"));
        this.poolTimeToWait =  Integer.valueOf(properties.getProperty("poolTimeToWait"));
    }
    public ConnectionPojo(){

    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPoolMaxCacheConnections() {
        return poolMaxCacheConnections;
    }

    public void setPoolMaxCacheConnections(Integer poolMaxCacheConnections) {
        this.poolMaxCacheConnections = poolMaxCacheConnections;
    }

    public Integer getPoolMaxFreeConnections() {
        return poolMaxFreeConnections;
    }

    public void setPoolMaxFreeConnections(Integer poolMaxFreeConnections) {
        this.poolMaxFreeConnections = poolMaxFreeConnections;
    }

    public Integer getPoolTimeToWait() {
        return poolTimeToWait;
    }

    public void setPoolTimeToWait(Integer poolTimeToWait) {
        this.poolTimeToWait = poolTimeToWait;
    }

    @Override
    public String toString() {
        return "ConnectionPojo{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", poolMaxCacheConnections=" + poolMaxCacheConnections +
                ", poolMaxFreeConnections=" + poolMaxFreeConnections +
                ", poolTimeToWait=" + poolTimeToWait +
                '}';
    }
}
