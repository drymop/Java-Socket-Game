package socketgame.game.battleship.core;

import java.util.Map;

import socketgame.game.battleship.core.BattleshipBoard.Ship;

public class BattleshipGame {
	static final Map<Ship, Integer> SHIP_LENGTHS = Map.of(
			Ship.CARRIER,    5,
			Ship.BATTLESHIP, 4,
			Ship.CRUISER,    3,
			Ship.SUBMARINE,  3,
			Ship.DESTROYER,  2,
			Ship.NONE,       0);
	
	private int player = 0;
	
	static final int SHOT_MASK = 0b1000;
	
	private BattleshipBoard[] boards = new BattleshipBoard[2];
	
	public void setShip(int player, Ship ship, int cell, boolean horizontal) {
		int inc = horizontal? 1 : BattleshipBoard.BOARD_SIZE;
		for (int i = 0; i < SHIP_LENGTHS.get(ship); i++) {
			boards[player].content[cell] = BattleshipBoard.SHIP_MASKS.get(ship);
			cell += inc;
		}
	}
	
	public boolean shoot(int cell) {
		int opPlayer = 1 - player;
		if ((boards[opPlayer].content[cell] & SHOT_MASK) == 0) {
			boards[opPlayer].content[cell] |= SHOT_MASK;
			player = opPlayer;
			return true;
		} else
			return false;
	}
	
	
	
	
}
