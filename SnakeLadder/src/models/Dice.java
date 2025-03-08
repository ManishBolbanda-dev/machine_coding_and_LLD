package models;

import java.util.Random;

public class Dice {
	private int count;
	private int side;
	
	
	public Dice(int count, int side) {
		super();
		this.count = count;
		this.side = side;
	}


	public int roll() {
		Random r = new Random();
		int rollValue=0;
		for(int i=0; i<count; i++) {
			rollValue += Math.abs(r.nextInt())%this.side;
		}
		return rollValue;
		
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getSide() {
		return side;
	}


	public void setSide(int side) {
		this.side = side;
	}
	
	
}
