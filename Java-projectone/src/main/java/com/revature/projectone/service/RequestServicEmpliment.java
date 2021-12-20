package com.revature.projectone.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.projectone.dao.RequestDaoImplement;
import com.revature.projectone.dao.RequestDaoList;
import com.revature.projectone.pojo.RequestPojo;
import exception.ApplicationException;

public class RequestServicEmpliment implements RequestServicList {
	
	private static final Logger logger = LogManager.getLogger(RequestServicEmpliment.class);


	RequestDaoList requestDaolist = new RequestDaoImplement();
	
	
	public RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException {
		logger.info("Entered addRequest() in service.");
		RequestPojo returnaddRequest = this.requestDaolist.addRequest(requestPojo);
		logger.info("Exited addRequest() in service.");
		return returnaddRequest;
	}

	public List<RequestPojo> userPendingRequestes(int Id) throws ApplicationException {
		logger.info("Entered userPendingRequestes() in service.");
		List<RequestPojo> returnUserPendingRequestes = this.requestDaolist.userPendingRequestes(Id);
		logger.info("Exited userPendingRequestes() in service.");
		return returnUserPendingRequestes;
	}

	public List<RequestPojo> userResolveRequest(int Id) throws ApplicationException {
		logger.info("Entered userResolveRequest() in service.");
		List<RequestPojo> returnUserResolveRequest = this.requestDaolist.userResolveRequest(Id);
		logger.info("Exited userResolveRequest() in service.");
		return returnUserResolveRequest;
	}

	public boolean approveRequest(int reqId) throws ApplicationException {
		logger.info("Entered approveRequest() in service.");
		boolean returnApproveRequestFlag = this.requestDaolist.approveRequest(reqId);
		logger.info("Exited approveRequest() in service.");
		return returnApproveRequestFlag;
	}

	public List<RequestPojo> allPendingRequsts() throws ApplicationException {
		logger.info("Entered allPendingRequsts() in service.");
		List<RequestPojo> returnAllPendingRequests = this.requestDaolist.allPendingRequsts();
		logger.info("Exited allPendingRequsts() in service.");
		return returnAllPendingRequests;
	}

	public List<RequestPojo> allResolvedRequsts() throws ApplicationException {
		logger.info("Entered allResolvedRequsts() in service.");
		List<RequestPojo> returnAllResolvedRequsts = this.requestDaolist.allResolvedRequsts();
		logger.info("Exited allResolvedRequsts() in service.");
		return returnAllResolvedRequsts;
	}

	public List<RequestPojo> spacificEmployeeRequests(int userId) throws ApplicationException {
		logger.info("Entered spacificEmployeeRequests() in service.");
		List<RequestPojo> returnSpacificEmployeeRequests = this.requestDaolist.spacificEmployeeRequests(userId);
		logger.info("Exited spacificEmployeeRequests() in service.");
		return returnSpacificEmployeeRequests;
	}

	public boolean removeRequest(int reqId) throws ApplicationException {
		logger.info("Entered removeRequest() in service.");
		boolean returnRemoveRequest = this.requestDaolist.removeRequest(reqId);
		logger.info("Exited removeRequest() in service.");
		return returnRemoveRequest;
	}



}
