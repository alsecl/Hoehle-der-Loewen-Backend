package de.itgain.hdl.idea;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Idea {

	@Id
	private String id;

	private String author;

	private String title;

	private String description;

	private List<Comment> comments;

	private Rating rating;

	public Idea() {

	}

	public Idea(String id, String author, String title, String description) {
		this.id = id;
		this.author = author;
		this.author = title;
		this.description = description;
		this.comments = new ArrayList<>();
		this.rating = new Rating(UUID.randomUUID().toString(), 0, 0, 0, 0, 0);
	}

	public String getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
