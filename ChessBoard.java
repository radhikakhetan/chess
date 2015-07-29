import java.util.*;
import java.util.Map.Entry;

public class ChessBoard {
	Map<String, ChessPiece> chessboard;
	Map<Character, String> piecename;

	public ChessBoard() {
		chessboard = new TreeMap<String, ChessPiece>();
		chessboard.put("a1", new ChessPiece('R', 'W'));
		chessboard.put("b1", new ChessPiece('N', 'W'));
		chessboard.put("c1", new ChessPiece('B', 'W'));
		chessboard.put("d1", new ChessPiece('Q', 'W'));
		chessboard.put("e1", new ChessPiece('K', 'W'));
		chessboard.put("f1", new ChessPiece('B', 'W'));
		chessboard.put("g1", new ChessPiece('N', 'W'));
		chessboard.put("h1", new ChessPiece('R', 'W'));
		chessboard.put("a2", new ChessPiece(' ', 'W'));
		chessboard.put("b2", new ChessPiece(' ', 'W'));
		chessboard.put("c2", new ChessPiece(' ', 'W'));
		chessboard.put("d2", new ChessPiece(' ', 'W'));
		chessboard.put("e2", new ChessPiece(' ', 'W'));
		chessboard.put("f2", new ChessPiece(' ', 'W'));
		chessboard.put("g2", new ChessPiece(' ', 'W'));
		chessboard.put("h2", new ChessPiece(' ', 'W'));
		chessboard.put("a7", new ChessPiece(' ', 'B'));
		chessboard.put("b7", new ChessPiece(' ', 'B'));
		chessboard.put("c7", new ChessPiece(' ', 'B'));
		chessboard.put("d7", new ChessPiece(' ', 'B'));
		chessboard.put("e7", new ChessPiece(' ', 'B'));
		chessboard.put("f7", new ChessPiece(' ', 'B'));
		chessboard.put("g7", new ChessPiece(' ', 'B'));
		chessboard.put("h7", new ChessPiece(' ', 'B'));
		chessboard.put("a8", new ChessPiece('R', 'B'));
		chessboard.put("b8", new ChessPiece('N', 'B'));
		chessboard.put("c8", new ChessPiece('B', 'B'));
		chessboard.put("d8", new ChessPiece('Q', 'B'));
		chessboard.put("e8", new ChessPiece('K', 'B'));
		chessboard.put("f8", new ChessPiece('B', 'B'));
		chessboard.put("g8", new ChessPiece('N', 'B'));
		chessboard.put("h8", new ChessPiece('R', 'B'));

		piecename = new HashMap<Character, String>();
		piecename.put('K', "King");
		piecename.put('Q', "Queen");
		piecename.put('B', "Bishop");
		piecename.put('R', "Rook");
		piecename.put('N', "Knight");
		piecename.put(' ', "Pawn");
	}

	ChessPiece findPiece(String move, int turn) {
		char name = move.charAt(0);
		char color = move.charAt(1);
		if (turn == 1)
			color = 'W';
		else
			color = 'B';

		return new ChessPiece(name, color);
	}

	String findPreviousPosition(ChessMove move) {
		boolean captured = move.isCapturing();
		
		List<String> validMoves = move.getChessPiece().findAllValidMoves(move.getMove(), captured);
		for (String eachValid : validMoves) {
			if ( chessboard.containsKey(eachValid) ) {
				if ( move.getChessPiece().equals(chessboard.get(eachValid)) ) {
					if ( move.isAmbiguous() ) {
						if ( eachValid.contains(Character.toString(move.getAmbiguousPosition())) ) {
							return eachValid;
						}
					}
					return eachValid;
				}
			}
		}
		return " ";
	}

	void updateBoard(String previousPosition, String newPosition) {
		ChessPiece cp = chessboard.get(previousPosition);
		chessboard.remove(previousPosition);
		chessboard.put(newPosition, cp);
	}

	void displayBoard() {
		Iterator<Entry<String, ChessPiece>> it = chessboard.entrySet()
				.iterator();
		while (it.hasNext()) {
			String pos = it.next().getKey();
			ChessPiece cp = chessboard.get(pos);
			String piece = piecename.get(cp.name);
			if (cp.color == 'B') {
				piece = "Black " + piece;
			} else {
				piece = "White " + piece;
			}
			System.out.println(pos + " : " + piece);
		}
	}
	
	void performCastling(int turn, boolean kingSide) {
		if ( turn == 1 ) {
			if ( kingSide ) {
				updateBoard("e1", "g1");
				updateBoard("h1", "f1");
			}
			else {
				updateBoard("e1", "c1");
				updateBoard("a1", "d1");
			}
		}
		else {
			if ( kingSide ) {
				updateBoard("e8", "g8");
				updateBoard("h8", "f8");
			}
			else {
				updateBoard("e8", "c8");
				updateBoard("a8", "d8");
			}
		}
	}

	void move(String move, int turn) {
		ChessMove nextMove = new ChessMove(move, turn);
		if ( nextMove.isCastling() ) {
			performCastling(turn, nextMove.isKingCastling());
		}
		else {
			String previousPosition = findPreviousPosition(nextMove);
			updateBoard(previousPosition, nextMove.getMove());
		}
	}

}
