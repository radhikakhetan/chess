package chess;

public class ChessMove {

	boolean captured;
	char file;
	int rank;
	char ambiguity;
	boolean kingCastling;
	boolean queenCastling;
	
	ChessMove(String move){
		if(move.equals("o-o")){
			kingCastling = true;
			queenCastling = false;
			captured = false;
			file = ' ';
			rank = -1;
			ambiguity = ' ';
			return;
		}
		else if(move.equals("OOO")){
			kingCastling = false;
			queenCastling = true;
			captured = false;
			file = ' ';
			rank = -1;
			ambiguity = ' ';
			return;
		}

		rank = Character.getNumericValue((move.charAt(move.length() - 1)));
		file = move.charAt(move.length() - 2);
		queenCastling = false;
		kingCastling = false;
		if(move.contains("x")){
			captured = true;
		}
		else{
			captured = false;
		}
		
	}
	boolean isCaptured(){
		
	}
	boolean isAmbigous(){
		
	}
	boolean isKingCastling(){
		
	}
	boolean isQueenCastling(){
		
	}

}
