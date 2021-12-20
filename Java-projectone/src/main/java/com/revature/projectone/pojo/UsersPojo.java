package com.revature.projectone.pojo;

import com.revature.projectone.dao.UsersTypes;

public class UsersPojo {
	
	private  int id; 
	private  String name; 
	private  String password; 
	private String email;
	private  UsersTypes usertype_id; 
	private String addres; 
	private String contact;
	
	public UsersPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersPojo(int id, String name, String password, String email, UsersTypes usertype_id, String addres,
			String contact) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.usertype_id = usertype_id;
		this.addres = addres;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsersTypes getUsertype_id() {
		return usertype_id;
	}

	public void setUsertype_id(UsersTypes usertype_id) {
		this.usertype_id = usertype_id;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	



}



