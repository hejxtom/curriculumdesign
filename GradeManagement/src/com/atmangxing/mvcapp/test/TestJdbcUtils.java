package com.atmangxing.mvcapp.test;


import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.atmangxing.mvcapp.db.JdbcUtils;

class TestJdbcUtils {

	@Test
	void testGetConnection() throws SQLException {
		Connection connection= JdbcUtils.getConnection();
		System.out.println(connection);
	}

}
