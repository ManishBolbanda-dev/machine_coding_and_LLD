package com.mb.trello.datastore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mb.trello.model.Board;
import com.mb.trello.model.Card;
import com.mb.trello.model.CardList;
import com.mb.trello.model.Model;
import com.mb.trello.model.User;

public class DataStoreGeneric {
	Map<Long, Model> idToMap = new HashMap<>();
	private long incrementalId = 0l;
	
	public long add(Model obj) {
		obj.setId(incrementalId++);
		idToMap.put(obj.getId(), obj);
		return obj.getId();
	}
	
	public boolean update(Model obj) {
		if(idToMap.get(obj.getId()) != null) {
			idToMap.put(obj.getId(), obj);
			return true;
		}else {
			throw new RuntimeException("Data Not Found");
		}
	}
	public boolean delete(Model obj) {
		idToMap.remove(obj.getId());
		return true;
	}
	public Model getById(long id) {
		return idToMap.get(id);
	}
	public List<Model> getAll(){
		return this.idToMap.values().stream().toList();
	}
}
