package com.revature.projectone.dao;

import java.util.List;

import com.revature.projectone.pojo.RequestPojo;

import exception.ApplicationException;

public interface RequestDaoList {
	

	RequestPojo addRequest(RequestPojo requestPojo)throws ApplicationException;
	List<RequestPojo> userPendingRequestes(int Id)throws ApplicationException;
	List<RequestPojo>   userResolveRequest(int Id)throws ApplicationException;
	boolean approveRequest(int reqId)throws ApplicationException;
	List<RequestPojo>  allPendingRequsts()throws ApplicationException;
	List<RequestPojo> allResolvedRequsts()throws ApplicationException;
	List<RequestPojo>  spacificEmployeeRequests(int userId)throws ApplicationException;
	boolean removeRequest(int reqId)throws ApplicationException;

}
