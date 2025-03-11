package com.mb.trello.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mb.trello.datastore.DataStoreGeneric;
import com.mb.trello.model.Card;
import com.mb.trello.model.CardList;
import com.mb.trello.model.User;

public class CardServiceImpl {
	

	DataStoreGeneric cardStore = new DataStoreGeneric();
	
	public long addCard(Card card) {
		return cardStore.add(card);
	}
	
	public Card getCardById(long id) {
		// TODO Auto-generated method stub
		return (Card) cardStore.getById(id);
	}
	
	public List<Card> getAllCards() {
		// TODO Auto-generated method stub
		List<Card> lst = new ArrayList<>();
		cardStore.getAll().forEach(u -> lst.add((Card) u));
		lst.sort(Comparator.comparingLong(u -> u.getId()));
		return lst;
	}
	
	
}
