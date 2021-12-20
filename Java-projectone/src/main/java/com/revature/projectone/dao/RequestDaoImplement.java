package com.revature.projectone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.projectone.pojo.RequestPojo;

import exception.ApplicationException;

public class RequestDaoImplement implements RequestDaoList{
	
	private static final Logger logger = LogManager.getLogger(RequestDaoImplement.class);

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException {
		logger.info("Entered addRequest() in dao.");
          // System.out.print(localDate.getDayOfMonth()+"-"+localDate.getMonthValue()+"-"+localDate.getYear());
		try {
			Connection conn;
				conn = DbConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO REQUEST(req_name, req_price ,users_id, req_description, img, req_date )" 
					+ "values("
					+ "'"+requestPojo.getReq_name() 
					+"',"+requestPojo.getReq_price()
					+","+requestPojo.getUsers_id()
					+",'"+requestPojo.getReq_description()
					+ "','"+requestPojo.getImg() 
						+"' ,current_timestamp  ) returning id";
			ResultSet rs = stmt.executeQuery(query);

			rs.next();
			requestPojo.setId(rs.getInt(1));

		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited addRequest() in dao.");

		return requestPojo;
	}
	//--------------userPendingRequestes--------------------------------------------------------------
	@Override
	public List<RequestPojo> userPendingRequestes(int Id) throws ApplicationException {
		logger.info("Entered userPendingRequestes() in dao.");
		List<RequestPojo> userPendingList = new ArrayList<RequestPojo>();
		Connection con = null;
		PreparedStatement ps;
		RequestPojo requestPojo;
		try {
			con = DbConnection.getConnection();
			String query = 	"SELECT * FROM REQUEST WHERE users_id="+Id+ "AND req_flag=false And reject=false";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestPojo = new RequestPojo();
				requestPojo.setId(rs.getInt("id"));
				requestPojo.setReq_name(rs.getString("req_name"));
				requestPojo.setReq_price(rs.getInt("req_price"));
				requestPojo.setReq_description(rs.getString("req_description"));
				requestPojo.setImg(rs.getString("img"));
				requestPojo.setReq_date(rs.getString("req_date"));
				userPendingList.add(requestPojo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited userPendingRequestes() in dao.");

		return userPendingList;
	}
	//---------------userResolveRequest-------------------------------------------------------------
	@Override
	public List<RequestPojo> userResolveRequest(int Id) throws ApplicationException {
		logger.info("Entered userResolveRequest() in dao.");
		List<RequestPojo> resolvePendingList = new ArrayList<RequestPojo>();
		Connection con = null;
		PreparedStatement ps;
		RequestPojo requestPojo = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM REQUEST WHERE (users_id="+ Id + " AND req_flag=true And reject=false)";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestPojo = new RequestPojo();
				requestPojo.setId(rs.getInt("id"));
				requestPojo.setReq_name(rs.getString("req_name"));
				requestPojo.setReq_price(rs.getInt("req_price"));
				requestPojo.setReq_description(rs.getString("req_description"));
				requestPojo.setImg(rs.getString("img"));
				requestPojo.setReq_date(rs.getString("req_date"));
				resolvePendingList.add(requestPojo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited userResolveRequest() in dao.");
		
		return resolvePendingList;
	}
	
	//----------------allPendingRequsts------------------------------------------------------------
	@Override
	public List<RequestPojo> allPendingRequsts() throws ApplicationException {
		logger.info("Entered allPendingRequsts() in dao.");
		List<RequestPojo> resolvePendingList = new ArrayList<RequestPojo>();
		Connection con = null;
		PreparedStatement ps;
		RequestPojo requestPojo = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM REQUEST WHERE req_flag=FALSE AND reject=False";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestPojo = new RequestPojo();
				requestPojo.setId(rs.getInt("id"));
				requestPojo.setReq_name(rs.getString("req_name"));
				requestPojo.setReq_price(rs.getInt("req_price"));
				requestPojo.setReq_description(rs.getString("req_description"));
				requestPojo.setUsers_id(rs.getInt("users_id"));
				requestPojo.setImg(rs.getString("img"));
				requestPojo.setReq_date(rs.getString("req_date"));
				resolvePendingList.add(requestPojo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited allPendingRequsts() in dao.");

		return resolvePendingList;
	}
	//------------allResolvedRequsts----------------------------------------------------------------
	@Override
	public List<RequestPojo> allResolvedRequsts() throws ApplicationException {
		logger.info("Entered allResolvedRequsts() in dao.");
		List<RequestPojo> resolvePendingList = new ArrayList<RequestPojo>();
		Connection con = null;
		PreparedStatement ps;
		RequestPojo requestPojo = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM REQUEST WHERE req_flag=TRUE AND reject=False ";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestPojo = new RequestPojo();
				requestPojo.setId(rs.getInt("id"));
				requestPojo.setReq_name(rs.getString("req_name"));
				requestPojo.setReq_price(rs.getInt("req_price"));
				requestPojo.setReq_description(rs.getString("req_description"));
				requestPojo.setUsers_id(rs.getInt("users_id"));
				requestPojo.setImg(rs.getString("img"));
				requestPojo.setReq_date(rs.getString("req_date"));
				requestPojo.setAccept_date(rs.getString("accept_date"));

				resolvePendingList.add(requestPojo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited allResolvedRequsts() in dao.");

		return resolvePendingList;
	}
	//-----------spacificEmployeeRequests-----------------------------------------------------------------
	@Override
	public List<RequestPojo> spacificEmployeeRequests(int userId) throws ApplicationException {
		logger.info("Entered spacificEmployeeRequests() in dao.");
		
		List<RequestPojo> spacificRequestList = new ArrayList<RequestPojo>();
		Connection con = null;
		PreparedStatement ps;
		RequestPojo requestPojo = null;
		try {
			con = DbConnection.getConnection();
			String query = "SELECT * FROM REQUEST WHERE users_id="+ userId +" AND req_flag=FALSE AND reject=False";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				requestPojo = new RequestPojo();
				requestPojo.setId(rs.getInt("id"));
				requestPojo.setReq_name(rs.getString("req_name"));
				requestPojo.setReq_price(rs.getInt("req_price"));
				requestPojo.setReq_description(rs.getString("req_description"));
				requestPojo.setImg(rs.getString("img"));
				requestPojo.setReq_date(rs.getString("req_date"));
				spacificRequestList.add(requestPojo);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		logger.info("Exited spacificEmployeeRequests() in dao.");

		return spacificRequestList;
	}
	// ------------approveRequest--------------------------------------------------

	@Override
	public boolean approveRequest(int reqId) throws ApplicationException {
		logger.info("Entered approveRequest() in dao.");
		Statement stat;
		//Statement statement2;
		int num= 0;
		Connection conn =null;
		try {
			 conn = DbConnection.getConnection();
		stat = conn.createStatement();
		System.out.print("Test 1");
		String query = "UPDATE REQUEST SET req_flag=TRUE, accept_date=current_timestamp WHERE ID="+reqId;
			num = stat.executeUpdate(query);	

		} catch (SQLException e) {
				throw new ApplicationException(e.getMessage());
			
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		if(num == 0) {
			logger.info("Exited approveRequest() in dao.");
			return false;
		}
		logger.info("Exited approveRequest() in dao.");
		return true;
	}
	//-----------removeRequest-----------------------------------------------------------------

	@Override
	public boolean removeRequest(int reqId) throws ApplicationException {
		logger.info("Entered removeRequest() in dao.");
		int rowsAffected = 0;
		boolean flag = true;
		try {
			Connection conn = DbConnection.getConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE REQUEST SET reject=TRUE WHERE ID=" + reqId;
			rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		} catch (Exception ee) {
			throw new ApplicationException(ee.getMessage());
		}
		if (rowsAffected == 0) {
			flag = false;
			logger.info("Exited deleteBook() in dao.");
			return flag;
		}
		logger.info("Exited removeRequest() in dao.");

		return true;
	}

	
}
