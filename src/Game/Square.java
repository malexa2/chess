package Game;

import javax.swing.JButton;

import Pieces.*;

public class Square {
	
	private Piece piece;
	private int x;
	private int y;
	private JButton button;
	
	/**
	 * Constructor for empty square
	 * @param x x index of square
	 * @param y y index of square
	 */
	public Square(int x, int y) {
		setX(x);
		setY(y);
		setPiece(null);
	}

	/**
	 * Constructor for square with piece on it
	 * @param x x index of square
	 * @param y y index of square
	 * @param piece piece on the square
	 */
	public Square(int x, int y, Piece piece) {
		setX(x);
		setY(y);
		setPiece(piece);
	}
	
	/**
	 * Setter for x index
	 */
	public void setX(int newX) {
		this.x = newX;
	}
	
	/**
	 * Setter for y index
	 */
	public void setY(int newY) {
		this.y = newY;
	}
	
	/**
	 * Setter for piece
	 */
	public void setPiece(Piece newPiece) {
		this.piece = newPiece;
	}
	
	public void setButton(JButton b) {
		this.button = b;
	}
	
	public JButton getButton() {
		return this.button;
	}
	
	/**
	 * Getter for x index
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Getter for y index
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Getter for piece
	 */
	public Piece getPiece() {
		return this.piece;
	}
	
	/**
	 * Removes any piece from the square
	 */
	public void removePiece() {
		this.piece = null;
	}
	
	/**
	 * Returns if the square is empty or not
	 * @return true if empty, false if there is a piece
	 */
	public boolean isEmpty() {
		if (getPiece() == null) { return true; }
		return false;
	}
	
	/**
	 * Returns the letter form of the piece or "None" if the square is empty
	 */
	@Override
	public String toString() {
		if (isEmpty()) { return "O"; }
		return this.piece.toString();
	}

}
