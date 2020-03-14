package de.itgain.hdl.response;

import de.itgain.hdl.model.User;

public class UserAuthenticationResponse {

	private User user;

	private String error;

	private Boolean successfull;

	public UserAuthenticationResponse(User user) {
		this.user = user;
		this.successfull = true;
	}

	public UserAuthenticationResponse(String error) {
		this.error = error;
		this.successfull = false;
	}

	public User getUser() {
		return user;
	}

	public String getError() {
		return error;
	}

	public Boolean isSuccessfull() {
		return successfull;
	}

}
