package com.revature.projectone.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.projectone.dao.UsersDaoImplement;
import com.revature.projectone.dao.UsersDaoList;
import com.revature.projectone.pojo.UsersPojo;

import exception.ApplicationException;

public class UsersServicEmpliment implements UsersServicList {

	private static final Logger logger = LogManager.getLogger(UsersServicEmpliment.class);

	UsersDaoList userDaoList = new UsersDaoImplement();

	public UsersPojo userProfile(int Id) throws ApplicationException {
		logger.info("Entered userProfile() in service.");
		UsersPojo returnUserProfile = this.userDaoList.userProfile(Id);
		logger.info("Exited userProfile() in service.");
		return returnUserProfile;
	}

	public UsersPojo updateUserProfile(UsersPojo userPojo) throws ApplicationException {
		logger.info("Entered updateUserProfile() in service.");
		UsersPojo returnUpdateUserProfile = this.userDaoList.updateUserProfile(userPojo);
		logger.info("Exited updateUserProfile() in service.");
		return returnUpdateUserProfile;
	}

	public UsersPojo logIn(UsersPojo userPojo) throws ApplicationException {
		logger.info("Entered logIn() in service.");
		UsersPojo returnLogIn = this.userDaoList.logIn(userPojo);
		logger.info("Exited logIn() in service.");
		return returnLogIn;
	}

	public UsersPojo register(UsersPojo userPojo) throws ApplicationException {
		logger.info("Entered signIn() in service.");
		UsersPojo returnSignIn = this.userDaoList.register(userPojo);
		logger.info("Exited signIn() in service.");
		return returnSignIn;
	}

	public List<UsersPojo> allEmployees() throws ApplicationException {
		logger.info("Entered allEmployees() in service.");
		List<UsersPojo> returnAllEmployees = this.userDaoList.allEmployees();
		logger.info("Exited allEmployees() in service.");
		return returnAllEmployees;
	}

	@Override
	public UsersPojo getUserByName(UsersPojo userPojo) throws ApplicationException {
		logger.info("Entered getUserByName() in service.");
		UsersPojo returnUserId = this.userDaoList.getUserByName(userPojo);
		logger.info("Exited getUserByName() in service.");
		return returnUserId;
	}

}
