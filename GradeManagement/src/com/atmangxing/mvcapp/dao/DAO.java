package com.atmangxing.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atmangxing.mvcapp.db.JdbcUtils;


public class DAO<T> {
	private  QueryRunner queryRunner=new QueryRunner();
	private Class<T> clazz;
	
	public DAO() {
	Type superclass=getClass().getGenericSuperclass();
	if(superclass instanceof ParameterizedType) {
	ParameterizedType parameterizedType=(ParameterizedType)superclass;
	
	Type[] typeArgs=parameterizedType.getActualTypeArguments();
	 if(typeArgs !=null&&typeArgs.length>0) {
		 if(typeArgs[0] instanceof Class) {
			 clazz =(Class<T>) typeArgs[0];
		  }
	  }
	}
}
	/*
	 * ����ĳһ�ֶε�ֵ
	 * */
	public <E> E getForValue(String sql,Object ...args) {
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
		return (E) queryRunner.query(connection,sql,new ScalarHandler(),args);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/*
	 * ����T��Ӧ��Listֵ
	 * 
	 * */
	public List<T> getForList(String sql,Object ...args){
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/*
	 * ���ض�Ӧ T ��һ��ʵ�������
	 */
	public T get(String sql,Object ...args) {
		Connection connection=null;
		try {
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
/*
 * �÷�����װdelete��update��insert
 */
	public void update(String sql,Object ...args) {
	  Connection connection=null;
	  try {
		connection=JdbcUtils.getConnection();
		queryRunner.update(connection,sql,args);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JdbcUtils.releaseConnection(connection);
	  }
	}
	
}
