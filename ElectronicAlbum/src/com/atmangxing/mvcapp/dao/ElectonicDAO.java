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
	   * ���غ�name��ȵļ�¼����
	   * 
	   * */
	  public long getCountWithName(String name);
	  public List<Electonic> getElectonicname(uploadelctionic up);
}
