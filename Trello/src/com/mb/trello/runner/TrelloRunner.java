package com.mb.trello.runner;

import java.util.ArrayList;
import java.util.List;

import com.mb.trello.model.Board;
import com.mb.trello.model.Card;
import com.mb.trello.model.CardList;
import com.mb.trello.model.PrivacyEnum;
import com.mb.trello.model.User;
import com.mb.trello.service.BoardServiceImpl;
import com.mb.trello.service.CardListServiceImpl;
import com.mb.trello.service.CardServiceImpl;
import com.mb.trello.service.UserService;
import com.mb.trello.service.UserServiceImpl;

public class TrelloRunner {
	
	static UserService userService = new UserServiceImpl();
	static BoardServiceImpl boardService = new BoardServiceImpl();
	static CardListServiceImpl cardListServiceImpl = new CardListServiceImpl();
	static CardServiceImpl cardServiceImpl = new CardServiceImpl();
	
	
	public static void main(String[] args) {
		System.out.println("Hello, Trello");
		
		// create user
		User u1 = new User("John", "john@river.com");
		User u2 = new User("Sam", "sam.com");
		User u3 = new User("Lex", "lex.com");
		User u4 = new User("Rohit", "rr.com");
		User u5 = new User("Varun", "var.com");
		
		long uid1 = userService.addUser(u1);
		System.out.println("created user with id " +uid1);
		
		userService.addUser(u2);
		userService.addUser(u3);
		userService.addUser(u4);
		long uid5 = userService.addUser(u5);
		System.out.println("created user with id " +uid5);
		
		List<User> allUsers = userService.getAllUsers();
		System.out.println(allUsers);
		
	// write 3 more service board service, list service, card service
		Board board1 = new Board("test nmae 1", PrivacyEnum.PUBLIC, null, allUsers, new ArrayList<>());
		long bId1 = boardService.addBoard(board1);
		System.out.println("crated borad id: "+bId1);
		
		CardList cl1 = new CardList("workflow feature", new ArrayList<>());
		long clid1 = cardListServiceImpl.addCardList(cl1);
		System.out.println("created cardlist id is: "+clid1);
		CardList cl2 = new CardList("entitlement feature", new ArrayList<>());
		long clid2 = cardListServiceImpl.addCardList(cl2);
		System.out.println("created cardlist id is: "+clid2);
		
		Card card = new Card("bpmn diagram", "create a bpmn for workflow", u1);
		long cid1 = cardServiceImpl.addCard(card);
		System.out.println("created card id: "+cid1);
		
//		add card into a list and list inot a group.
		
		cardListServiceImpl.addCardInList(card, clid1);
		
		System.out.println("All card list: "+cardListServiceImpl.getAllCardLists());
		
	}
}
