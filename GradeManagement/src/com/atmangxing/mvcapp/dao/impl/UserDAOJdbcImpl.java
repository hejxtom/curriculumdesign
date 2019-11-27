package com.atmangxing.mvcapp.dao.impl;

import java.util.List;

import com.atmangxing.mvcapp.dao.CriteriaUser;
import com.atmangxing.mvcapp.dao.DAO;
import com.atmangxing.mvcapp.dao.UserDAO;
import com.atmangxing.mvcapp.domain.User;


public  class UserDAOJdbcImpl extends DAO<User> implements UserDAO{
	
//���
	@Override
	public void save(CriteriaUser cu) {
		String sql="INSERT INTO user(username,password) VALUES(?,?)";
		update(sql,cu.getUsername(),cu.getPassword());
	}
	
//
	@Override
	public long getCountWithName(String username) {
		String sql="SELECT count(id) FROM user WHERE username=?";
		return getForValue(sql, username);
	}

//��ѯ
	@Override
	public List<User> getForListWithCriteriaUser(CriteriaUser cu) {
		String sql="SELECT * FROM user WHERE " +
				"username=? AND password=?";
		return getForList(sql,cu.getUsername(),cu.getPassword());
	}

}
