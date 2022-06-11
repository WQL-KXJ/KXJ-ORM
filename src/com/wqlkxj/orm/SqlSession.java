package com.wqlkxj.orm;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import com.wqlkxj.annoresolver.OrmAnnoHelper;
import com.wqlkxj.bean.User;
import com.wqlkxj.exception.PojoException;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.orm
 * @Date 2022/5/26 11:45
 * @Version 1.0
 */
public class SqlSession implements DBSqlSessionInterface {

   private Connection connection;

    public SqlSession(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T> List<T> selectAll(Class<T> cls) throws SQLException, IllegalAccessException, InstantiationException {

        String SQL = "SELECT %s FROM %s";

        //参数Builder
        StringBuilder paramlist = new StringBuilder();

        Field[] declaredFields = cls.getDeclaredFields();

        for(int i=0,len=declaredFields.length;i<len;i++){
            String columnName = OrmAnnoHelper.getColumnName(declaredFields[i]);
            paramlist.append(columnName);
            if(i!=len-1){
                paramlist.append(",");
            }
        }
        String EXSQL = String.format(SQL, paramlist.toString(), OrmAnnoHelper.getTableName(cls));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(EXSQL);
        T obj=null;
        List<T> Pojolist = new ArrayList<>();
        while (resultSet.next()){
            obj = cls.newInstance();
            for(Field f:declaredFields){
                f.setAccessible(true);
                f.set(obj,resultSet.getObject(OrmAnnoHelper.getColumnName(f),f.getType()));
            }
            Pojolist.add(obj);
        }
        return Pojolist;
    }

    @Override
    public <T> T selectById(T obj) throws IllegalAccessException {
        String SQL = "SELECT %s FROM %s WHERE %s = %d";
        String tablename = OrmAnnoHelper.getTableName(obj.getClass());
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        StringBuilder paramlist = new StringBuilder();
        ArrayList<String> idNames= new ArrayList<>();
        String idName;
        Field field;
        Integer idValue=null;
        for(int i=0,len=declaredFields.length;i<len;i++){
            field =declaredFields[i];
            idName = OrmAnnoHelper.getIDName(field);
            if (!idName.equals("")){
                idNames.add(idName);
                idValue = field.getInt(obj);
            }
            if(!field.get(obj).equals("")){
                paramlist.append(OrmAnnoHelper.getColumnName(field));
            }
            if(i!=len-1){
                paramlist.append(",");
            }
        }
        if(idNames.size()>1){
            throw new PojoException("ID出现多个");
        }else if(idNames.size()==0){
            throw new PojoException("无法找到@ID");
        }else if(idValue == null){
            throw  new PojoException("pojo对象id属性没有值");
        }
        String format = String.format(SQL, paramlist.toString(), tablename, idNames.get(0), idValue);
        System.out.println(format);


        return null;
    }

    @Override
    public boolean insert(Class<?> cls) {
        return false;
    }

    @Override
    public boolean updated(Class<?> cls) {
        return false;
    }

    @Override
    public boolean delete(Class<?> cls) {
        return false;
    }
}
