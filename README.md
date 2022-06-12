# KXJ-ORM
使用原生JDBC自定义封装ORM框架，造一个简单的轮子

### 主要实现的功能：
- 自定义数据库连接池
- ORM映射(表 <-> 类)

**1，连接池实现(com.wqlkxj.DBPool)**
``` java
//调用自定义连接池
DataSource dataSource =new DataSource();
return new SqlSession(dataSource.getConnection());
```
类图：
![DBConnectionPool](https://wql.luoqin.ltd/wp-content/uploads/2022/06/DBConnectionPool.png)

**2，自定义ORM映射**

暂时只实现了所有字段的查询
``` java
//例：
User obj =new User(); //pojo
SqlSession Session = (SqlSession) new DBSessionFactory().openSqlSession(); //通过sessionFactory调用session
System.out.println(Session.selectAll(obj.getClass()).toString());//查询所有
```
实现ORM主要通过注解+反射

