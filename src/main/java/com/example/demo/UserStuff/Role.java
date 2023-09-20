package com.example.demo.UserStuff;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Role {
	@Id
	@GeneratedValue
	private int role_id;
	private String role;
	
	public Role(int role_id, String role) {
		super();
		this.role_id = role_id;
		this.role = role;
	}

	public Role() {
		
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}