package Pieces;
import Game.Color;
import Game.Type;

public class Bishop extends Piece {

	public Bishop(int x, int y) {
		super(x,y);
		this.pieceType = Type.BISHOP;
	}

	@Override
	public boolean isPathValid(int moveX, int moveY) {
		return false;
	}

	@Override
	public String toString() {
		return "B";
	}

}
