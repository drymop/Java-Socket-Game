package socketgame.game.battleship.core;

import java.util.Map;

public class BattleshipBoard {
	public static enum Ship {
		CARRIER,
		BATTLESHIP,
		CRUISER,
		SUBMARINE,
		DESTROYER,
		NONE,
		ANY
	}
	
	public static final Map<Ship, Integer> SHIP_MASKS = Map.of(
			Ship.CARRIER,    0b001,
			Ship.BATTLESHIP, 0b010,
			Ship.CRUISER,    0b011,
			Ship.SUBMARINE,  0b100,
			Ship.DESTROYER,  0b101,
			Ship.NONE     ,  0b000,
			Ship.ANY      ,  0b111);
	
	public static final int BOARD_SIZE = 10;
	public int[] content = new int[BOARD_SIZE * BOARD_SIZE];
	
	public BattleshipBoard hideShips() {
		BattleshipBoard returnBoard = new BattleshipBoard();
		for (int cell = 0; cell <= returnBoard.content.length; cell++) {
			// there's a ship in this cell
			if ((this.content[cell] & SHIP_MASKS.get(Ship.ANY)) != 0)
				returnBoard.content[cell] = this.content[cell] | SHIP_MASKS.get(Ship.ANY);
		}
		return returnBoard;
	}
}
