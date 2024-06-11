package com.sunbeam.beans;



import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegistrationBeam {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String date;
	private String Role;
	private int status;
	private User user;
	private int count;
	
	
	
	
	
	public RegistrationBeam() {
		
	}

		
	


	public int getCount() {
		return count;
	}





	public void setCount(int count) {
		this.count = count;
	}





	public String getRole() {
		return Role;
	}





	public void setRole(String role) {
		Role = role;
	}





	public int getStatus() {
		return status;
	}





	public void setStatus(int status) {
		this.status = status;
	}





	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public String getLastname() {
		return lastname;
	}





	public void setLastname(String lastname) {
		this.lastname = lastname;
	}





	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public void newRegister() {
		try (UserDao userDao = new UserDaoImpl()){
			 Date dob = Date.valueOf(date);
			 user= new User(status, firstname, lastname, email, password, dob, status, Role);
			
			count = userDao.save(user);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
