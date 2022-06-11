package com.wqlkxj.DBPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author WQL-KXJ
 * @ProjectName My-ORM
 * @PackageName com.wqlkxj.DBPool
 * @Date 2022/5/25 19:50
 * @Version 1.0
 * 覆盖父类方法，返回代理连接
 */
public class DataSource extends DataSourceAbstract{

    //空闲的连接池
   private final ConcurrentLinkedQueue<ConnectionProxy> freeBlockingQueue = new ConcurrentLinkedQueue<ConnectionProxy>();

    //激活的连接池
    private final ConcurrentLinkedQueue<ConnectionProxy> activeBlockingQueue = new ConcurrentLinkedQueue<ConnectionProxy>();

    //lock锁
    Lock locks = new ReentrantLock();

    //线程通信对象
    Condition condition = locks.newCondition();

    @Override
    public Connection getConnection() throws SQLException {
        ConnectionProxy connectionProxy = getConnectionProxy(super.connectionPojo.getUsername(), super.connectionPojo.getPassword());
        //调用connectionProxy中的代理连接
        return connectionProxy.getRealConnection();
    }

    private ConnectionProxy getConnectionProxy(String username,String password) throws SQLException {

        ConnectionProxy connectionProxy = null;
        while (connectionProxy == null) {
            locks.lock();
            if (!freeBlockingQueue.isEmpty()) {
                //删除并返回对象
                connectionProxy = freeBlockingQueue.poll();
            } else {
                if (activeBlockingQueue.size() < super.connectionPojo.getPoolMaxCacheConnections()) {
                    connectionProxy = new ConnectionProxy(super.getConnection(), this);
                }}
            if(connectionProxy == null){
                try {
                    //休眠
                    condition.await(super.connectionPojo.getPoolTimeToWait(), TimeUnit.MILLISECONDS);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    break;//超时直接退出报异常
                }
            }
        }
        if(connectionProxy != null){
            //加入到激活队列
            activeBlockingQueue.add(connectionProxy);
        }
        locks.unlock();
        return connectionProxy;
    }

    public void closeConnection(ConnectionProxy connectionProxy){
        locks.lock();
        boolean remove = activeBlockingQueue.remove(connectionProxy);
        if(freeBlockingQueue.size()<super.connectionPojo.getPoolMaxFreeConnections() && remove){
            freeBlockingQueue.add(connectionProxy);
        }
        condition.signalAll();
        locks.unlock();
    }
}
