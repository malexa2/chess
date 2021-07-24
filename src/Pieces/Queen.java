package Pieces;
import Game.Color;
import Game.Type;

public class Queen extends Piece {

	public Queen(int x, int y) {
		super(x,y);
		this.pieceType = Type.QUEEN;
	}

	@Override
	public boolean isPathValid(int moveX, int moveY) {
		return false;
	}

	@Override
	public String toString() {
		return "Q";
	}

}
