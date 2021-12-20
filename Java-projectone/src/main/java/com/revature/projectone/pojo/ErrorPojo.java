package com.revature.projectone.pojo;

import java.time.LocalDate;
import java.util.Objects;

public class ErrorPojo {
	private String errorMessage;
	private LocalDate date;
	
	
	
	public ErrorPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorPojo(String errorMessage, LocalDate date) {
		super();
		this.errorMessage = errorMessage;
		this.date = date;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, errorMessage);
	}
	@Override
	public boolean equals(Object obj) {
		
		if (getClass() != obj.getClass())
			return false;
		ErrorPojo other = (ErrorPojo) obj;
		return Objects.equals(date, other.date) && Objects.equals(errorMessage, other.errorMessage);
	}
	
	@Override
	public String toString() {
		return "ErrorPojo [errorMessage=" + errorMessage + ", date=" + date + "]";
	}
	
	

}
