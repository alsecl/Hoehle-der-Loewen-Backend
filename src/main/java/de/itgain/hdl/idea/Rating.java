package de.itgain.hdl.idea;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rating {

	@Id
	private String id;

	private int votes;

	private int benefit;

	private int presentation;

	private int implementability;

	private int overall;

	public Rating() {

	}

	public Rating(String id, int votes, int benefit, int presentation, int implementability, int overall) {
		this.id = id;
		this.votes = votes;
		this.benefit = benefit;
		this.presentation = presentation;
		this.implementability = implementability;
		this.overall = overall;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
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

}
