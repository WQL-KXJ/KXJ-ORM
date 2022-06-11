package com.wqlkxj.annoresolver;

import com.wqlkxj.annotation.Column;
import com.wqlkxj.annotation.ID;
import com.wqlkxj.annotation.Table;
import com.wqlkxj.bean.User;

import java.lang.reflect.Field;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.annoresolver
 * @Date 2022/5/25 10:58
 * @Version 1.0
 */
public class OrmAnnoHelper {

    /*
     * @author:WQL-XXJ
     * @method getTableName
     * @date: 2022/5/25 11:07
     * @params [cls]
     * @returntype java.lang.String
     */
    public static String getTableName(Class<?> cls){

        //获取类上注解
        Table annotation = cls.getAnnotation(Table.class);
        //假如类上没有注解就以类名作为表名
        if(annotation==null){
            return cls.getSimpleName().toLowerCase();
        }
        return annotation.name().toLowerCase();
    }

    public static String getColumnName(Field field){
        //获取字段上的注解
        Column annotation = field.getAnnotation(Column.class);
        if(annotation==null){
          return field.getName().toLowerCase();
        }
        return annotation.name();
    }

    public static String getIDName(Field field){
        //获取字段上的注解
        ID annotation = field.getAnnotation(ID.class);
        if(annotation!=null &&! annotation.name().equals("")){
            return annotation.name();
        }else if(annotation!=null){
            return field.getName();
        }
        return ""; }
    
}
