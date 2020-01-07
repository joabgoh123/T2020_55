package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class DBUtil {

	public static Connection getMySqlConnection() {
		Connection con = null;
		try {
			System.out.println("hax");
			Locale locale = new Locale("en");
			ResourceBundle dbSQLStatements = ResourceBundle.getBundle("application", locale);
			Class.forName(dbSQLStatements.getString("db.mysql.drivername"));
			con = DriverManager.getConnection(dbSQLStatements.getString("db.mysql.connectionurl"),
					dbSQLStatements.getString("db.mysql.username"), dbSQLStatements.getString("db.mysql.password"));
			return con;
		} catch (SQLException e1) {
			System.err.println("SQLException in DBUtil");
		} catch (Exception e) {
			System.err.println("Unknown error in DBUtil");	
		}

		return null;
	}
}
