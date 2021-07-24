package Game;

import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.*;

import Pieces.*;

public class Board {
	
	private final Square[][] board = new Square[8][8];
	private Player pW, pB;
	
	/**
	 * Constructor for board
	 * Creates a fresh board with pieces
	 * @param white the white player
	 * @param black the black player
	 */
	public Board(Player white, Player black) {
		pW = white;
		white.setColor(Color.WHITE);
		
		pB = black;
		black.setColor(Color.BLACK);
		
		char[] alphabet = "ABCDEFGH".toCharArray();
		char[] numbers = "87654321".toCharArray();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Square(i,j);
				board[i][j].setButton
				(new JButton((String.valueOf(alphabet[j])+String.valueOf(numbers[i]))));
			}
		}
		board[0][0].getButton().setIcon(new ImageIcon("images\\bPawn.jpg"));
		
		resetBoard();
		
	}
	
	public Square[][] getBoard() {
		return this.board;
	}
	
	/**
	 * Puts the board in starting position
	 */
	public void resetBoard() {
		
		ArrayList<Piece> white = new ArrayList<>();
		ArrayList<Piece> black = new ArrayList<>();
		
		
		white.add(new King(7,4));
		white.add(new Queen(7,3));
		white.add(new Bishop(7,2));
		white.add(new Bishop(7,5));
		white.add(new Knight(7,1));
		white.add(new Knight(7,6));
		white.add(new Rook(7,0));
		white.add(new Rook(7,7));
		
		black.add(new King(0,4));
		black.add(new Queen(0,3));
		black.add(new Bishop(0,2));
		black.add(new Bishop(0,5));
		black.add(new Knight(0,1));
		black.add(new Knight(0,6));
		black.add(new Rook(0,0));
		black.add(new Rook(0,7));
		
		board[7][4].setPiece(white.get(0));
		board[0][4].setPiece(black.get(0));
		
		board[7][3].setPiece(white.get(1));
		board[0][3].setPiece(black.get(1));
		
		board[7][2].setPiece(white.get(2));
		board[7][5].setPiece(white.get(3));
		board[0][2].setPiece(black.get(2));
		board[0][5].setPiece(black.get(3));
		
		board[7][1].setPiece(white.get(4));
		board[7][6].setPiece(white.get(5));
		board[0][1].setPiece(black.get(4));
		board[0][6].setPiece(black.get(5));
		
		board[7][0].setPiece(white.get(6));
		board[7][7].setPiece(white.get(7));
		board[0][0].setPiece(black.get(6));
		board[0][7].setPiece(black.get(7));
		
		for (int i = 0; i < 8; i++) {
			white.add(new Pawn(6,i));
			black.add(new Pawn(1,i));
			board[6][i].setPiece(white.get(8+i));
			board[1][i].setPiece(black.get(8+i));
		}
		
		pW.assignPieces(white);
		pB.assignPieces(black);
	}
	
	/**
	 * Checks if a space is empty
	 * @param x x coordinate of space
	 * @param y y coordinate of space
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty(int x, int y) {
		if (isValidSquare(x,y) && board[x][y].getPiece() == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if square is on the board
	 * @param x x coordinate of square
	 * @param y y coordinate of square
	 * @return true if valid, false otherwise
	 */
	public boolean isValidSquare(int x, int y) {
		if (x >= 0 && x <= 7) {
			if (y >= 0 && y <= 7) {
				return true;
			}
		}
		return false;
	}
	
	public void show() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Starts and runs the game until checkmate or stalemate is achieved
	 */
	public void start() {
		
		boolean turn = true; //white = true, black = false
		
		while (true) {
			show();
			
			if (turn) {
				if (move(pW)) {
					turn = false; //sets to black's turn
					continue;
				}
				else {
					break; //mate
				}
			}
			else {
				if (move(pB)) {
					turn = true; //sets to white's turn
					continue;
				}
				else {
					break; //mate
				}
			}
		}
	}
	
	/**
	 * Allows the player to make a move on their turn
	 * @param p black or white's player as determined by start()
	 * @return false if checkmate or stalemate is achieved, true otherwise
	 */
	public boolean move(Player p) {
		
		Scanner hi = new Scanner(System.in);
		System.out.println(p.getColor() + " to move. Enter piece.");
		String pieceString = p.listPieces();
		System.out.println(pieceString);
		
		String move = hi.nextLine();
		
		if (move.equals("stop")) {System.exit(0);}
		
		if (pieceString.contains(move)) { //If player chooses a piece to move
			System.out.println(move + " to which square?");
			hi.nextLine();
			
			char moveRank = move.charAt(0);
			int moveFile = move.charAt(1);
			
			Piece pieceToMove = board[moveRank][moveFile].getPiece();
			
			if (pieceToMove.isPathValid(moveRank, moveFile)) {
				
			}
			else {
				
			}
		}
		else if (move.equals("O") || move.equals("0")) { //If player chooses to castle
			System.out.println("King or queen side castle?");
			hi.nextLine();
			
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		
		Player p1 = new Player();
		Player p2 = new Player();
		Board b = new Board(p1, p2);
		b.resetBoard();
		
		JFrame frame = new JFrame("Chess");
		frame.setBounds(10, 10, 818, 847);
		
		//frame.setUndecorated(true);
		
		JPanel panel = new JPanel() { //Adds black and white colors to squares
			public void paint(Graphics g) {
				boolean w = true;
				for (int row = 0; row < 8; row++) {
					for (int col = 0; col < 8; col++) {
						if(w)
							g.setColor(new java.awt.Color(255,240,200));
						else
							g.setColor(new java.awt.Color(30,5,0));
						g.fillRect(col*100, row*100, 100, 100);
						w=!w;
					}
					w=!w;
				}
			}
		};
		panel.setLayout(new GridLayout(8,8,10,10));
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				panel.add(b.getBoard()[i][j].getButton());
			}
		}
		
		
		
		//JButton b=new JButton(new ImageIcon("pieces.jpg"));  
		 
		 
		//frame.getRootPane().setWindowDecorationStyle(3);
		frame.add(panel);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
		
		/*
		Player p1 = new Player();
		Player p2 = new Player();
		
		Board b = new Board(p1, p2);
		b.start();
		*/
	}
	
}
