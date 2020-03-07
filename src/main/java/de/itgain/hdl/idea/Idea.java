package de.itgain.hdl.idea;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import de.itgain.hdl.poll.Poll;

@Document
public class Idea {

	@Id
	private String id;

	private String author;

	private String title;

	private String description;

	private Poll poll;

	public Idea() {

	}

	public Idea(String id, String author, String title, String description) {
		this.id = id;
		this.author = author;
		this.author = title;
		this.description = description;
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

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

}
