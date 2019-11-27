package com.atmangxing.mvcapp.dao;

import java.util.List;

import com.atmangxing.mvcapp.domain.Electonic;

public interface ElectonicDAO {
	public List<Electonic> getForListWithCriteriaCustomer(Criteriaelectionic cc);
	public List<Electonic> getAll();
	
	public void save(Electonic electonic);  
	  
	public Electonic get(Integer id);
	public void  upload(uploadelctionic up); 
	  
	  /*
	   * 返回和name相等的记录数。
	   * 
	   * */
	  public long getCountWithName(String name);
	  public List<Electonic> getElectonicname(uploadelctionic up);
}
