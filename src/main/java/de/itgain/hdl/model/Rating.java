package de.itgain.hdl.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rating {

	@Id
	private String id;

	private LocalDateTime created;

	private int benefit;

	private int presentation;

	private int implementability;

	private int overall;

	private Comment comment;

	public Rating() {

	}

	public Rating(String id, int benefit, int presentation, int implementability, int overall, Comment comment) {
		this.id = id;
		this.benefit = benefit;
		this.presentation = presentation;
		this.implementability = implementability;
		this.overall = overall;
		this.comment = comment;
		this.created = LocalDateTime.now();
	}

	public int getBenefit() {
		return benefit;
	}

	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}

	public int getPresentation() {
		return presentation;
	}

	public void setPresentation(int presentation) {
		this.presentation = presentation;
	}

	public int getImplementability() {
		return implementability;
	}

	public void setImplementability(int implementability) {
		this.implementability = implementability;
	}

	public int getOverall() {
		return overall;
	}

	public void setOverall(int overall) {
		this.overall = overall;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}
