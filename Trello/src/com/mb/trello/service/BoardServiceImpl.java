package com.mb.trello.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mb.trello.datastore.DataStoreGeneric;
import com.mb.trello.model.Board;
import com.mb.trello.model.User;

public class BoardServiceImpl {
	
	DataStoreGeneric boardStore = new DataStoreGeneric();
	
	public long addBoard(Board board) {
		return boardStore.add(board);
	}
	
	public Board getBoardById(long id) {
		// TODO Auto-generated method stub
		return (Board) boardStore.getById(id);
	}
	
	public List<Board> getAllBoards() {
		// TODO Auto-generated method stub
		List<Board> lst = new ArrayList<>();
		boardStore.getAll().forEach(u -> lst.add((Board) u));
		lst.sort(Comparator.comparingLong(u -> u.getId()));
		return lst;
	}
}
