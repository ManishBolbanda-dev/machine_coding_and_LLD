package com.mb.trello.model;

import java.util.List;

public class CardList extends Model {
	private String name;
	List<Card> cards;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public CardList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardList(long id, String name, List<Card> cards) {
		this.name = name;
		this.cards = cards;
	}
	@Override
	public String toString() {
		return "CardList [name=" + name + ", cards=" + cards + "]";
	}
	public CardList(String name, List<Card> cards) {
		this.name = name;
		this.cards = cards;
	}
	
	
	
}
