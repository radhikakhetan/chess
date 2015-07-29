public class ChessMove {

	boolean isCapturing;
	char file;
	int rank;
	char ambiguity;
	boolean kingCastling;
	boolean queenCastling;
	ChessPiece cp;
	
	ChessMove(String move, int turn) {
		queenCastling = false;
		kingCastling = false;
		ambiguity = ' ';
		file = ' ';
		rank = -1;
		isCapturing = false;
		
		if(move.equals("O-O")){
			kingCastling = true;
			return;
		}
		else if(move.equals("O-O-O")){
			queenCastling = true;
			return;
		}
		
		char lastChar = move.charAt(move.length()-1);
		if (lastChar == '+' || lastChar == '#'){
			move = removeLastChar(move);
		}
		rank = Character.getNumericValue((move.charAt(move.length() - 1)));
		file = move.charAt(move.length() - 2);
		
		if(move.contains("x")){
			isCapturing = true;
		}
		
		if(move.length() > 3){
			ambiguity = move.charAt(1);
		}

		char name = ' ';
		if(Character.isUpperCase(move.charAt(0))){
			name = move.charAt(0);
		}
		
		char color = 'B';
		if(turn == 1) {
			color = 'W';
		}
		cp = new ChessPiece(name,color);
		
	}
	ChessPiece getChessPiece(){
		return cp;
	}
	private String removeLastChar(String str) {
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
