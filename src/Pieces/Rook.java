package Pieces;
import Game.Color;
import Game.Type;

public class Rook extends Piece {

	public Rook(int x, int y) {
		super(x,y);
		this.pieceType = Type.ROOK;
	}

	@Override
	public boolean isPathValid(int moveX, int moveY) {
		return false;
	}

	@Override
	public String toString() {
		return "R";
	}

}
