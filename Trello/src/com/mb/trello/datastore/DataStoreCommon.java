package com.mb.trello.datastore;

import java.util.HashMap;
import java.util.Map;

import com.mb.trello.model.Board;
import com.mb.trello.model.Card;
import com.mb.trello.model.CardList;
import com.mb.trello.model.User;

public class DataStoreCommon {
	Map<Long, User> idToUserMap = new HashMap<>();
	Map<Long, Board> idToBoard = new HashMap<>();
	Map<Long, CardList> idToCardList = new HashMap<>();
	Map<Long, Card> idToCard = new HashMap<>();
	
	public static long userIds = 0l;
	public static long boardIds = 0l;
	public static long cardlistIds = 0l;
	public static long cardIds = 0l;
	
	
	boolean addUser(User user) {
		user.setId(userIds++);
		idToUserMap.put(user.getId(), user);
		return true;
	}
	
	void updateUser(User user) {
		if(idToUserMap.get(user.getId()) != null) {
			idToUserMap.put(user.getId(), user);
		}else {
			throw new RuntimeException("User Not Found");
		}
	}
	void deleteUser(User user) {
		idToUserMap.remove(user.getId());
	}
	User getUserById(long id) {
		return idToUserMap.get(id);
	}
	
	boolean addBoard(Board board) {
		board.setId(boardIds);
		idToBoard.put(boardIds, board);
		boardIds++;
		return true;
	}
	
	 

	boolean addCardList(CardList cardList) {
		cardList.setId(cardlistIds);
		idToCardList.put(cardlistIds, cardList);
		cardlistIds++;
		return true;
	}
	
	boolean addCard(Card card) {
		card.setId(cardIds++);
		idToCard.put(card.getId(), card);
		return true;
	}
	
	
	
	
}
