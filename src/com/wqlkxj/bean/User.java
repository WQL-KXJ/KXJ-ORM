package com.wqlkxj.bean;

import com.wqlkxj.annotation.Column;
import com.wqlkxj.annotation.ID;
import com.wqlkxj.annotation.Table;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.bean
 * @Date 2022/5/25 11:08
 * @Version 1.0
 */
@Table(name = "account")
public class User {
    @ID(name = "wqld")
    Integer id;

    String username;
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
