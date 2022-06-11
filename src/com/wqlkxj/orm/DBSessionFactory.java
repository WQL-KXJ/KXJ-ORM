package com.wqlkxj.orm;

import com.wqlkxj.DBPool.DataSource;

import java.sql.SQLException;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.orm
 * @Date 2022/5/25 12:12
 * @Version 1.0
 */
public class DBSessionFactory {

    public  DBSqlSessionInterface openSqlSession() throws SQLException {

        DataSource dataSource =new DataSource();

        return new SqlSession(dataSource.getConnection());
   }}

