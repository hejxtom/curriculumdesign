package com.atmangxing.mvcapp.dao;

import java.util.List;

import com.atmangxing.mvcapp.domain.Student;

public interface StudentDAO {
	 public List<Student> getForListWithCriteriaCustomer(CriteriaStudent cs);
	  public List<Student> getAll();
	  
	  public void save(Student student);  
	  
	  public Student get(String number);
	  
	  public void delete(String number);
	  
	  public void update(Student student);
	  
	  /*
	   * 返回和name相等的记录数。
	   * 
	   * */
	  public long getCountWithName(String name);
}
