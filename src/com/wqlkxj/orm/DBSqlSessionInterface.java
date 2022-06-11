package com.wqlkxj.orm;

import java.sql.SQLException;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.orm
 * @Date 2022/5/26 10:20
 * @Version 1.0
 */
public interface DBSqlSessionInterface {

    public <T> List<T> selectAll(Class<T> cls) throws SQLException, IllegalAccessException, InstantiationException;

    public <T> T selectById(T obj) throws IllegalAccessException;

    public boolean insert(Class<?> cls);

    public boolean updated(Class<?> cls);

    public boolean delete(Class<?> cls);

}
