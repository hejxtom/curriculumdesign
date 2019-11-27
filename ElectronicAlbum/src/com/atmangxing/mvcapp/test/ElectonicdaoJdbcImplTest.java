package com.atmangxing.mvcapp.test;


import static org.junit.Assert.fail;

import org.junit.Test;

import com.atmangxing.mvcapp.dao.ElectonicDAO;
import com.atmangxing.mvcapp.dao.impl.ElectonicdaoJdbcImpl;
import com.atmangxing.mvcapp.domain.Electonic;

class ElectonicdaoJdbcImplTest {
    private ElectonicDAO electonicDAO=new ElectonicdaoJdbcImpl();
	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		Electonic electonic =new Electonic();
		electonic.setMailbox("11111");
		electonic.setName("111");
		electonic.setPassword("111");
		electonic.setPhone("1111");
		electonicDAO.save(electonic);
	}

	@Test
	void testGetInteger() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateElectonic() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCountWithName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetForListWithCriteriaCustomer() {
		fail("Not yet implemented");
	}

}
