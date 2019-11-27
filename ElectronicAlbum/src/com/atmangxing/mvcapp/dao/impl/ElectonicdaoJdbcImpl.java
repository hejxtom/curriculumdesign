package com.atmangxing.mvcapp.dao.impl;

import java.sql.Connection;
import java.util.List;
import com.atmangxing.mvcapp.dao.Criteriaelectionic;
import com.atmangxing.mvcapp.dao.DAO;
import com.atmangxing.mvcapp.dao.ElectonicDAO;
import com.atmangxing.mvcapp.dao.uploadelctionic;
import com.atmangxing.mvcapp.db.JdbcUtils;
import com.atmangxing.mvcapp.domain.Electonic;

public class ElectonicdaoJdbcImpl extends DAO<Electonic> implements ElectonicDAO{

	@Override
	public List<Electonic> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Electonic electonic) {
		String sql="INSERT INTO electonic_main(name,password,phone,mailbox) VALUES(?,?,?,?)";
		update(sql,electonic.getName(),electonic.getPassword(),electonic.getPhone(),electonic.getMailbox());
	}

	@Override
	public Electonic get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(id) FROM electonic_main WHERE name=?";
		return getForValue(sql, name);
	}

	@Override
	public List<Electonic> getForListWithCriteriaCustomer(Criteriaelectionic cc) {
		String sql="SELECT * FROM electonic_main WHERE " +
				"name LIKE ? AND password LIKE ?";
		
		return getForList(sql,cc.getName(),cc.getPassword());
	}

	@Override
	public void upload(uploadelctionic up) {
		String sql="INSERT INTO electonic_name(electonicname,path,name) VALUES(?,?,?)";
		update(sql, up.getElectonicname(),up.getPath(),up.getName());
	}

	@Override
	public List<Electonic> getElectonicname(uploadelctionic up) {
		String sql="SELECT electonicname,path FROM electonic_name WHERE name=?";
		return getForList(sql,up.getName());	
	}

}
