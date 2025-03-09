package com.mb.machinecoding.models;

import java.util.List;

public class Group {
	private int groupId;
	private String groupName;
	private List<User> users;
	public Group(int groupId, String groupName, List<User> users) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.users = users;
	}
	
	
}
