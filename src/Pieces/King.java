package Pieces;
import Game.Color;
import Game.Type;

public class King extends Piece {

	public King(int x, int y) {
		super(x,y);
		this.pieceType = Type.KING;
	}

	@Override
	public boolean isPathValid(int moveX, int moveY) {
		if (((Math.abs(this.posX - moveX) <= 1) && (this.posY - moveY <= 1)) || 
				((Math.abs(this.posY - moveY) <= 1) && (this.posX - moveX <= 1))) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "K";
	}
	
}
