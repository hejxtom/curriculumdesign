package com.atmangxing.mvcapp.db;
//c3p0���ӳ�
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
  /*
   * �ͷ�Connection����
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
		//����Ԫֻ�ܱ���ʼ��һ��
		dateSource =new ComboPooledDataSource("mvcapp");
	}
	/*
	 * ��������ԴConnection�Ķ���
	 * 
	 * */
	public  static Connection getConnection() throws SQLException {
		return  dateSource.getConnection();
	}
	

}
