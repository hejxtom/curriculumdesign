package com.atmangxing.mvcapp.dao;

import java.util.List;

import com.atmangxing.mvcapp.domain.User;

public interface UserDAO {
	  public  List<User> getForListWithCriteriaUser(CriteriaUser cu);
	  
	  public void save(CriteriaUser cu);  
	  
	  /*
	   * 返回和name相等的记录数。
	   * 
	   * */
	  public long getCountWithName(String name);
}
