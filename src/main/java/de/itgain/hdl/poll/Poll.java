package de.itgain.hdl.poll;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.itgain.hdl.idea.Rating;
import de.itgain.hdl.user.User;

@Document
public class Poll {

	@Id
	private String id;

	private String ideaId;

	private Duration duration;

	private LocalDateTime startTime;

	private Map<User, Rating> ratings;

	public Poll() {

	}

	public Poll(String ideaId, Duration duration) {
		this.id = UUID.randomUUID().toString();
		this.ideaId = ideaId;
		this.duration = duration;
		this.ratings = new HashMap<User, Rating>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Map<User, Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Map<User, Rating> ratings) {
		this.ratings = ratings;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

}
