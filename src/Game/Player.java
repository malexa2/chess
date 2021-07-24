package Game;

import java.util.*;
import Pieces.*;

public class Player {
	
	private ArrayList<Piece> pieces;
	private Color col;
	
	private int numQs = 0;
	private int numRs = 0;
	private int numBs = 0;
	private int numNs = 0;
	private int numPs = 0;
	
	private final char[] rank = new char[]{'a','b','c','d','e','f','g','h'};
	private final int[] file = new int[]{8,7,6,5,4,3,2,1};
	
	/**
	 * Setter for the player's color
	 * @param c color
	 */
	public void setColor(Color c) {
		this.col = c;
	}
	
	/**
	 * Getter for the player's color
	 * @return the player's color
	 */
	public Color getColor() {
		return this.col;
	}
	
	/**
	 * Getter for the player's pieces
	 * @return ArrayList of pieces
	 */
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}

	/**
	 * Setter for the player's pieces, used by Board.resetBoard()
	 * @param p ArrayList of pieces
	 */
	public void assignPieces(ArrayList<Piece> p) {
		pieces = p;
		resetPieces();
		
		for (int i = 0; i < p.size(); i++) {//loop counts number of each piece
			Type t = p.get(i).getType();
			
			switch (t) { //Counts number of pieces
			case QUEEN:
				numQs++;
				break;
			case ROOK:
				numRs++;
				break;
			case BISHOP:
				numBs++;
				break;
			case KNIGHT:
				numNs++;
				break;
			case PAWN:
				numPs++;
				break;
			default:
			}
		}
	}
	
	/**
	 * Adds a piece to the player's list, used when pawn is promoted
	 * @param p piece to be added
	 */
	public void assignPieces(Piece p) {
		pieces.add(p);
	}
	
	/**
	 * Removes a piece from a player's list and from its spot on the board
	 * @param b board being changed
	 * @param p piece to be removed
	 */
	public void removePiece(Board b, Piece p) {
		if (pieces.contains(p)) {
			pieces.remove(p);
			b.getBoard()[p.getX()][p.getY()].removePiece();
		}
	}
	
	/**
	 * Resets each piece count to 0
	 */
	public void resetPieces() {
		numQs = 0;
		numRs = 0;
		numBs = 0;
		numNs = 0;
		numPs = 0;
	}
	
	/**
	 * Lists the player's options for pieces to move
	 * @return String of pieces the player can move
	 */
	public String listPieces() {
		String s = "K";
		
		if (numQs == 1) {s = s+" Q";}
		else if (numQs > 1) {
			for (int i = 1; i < pieces.size(); i++) {
				if (pieces.get(i).getType() == Type.QUEEN) {
					s = s + " Q" + 
							rank[pieces.get(i).getY()] +
							file[pieces.get(i).getX()]; 
				
				}
			}
		}
		
		if (numRs == 1) {s = s+" R";}
		else if (numRs > 1) {
			for (int i = 1; i < pieces.size(); i++) {
				if (pieces.get(i).getType() == Type.ROOK) {
					s = s + " R" + 
							rank[pieces.get(i).getY()] +
							file[pieces.get(i).getX()]; 
				}
			}
		}
		
		if (numBs == 1) {s = s+" B";}
		else if (numBs > 1) {
			for (int i = 1; i < pieces.size(); i++) {
				if (pieces.get(i).getType() == Type.BISHOP) {
					s = s + " B" + 
							rank[pieces.get(i).getY()] +
							file[pieces.get(i).getX()]; 
				}
			}
		}
		
		if (numNs == 1) {s = s+" N";}
		else if (numNs > 1) {
			for (int i = 1; i < pieces.size(); i++) {
				if (pieces.get(i).getType() == Type.KNIGHT) {
					s = s + " N" + 
							rank[pieces.get(i).getY()] +
							file[pieces.get(i).getX()]; 
				}
			}
		}
		
		if (numPs == 1) {s = s+" P";}
		else if (numPs > 1) {
			for (int i = 1; i < pieces.size(); i++) {
				if (pieces.get(i).getType() == Type.PAWN) {
					s = s + " P" + 
							rank[pieces.get(i).getY()] +
							file[pieces.get(i).getX()]; 
				}
			}
		}
		
		/*for (int i = 1; i < pieces.size(); i++) {
			s = s + " " + pieces.get(i);
		}*/
		
		
		
		return s;
	}

}
