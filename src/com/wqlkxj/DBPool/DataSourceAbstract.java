package com.wqlkxj.DBPool;

import com.wqlkxj.bean.ConnectionPojo;
import com.wqlkxj.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.DBPool
 * @Date 2022/5/25 16:44
 * @Version 1.0
 */
public abstract class DataSourceAbstract implements DataSourceInterface {

    ConnectionPojo connectionPojo = PropertiesUtil.getConnectionPojo();

    @Override
    public Connection getConnection() throws SQLException {

        return dogetConnection(connectionPojo.getUsername(), connectionPojo.getPassword());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {

        return dogetConnection(username,password);
    }

    private Connection dogetConnection(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(connectionPojo.getUrl(),username,password);
        return connection;
    }
}
