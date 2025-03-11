package com.mb.trello.model;


public class Card extends Model {
	private String name;
	private String description;
	private  User assignee;
	private User reporter;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	public User getReporter() {
		return reporter;
	}
	public void setReporter(User reporter) {
		this.reporter = reporter;
	}
	public Card(String name, String description, User assignee, User reporter) {
		this.name = name;
		this.description = description;
		this.assignee = assignee;
		this.reporter = reporter;
	}
	public Card(String name, String description, User reporter) {
		this.name = name;
		this.description = description;
		this.reporter = reporter;
	}
	@Override
	public String toString() {
		return "Card [ name=" + name + ", description=" + description + ", assignee=" + assignee
				+ ", reporter=" + reporter + "]";
	}
	
	
}
