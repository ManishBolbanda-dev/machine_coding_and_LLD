package models;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Board {
	private final int end;
	private Dice dice;
	private Queue<Player> players;
	private List<Mover> snakes;
	private List<Mover> ladders;
	
	public Board(int end){
		this.end = end;
		this.players = new ArrayDeque<>();
		this.snakes = new ArrayList<>();
		this.ladders = new ArrayList<>();
	}
	public void addPlayer(Player player){
		players.add(player);
	}
	public void addSnake(Mover mover) {
		this.snakes.add(mover);
	}
	public void addLadder(Mover mover) {
		this.ladders.add(mover);
	}
	
	
	public int getEnd() {
		return end;
	}
	public Queue<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Queue<Player> players) {
		this.players = players;
	}
	public List<Mover> getSnakes() {
		return snakes;
	}
	public void setSnakes(List<Mover> snakes) {
		this.snakes = snakes;
	}
	public List<Mover> getLadders() {
		return ladders;
	}
	public void setLadders(List<Mover> ladders) {
		this.ladders = ladders;
	}
	public Player getCurrentPlayer() {
		return this.players.peek();
	}
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public void keepNextPlayerReady() {
		this.players.add(this.players.remove());
	}
	
	
	
	
	
	

}
