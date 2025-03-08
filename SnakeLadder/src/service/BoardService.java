package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Board;
import models.Player;

public class BoardService {
	
	private static final int MAX_SIX_THRESHOLD = 3;
	Map<Integer, Integer> movePositions;
	private Board board;
	private final int SIX = 6;
	List<Player> winners = new ArrayList<>();
	
	
	public BoardService(Board board) {
		this.board = board;
		this.movePositions = new HashMap<>();
	}
	
	void loadSnakesAndLadders(){
		// loading all movers, key in Map:  for Snake is head and for Ladder is bottom position
		this.board.getSnakes().forEach(s  -> movePositions.put(s.getFrom(), s.getTo()));
		this.board.getLadders().forEach(lad  -> movePositions.put(lad.getFrom(), lad.getTo()));
	}
	void shufflePlayer() {
		// shuffle board.players, if they need to start the game with random player from the list
	}
	public List<Player> startGame(){
		System.out.println("Starting Game...");
		this.loadSnakesAndLadders();
		while(this.board.getPlayers().size()>1) {
			Player cp = this.board.getCurrentPlayer();
			int prevPosition = cp.getCurrentPosition();
			int diceValue = this.board.getDice().roll();
			int sixCount = 0;
			while(diceValue == this.SIX) {
				sixCount++;
				if(sixCount == MAX_SIX_THRESHOLD) {
					System.out.println("MAX Six count breached. resetting "+cp.getName()+" position to prev "+prevPosition);
					cp.setCurrentPosition(prevPosition);
					break;
				}
				this.updatePlayerPosition(cp, diceValue);
				if(hasPlayerWon(cp)) {
					break;
				}
				diceValue = this.board.getDice().roll();
			}
			updatePlayerPosition(cp, diceValue);
			if(!hasPlayerWon(cp)) {
				this.board.keepNextPlayerReady();
			}			
		}
		return winners;
	}

	private boolean hasPlayerWon(Player cp) {
		boolean hasWon = cp.getCurrentPosition() == this.board.getEnd();
		if(hasWon) {
			this.winners.add(cp);
			this.board.getPlayers().remove();
			System.out.println(cp.getName()+" Won the game and is being Removed from the board.");
		}
		return hasWon;
	}

	private void updatePlayerPosition(Player cp, int diceValue) {
		int newPosition = cp.getCurrentPosition()+diceValue ; 
		if( newPosition <= this.board.getEnd()) {
			while(this.movePositions.containsKey(newPosition)) {
				System.out.println(cp.getName()+" got MOVED from "+ newPosition+" to "+this.movePositions.get(newPosition));
				newPosition = this.movePositions.get(newPosition);
			}
			System.out.println(cp.getName()+" rolled dice "+ diceValue+" updated position from "+cp.getCurrentPosition()  +" to "+newPosition);
			cp.setCurrentPosition(newPosition);
		}
	}
	
}
