package com.revature.projectone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection connect;

//---------------------Start Connection-----------------------------------------------
	// static block make sure the driver load once
	// because static blockes only once after the class is loadded in memory
	static {
		try {

			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {

		// ---------------Singleton pattern----------------------------------
		// since we don't need more than one connection
		// we need to instantiate no more than one object from this class
		// so we make it singleton to be sure

		// if dbConnection object reference is not pointing to any object create new
		// object
		if (connect == null) {
			try {
				connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/reimbursement", "postgres", "root");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connect;
	}

//---------------------Close Connection-----------------------------------------------
	public static void closeConnection() {

		if (connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
