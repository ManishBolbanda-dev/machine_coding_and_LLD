package com.mb.trello.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mb.trello.datastore.DataStoreGeneric;
import com.mb.trello.model.User;

public class UserServiceImpl implements UserService {
	
	DataStoreGeneric userStore = new DataStoreGeneric();
	
	@Override
	public long addUser(User user) {
		// TODO Auto-generated method stub
		return userStore.add(user);
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userStore.update(user);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return (User) userStore.getById(id);
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return userStore.delete(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> lst = new ArrayList<>();
		userStore.getAll().forEach(u -> lst.add((User) u));
		lst.sort(Comparator.comparingLong(u -> u.getId()));
		return lst;
	}

}
