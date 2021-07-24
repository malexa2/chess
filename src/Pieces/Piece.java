package Pieces;
import Game.*;

public abstract class Piece {

	protected int posX;
	protected int posY;
	protected Type pieceType;

	/**
	 * Constructor for a piece
	 * @param x x location of the piece
	 * @param y y location of the piece
	 */
	public Piece(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public Type getType() {
		return pieceType;
	}
	
	public abstract boolean isPathValid(int moveX, int moveY);
	
	@Override
	public abstract String toString();
	
	
	
}
