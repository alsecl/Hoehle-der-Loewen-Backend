package de.itgain.hdl.request;

import de.itgain.hdl.model.Rating;

public class VoteRequest {

	private String ideaId;

	private String userId;

	private Rating rating;

	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
