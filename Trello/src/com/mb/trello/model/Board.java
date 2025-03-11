package com.mb.trello.model;

import java.util.List;

public class Board extends Model {
	private String name;
	private PrivacyEnum privacy;
	private String url;
	List<User> members;
	List<CardList> lists;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PrivacyEnum getPrivacy() {
		return privacy;
	}
	public void setPrivacy(PrivacyEnum privacy) {
		this.privacy = privacy;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public List<CardList> getLists() {
		return lists;
	}
	public void setLists(List<CardList> lists) {
		this.lists = lists;
	}
	
	public Board() {}
	
	public Board(String name, PrivacyEnum privacy, String url, List<User> members, List<CardList> lists) {
		this.name = name;
		this.privacy = privacy;
		this.url = url;
		this.members = members;
		this.lists = lists;
	}
	@Override
	public String toString() {
		return "Board [ name=" + name + ", privacy=" + privacy + ", url=" + url + ", members=" + members
				+ ", lists=" + lists + "]";
	}
	
	
	
}
