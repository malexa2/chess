package Pieces;
import Game.Color;
import Game.Type;

public class Knight extends Piece {

	public Knight(int x, int y) {
		super(x,y);
		this.pieceType = Type.KNIGHT;
	}

	@Override
	public boolean isPathValid(int moveX, int moveY) {
		return false;
	}

	@Override
	public String toString() {
		return "N";
	}

}
