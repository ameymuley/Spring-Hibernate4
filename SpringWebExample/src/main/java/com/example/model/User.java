package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;
	
	private String userName;
	
	@Column(name = "userPassword")
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String mobNumber;
	
	
	public User() {
		super();
	}


	public User(String userName, String password, String firstName, String lastName, String email, String mobNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNumber = mobNumber;
	}
	
	
	public int getUserId() {
		return userId;
	}
	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobNumber() {
		return mobNumber;
	}


	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("userName: " + userName);
		sb.append("  password: " + password);
		sb.append("  firstName: " + firstName);
		sb.append("  lastName: " + lastName);
		sb.append("  email: " + email);
		sb.append("  mobNumber: " + mobNumber);
		
		return sb.toString();
	}
	
	

}
