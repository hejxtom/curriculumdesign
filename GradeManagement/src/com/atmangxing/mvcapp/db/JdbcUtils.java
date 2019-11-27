package com.atmangxing.mvcapp.db;
//c3p0连接池
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
  /*
   * 释放Connection连接
   * */
	public static void releaseConnection(Connection connection) {
       try {
    	   if(connection !=null) {
    		   connection.close();
    	   }
       }catch (Exception e) {
		e.printStackTrace();
	 }
	}
	
	private static DataSource dateSource=null;
	
	static {
		//数据元只能被初始化一次
		dateSource =new ComboPooledDataSource("mvcapp");
	}
	/*
	 * 返回数据源Connection的对象
	 * 
	 * */
	public  static Connection getConnection() throws SQLException {
		return  dateSource.getConnection();
	}
	

}
