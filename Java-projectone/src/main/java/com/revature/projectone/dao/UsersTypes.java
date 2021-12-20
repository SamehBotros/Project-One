package com.revature.projectone.dao;

public enum UsersTypes {

	// CONSTANTS
	EMPLOYEE(1, "employee"), MANAGER(2, "manager");

	private int id;
	private String type;

	// MUST HAVE PRIVATE CONSTRACTOR
	private UsersTypes(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public static UsersTypes getUsersTypeById(int id) {
		// check for each id and return the name
		for (UsersTypes usertype : UsersTypes.values()) {
			if (usertype.getId() == id) {
				// return string "EMPLOYEE" or "MANAGER"
				return usertype;
			}
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
