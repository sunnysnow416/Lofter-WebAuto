package com.sunnysnow.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * druid连接池的工具类
 */
public class JDBCUtils {
    //1.定义成员变量
    private static DataSource ds;


    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            InputStream fin = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(fin);
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接的方法
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * 执行DML,需要Statement和Connection
     */
    public  static void close(Statement temt,Connection conn){
        if(temt!=null){
            try {
                temt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 释放归还连接，重载
     * 执行DQL需要ResultSet,Statement和Connection
     * @param temt
     * @param conn
     */
    public  static void close(ResultSet rs,Statement temt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(temt!=null){
            try {
                temt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
