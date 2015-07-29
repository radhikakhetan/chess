package chess;

public class ChessMove {

	boolean isCaptured;
	char file;
	int rank;
	char ambiguity;
	boolean kingCastling;
	boolean queenCastling;
	
	ChessMove(String move){
		if(move.equals("o-o")){
			kingCastling = true;
			queenCastling = false;
			isCaptured = false;
			file = ' ';
			rank = -1;
			ambiguity = ' ';
			return;
		}
		else if(move.equals("O-O-O")){
			kingCastling = false;
			queenCastling = true;
			isCaptured = false;
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
			isCaptured = true;
		}
		else{
			isCaptured = false;
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
	boolean isCaptured(){
		return isCaptured;
	}
	boolean isAmbiguous(){
		if(ambiguity == ' ')
			return false;
		else
			return true;
	}
	boolean isKingCastling(){
		return kingCastling;
	}
	boolean isQueenCastling(){
		return queenCastling;
	}
	void display(){
		System.out.println("Rank :"+rank);
		System.out.println("File :"+file);
		System.out.println("KingCastling :"+kingCastling);
		System.out.println("QueenCastling :"+queenCastling);
		System.out.println("Ambiguity :"+ambiguity);
		System.out.println("Captured :"+isCaptured);
	}
	public static void main(String args[]){
		ChessMove cm = new ChessMove("");
		cm.display();
	}
}
