package com.wqlkxj.DBPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.DBPool
 * @Date 2022/5/25 19:14
 * @Version 1.0
 */
public class ConnectionProxy implements InvocationHandler {

    //真实连接
    private Connection realConnection;
    //代理连接
    private Connection proxyConnnection;
    //源
    DataSource dataSource;

    //初始化
    public ConnectionProxy(Connection realConnection, DataSource dataSource) {
        this.realConnection = realConnection;
        this.dataSource = dataSource;
        this.proxyConnnection = (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),
                                new Class<?>[]{Connection.class},
                               this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String name = method.getName();
        if(name.equals("close")){
            //把连接放入连接池中
            dataSource.closeConnection(this);
            return null;
        }
        //不为close方法直接用真实对象执行
        return method.invoke(realConnection,args);
    }

    public Connection getRealConnection() {
        return realConnection;
    }

    public void setRealConnection(Connection realConnection) {
        this.realConnection = realConnection;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getProxyConnnection() {
        return proxyConnnection;
    }

    public void setProxyConnnection(Connection proxyConnnection) {
        this.proxyConnnection = proxyConnnection;
    }
}