public class ChessMove {

	boolean isCapturing;
	char file;
	int rank;
	char ambiguity;
	boolean kingCastling;
	boolean queenCastling;
	boolean isEnpassant;
	ChessPiece cp;

	ChessMove(String move, int turn) {
		queenCastling = false;
		kingCastling = false;
		ambiguity = ' ';
		file = ' ';
		rank = -1;
		isCapturing = false;
		isEnpassant = false;

		if (move.equals("O-O")) {
			kingCastling = true;
			return;
		} 
		
		if (move.equals("O-O-O")) {
			queenCastling = true;
			return;
		}

		if (move.contains("+") || move.contains("#")) {
			move = move.replace("+", "");
			move = move.replace("#", "");
		} 
		
		if (move.contains("e.p.")){
			isEnpassant = true;
			move = move.replace("e.p.", "");
		}
		
		rank = Character.getNumericValue((move.charAt(move.length() - 1)));
		file = move.charAt(move.length() - 2);
		if (move.contains("x")) {
			isCapturing = true;
		}

		if (Character.isUpperCase(move.charAt(0))){
			if ( move.length() > 3 && move.charAt(1) != 'x') {
				ambiguity = move.charAt(1);
			}
		}
		else if(Character.isLowerCase(move.charAt(0)) && move.length() > 2){
			ambiguity = move.charAt(0);
		}

		char name = ' ';
		if (Character.isUpperCase(move.charAt(0))) {
			name = move.charAt(0);
		}

		char color = 'B';
		if (turn == 1) {
			color = 'W';
		}
		cp = new ChessPiece(name, color);
	}

	ChessPiece getChessPiece() {
		return cp;
	}

	boolean isCapturing() {
		return isCapturing;
	}

	boolean isAmbiguous() {
		if (ambiguity == ' ')
			return false;
		else
			return true;
	}

	char getAmbiguousPosition() {
		return ambiguity;
	}

	boolean isCastling() {
		return kingCastling || queenCastling;
	}

	boolean isKingCastling() {
		return kingCastling;
	}

	boolean isQueenCastling() {
		return queenCastling;
	}

	boolean isEnpassant() {
		return isEnpassant;
	}
	char getFile(){
		return file;
	}
	int getRank(){
		return rank;
	}
	String getMove() {
		return file + "" + rank;
	}
}
