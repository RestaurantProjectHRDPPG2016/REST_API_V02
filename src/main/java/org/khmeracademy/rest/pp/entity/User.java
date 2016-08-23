package org.khmeracademy.rest.pp.entity;

import java.util.List;

public class User {
	
	private int user_id;
	private String username;
	private String password;
	private String email;
	private String status;
	private List<Role> roles;
	
	
	public int getUserid() {
		return user_id;
	}
	public void setUserid(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userid=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", status=" + status + ", roles=" + roles + "]";
	}
	
	
}
