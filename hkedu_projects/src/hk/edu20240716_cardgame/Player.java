package hk.edu20240716_cardgame;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> player;
	
	public Player() {
		player=new ArrayList<Card>();
	}
	
	public ArrayList<Card> getPlayer() {
		return player;
	}
}
