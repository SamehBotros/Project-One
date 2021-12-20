package com.revature.projectone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.projectone.pojo.UsersPojo;

import exception.ApplicationException;

public class UsersDaoImplement implements UsersDaoList {

	private int usertype_id;
	
	// --------------getUserByName------------------------------------------------

	public UsersPojo getUserByName(UsersPojo usersPojo) throws ApplicationException {
		logger.info("Entered getUser() in dao.");
		UsersPojo findUsersPojo = new UsersPojo();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM USERS WHERE NAME = '" + usersPojo.getName() + "'";
			ps = con.prepareStatement(query);
			rset = ps.executeQuery();
			while (rset.next()) {
				findUsersPojo.setId(rset.getInt("id"));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception e2) {
			throw new ApplicationException(e2.getMessage());
		}
		logger.info("Exited getUser() in dao.");

		return findUsersPojo;
	}
	// --------------userProfile------------------------------------------------

	private static final Logger logger = LogManager.getLogger(UsersDaoImplement.class);

	@Override
	public UsersPojo userProfile(int Id) throws ApplicationException {
		logger.info("Entered userProfile() in dao.");

		PreparedStatement ps;
		UsersPojo usersPojo = new UsersPojo();
		Connection conn;

		try {
			conn = DbConnection.getConnection();
			String query = "SELECT * FROM USERS WHERE id=" + Id;
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usersPojo.setId(rs.getInt("id"));
				usersPojo.setName(rs.getString("name"));
				usersPojo.setEmail(rs.getString("email"));
				usersPojo.setAddres(rs.getString("addres"));
				usersPojo.setContact(rs.getString("contact"));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited userProfile() in dao.");
		return usersPojo;
	}

	// ---------------logIn-------------------------------------------------------------
	
	public UsersPojo logIn(UsersPojo usersPojo) throws ApplicationException {
		logger.info("Entered logIn() in dao.");
		UsersPojo findUsersPojo = new UsersPojo();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM USERS WHERE NAME = '" + usersPojo.getName() + "'  AND PASSWORD= '"
					+ usersPojo.getPassword() + "'";
			ps = con.prepareStatement(query);
			rset = ps.executeQuery();
			while (rset.next()) {
				findUsersPojo.setId(rset.getInt("id"));
				findUsersPojo.setName(rset.getString("name"));
				findUsersPojo.setPassword(rset.getString("password"));
				UsersTypes findUsersType = UsersTypes.getUsersTypeById(rset.getInt("usertype_id"));
				findUsersPojo.setUsertype_id(findUsersType);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception e2) {
			throw new ApplicationException(e2.getMessage());
		}
		logger.info("Exited logIn() in dao.");

		return findUsersPojo;
	}

	// ---------------allEmployees-------------------------------------------------------------
	@Override
	public List<UsersPojo> allEmployees() throws ApplicationException {
		logger.info("Entered allEmployees() in dao.");
		List<UsersPojo> allEmployeeList = new ArrayList<UsersPojo>();
		Connection con = null;
		PreparedStatement ps;
		UsersPojo userPojo = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM USERS";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userPojo = new UsersPojo();
				userPojo.setId(rs.getInt("id"));
				userPojo.setName(rs.getString("name"));
				userPojo.setEmail(rs.getString("email"));
				userPojo.setAddres(rs.getString("addres"));
				userPojo.setContact(rs.getString("contact"));
				UsersTypes findUsersType = UsersTypes.getUsersTypeById(rs.getInt("usertype_id"));
				userPojo.setUsertype_id(findUsersType);
				allEmployeeList.add(userPojo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited allEmployees() in dao.");

		return allEmployeeList;
	}

	// --------------updateUserProfile--------------------------------------------------------------

	@Override
	public UsersPojo updateUserProfile(UsersPojo userPojo) throws ApplicationException {
		logger.info("Entered updateUserProfile() in dao.");
		Connection con = null;
		PreparedStatement ps;
		try {
			con = DbConnection.getConnection();
			String query = "UPDATE USERS SET NAME= '" + userPojo.getName() + "',password= '" + userPojo.getPassword()
					+ "',email='" + userPojo.getEmail() + "',addres='" + userPojo.getAddres() + "',contact='"
					+ userPojo.getContact() + "'" + "WHERE ID=" + userPojo.getId();

			ps = con.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited updateUserProfile() in dao.");
		return userPojo;
	}
	// --------------register--------------------------------------------------------------

	@Override
	public UsersPojo register(UsersPojo userPojo) throws ApplicationException {
		logger.info("Entered register() in dao.");
		UsersPojo regestCustmPojo = new UsersPojo();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			regestCustmPojo = logIn(userPojo);

			if (regestCustmPojo != null) {
				if ((userPojo.getName().equals(regestCustmPojo.getName()))
						&& (userPojo.getPassword().equals(regestCustmPojo.getPassword()))) {
					logger.info("Exited register() in dao.");
					return null;
				}
			}
			conn = DbConnection.getConnection();
			String query = "INSERT INTO USERS (NAME, PASSWORD,  EMAIL ,ADDRES, CONTACT, usertype_id ) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, userPojo.getName());
			ps.setString(2, userPojo.getPassword());
			ps.setString(3, userPojo.getEmail());
			ps.setString(4, userPojo.getAddres());
			ps.setString(5, userPojo.getContact());
			ps.setInt(6, 1);
			ps.executeUpdate();
					
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception e1) {
			throw new ApplicationException(e1.getMessage());
		}
		logger.info("Exited register() in dao.");
		return userPojo;
	}
}
