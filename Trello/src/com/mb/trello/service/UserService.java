package com.mb.trello.service;

import java.util.List;

import com.mb.trello.model.User;

public interface UserService {
	
	public long addUser(User user);
	public boolean updateUser(User user);
	public User getUserById(long id);
	public boolean deleteUser(User user);
	public List<User> getAllUsers();
	
}
