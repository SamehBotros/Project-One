package com.revature.projectone.pojo;

import java.sql.Date;
import java.time.LocalDate;

public class RequestPojo {
	
	public static final String LocalDate = null;
	
	private int id; 
	private String req_name; 
	private int req_price; 
	private String req_description; 
	private boolean req_flag; 
	private String req_date;
	private String accept_date;
	private String img; 
	private int users_id;
	private boolean reject;
	
	
	public RequestPojo() {
		super();
	}


	public RequestPojo(int id, String req_name, int req_price, String req_description, boolean req_flag,
			String req_date, String accept_date, String img, int users_id, boolean reject) {
		super();
		this.id = id;
		this.req_name = req_name;
		this.req_price = req_price;
		this.req_description = req_description;
		this.req_flag = req_flag;
		this.req_date = req_date;
		this.accept_date = accept_date;
		this.img = img;
		this.users_id = users_id;
		this.reject = reject;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getReq_name() {
		return req_name;
	}


	public void setReq_name(String req_name) {
		this.req_name = req_name;
	}


	public int getReq_price() {
		return req_price;
	}


	public void setReq_price(int req_price) {
		this.req_price = req_price;
	}


	public String getReq_description() {
		return req_description;
	}


	public void setReq_description(String req_description) {
		this.req_description = req_description;
	}


	public boolean isReq_flag() {
		return req_flag;
	}


	public void setReq_flag(boolean req_flag) {
		this.req_flag = req_flag;
	}


	public String getReq_date() {
		return req_date;
	}


	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}


	public String getAccept_date() {
		return accept_date;
	}


	public void setAccept_date(String accept_date) {
		this.accept_date = accept_date;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getUsers_id() {
		return users_id;
	}


	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}


	public boolean isReject() {
		return reject;
	}


	public void setReject(boolean reject) {
		this.reject = reject;
	}


	

	
	

	
	
	
	

}
