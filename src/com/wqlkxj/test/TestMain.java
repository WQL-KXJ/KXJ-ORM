package com.wqlkxj.test;

import com.wqlkxj.DBPool.DataSource;
import com.wqlkxj.DBPool.DataSourceAbstract;
import com.wqlkxj.annoresolver.OrmAnnoHelper;
import com.wqlkxj.bean.User;
import com.wqlkxj.exception.PojoException;
import com.wqlkxj.orm.DBSessionFactory;
import com.wqlkxj.orm.DBSqlSessionInterface;
import com.wqlkxj.orm.SqlSession;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.test
 * @Date 2022/5/25 17:14
 * @Version 1.0
 */
public class TestMain {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {

        User obj =new User();
        SqlSession Session = (SqlSession) new DBSessionFactory().openSqlSession();
        System.out.println(Session.selectAll(obj.getClass()).toString());


    }
}
