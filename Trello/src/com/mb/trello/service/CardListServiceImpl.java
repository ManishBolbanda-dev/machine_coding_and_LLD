package com.mb.trello.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.mb.trello.datastore.DataStoreGeneric;
import com.mb.trello.model.Card;
import com.mb.trello.model.CardList;
import com.mb.trello.model.User;

public class CardListServiceImpl {
DataStoreGeneric cardListStore = new DataStoreGeneric();
	
	public long addCardList(CardList cardList) {
		return cardListStore.add(cardList);
	}
	
	public CardList getCardListById(long id) {
		// TODO Auto-generated method stub
		return (CardList) cardListStore.getById(id);
	}
	
	public List<CardList> getAllCardLists() {
		// TODO Auto-generated method stub
		List<CardList> lst = new ArrayList<>();
		cardListStore.getAll().forEach(u -> lst.add((CardList) u));
		lst.sort(Comparator.comparingLong(u -> u.getId()));
		return lst;
	}
	
	public void addCardInList(Card card, long listId) {
		if(isCardExistInList(card.getId(), listId)) {
			System.out.println("Card Already Exist");
			return;
		}
		getCardListById(listId).getCards().add(card);
		
	}
	public boolean isCardExistInList(long cardId, long cardListId) {
		Optional<Card> op = getCardListById(cardListId).getCards().stream().filter(c -> c.getId() == cardId).findFirst();
		return op.isPresent();
	}
}
