package de.itgain.hdl.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Poll {

	@Id
	private String id;

	private Duration duration;

	private LocalDateTime startTime;

	private Map<String, Rating> ratings;

	private boolean finished;

	public Poll() {

	}

	public Poll(String ideaId, Duration duration) {
		this.id = UUID.randomUUID().toString();
		this.duration = duration;
		this.ratings = new HashMap<>();
		this.finished = false;
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

	public Map<String, Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Map<String, Rating> ratings) {
		this.ratings = ratings;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

}
