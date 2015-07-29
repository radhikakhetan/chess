package chess;

public class ChessMove {

	boolean isCapturing;
	char file;
	int rank;
	char ambiguity;
	boolean kingCastling;
	boolean queenCastling;
	
	ChessMove(String move){
		if(move.equals("o-o")){
			kingCastling = true;
			queenCastling = false;
			isCapturing = false;
			file = ' ';
			rank = -1;
			ambiguity = ' ';
			return;
		}
		else if(move.equals("O-O-O")){
			kingCastling = false;
			queenCastling = true;
			isCapturing = false;
			file = ' ';
			rank = -1;
			ambiguity = ' ';
			return;
		}
		 char lastChar = move.charAt(move.length()-1);
		 if (lastChar == '+' || lastChar == '#'){
			 move = removeLastChar(move);
		 }
		rank = Character.getNumericValue((move.charAt(move.length() - 1)));
		file = move.charAt(move.length() - 2);
		queenCastling = false;
		kingCastling = false;
		if(move.contains("x")){
			isCapturing = true;
		}
		else{
			isCapturing = false;
		}
		if(move.charAt(0) >= 'A' && move.charAt(0) <= 'Z' && move.length() > 3){
			ambiguity = move.charAt(1);
		}
		else
			ambiguity = ' ';
		
	}
	private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
	boolean isCapturing(){
		return isCapturing;
	}
	boolean isAmbiguous(){
		if(ambiguity == ' ')
			return false;
		else
			return true;
	}
	char getAmbiguousPosition(){
		return ambiguity;
	}
	boolean isCastling(){
		return kingCastling || queenCastling;
	}
	boolean isKingCastling(){
		return kingCastling;
	}
	boolean isQueenCastling(){
		return queenCastling;
	}
    String getMove(){
    	return file+""+rank;
    }
	
}
