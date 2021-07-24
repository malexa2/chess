package Pieces;
import Game.Color;
import Game.Type;

public class Pawn extends Piece {

	public Pawn(int x, int y) {
		super(x,y);
		this.pieceType = Type.PAWN;
	}

	@Override
	public boolean isPathValid(int moveX, int moveY) {
		return false;
	}

	@Override
	public String toString() {
		return "P";
	}

}
