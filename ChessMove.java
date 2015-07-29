public class ChessMove {

	boolean isCapturing;
	char file;
	int rank;
	char ambiguity;
	boolean kingCastling;
	boolean queenCastling;
	ChessPiece cp;
	
	ChessMove(String move, int turn){
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
		char name,color;
		
		if(Character.isUpperCase(move.charAt(0)) && move.length() > 3){
			ambiguity = move.charAt(1);
			name = move.charAt(0);
		}
		else if(Character.isUpperCase(move.charAt(0))){
			ambiguity = ' ';
			name = move.charAt(0);
		}
		else{
			name = ' ';
		}
		
		if(turn == 1){
			color = 'W';
		}
		else {
			color = 'B';
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
