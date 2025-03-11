package com.mb.trello.model;



public class User extends Model {
	private String name;
	private String emialId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmialId() {
		return emialId;
	}
	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", emialId=" + emialId + "]";
	}
	public User(String name, String emialId) {
		this.name = name;
		this.emialId = emialId;
	}
	
	
}
