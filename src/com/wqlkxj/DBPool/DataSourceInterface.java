package com.wqlkxj.DBPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.DBPool
 * @Date 2022/5/25 16:36
 * @Version 1.0
 */
public interface  DataSourceInterface extends DataSource {

    @Override
    default Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    default Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    default <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    default boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    default PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override

    default void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    default void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    default int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    default Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
