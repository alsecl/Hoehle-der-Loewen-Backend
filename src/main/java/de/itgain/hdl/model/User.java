package de.itgain.hdl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;

	private String email;

	private String password;

	private Boolean privileged;

	public User() {

	}

	public User(String id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.privileged = false;
	}

	public User(String id, String email, String password, boolean privileged) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.privileged = privileged;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean isPrivileged() {
		return privileged;
	}

	public void setPrivileged(boolean privileged) {
		this.privileged = privileged;
	}

}
