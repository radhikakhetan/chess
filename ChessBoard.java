
import java.util.*;

public class ChessBoard {
	
	Map<String,ChessPiece> chessboard;
	Map<Character,String> piecename;
	
	ChessBoard(){
		chessboard = new HashMap<String,ChessPiece>() ;
		chessboard.put("a1", new ChessPiece('R','W')) ;
		chessboard.put("b1", new ChessPiece('N','W')) ;
		chessboard.put("c1", new ChessPiece('B','W')) ;
		chessboard.put("d1", new ChessPiece('Q','W')) ;
		chessboard.put("e1", new ChessPiece('K','W')) ;
		chessboard.put("f1", new ChessPiece('B','W')) ;
		chessboard.put("g1", new ChessPiece('N','W')) ;
		chessboard.put("h1", new ChessPiece('R','W')) ;
		chessboard.put("a2", new ChessPiece(' ','W')) ;
		chessboard.put("b2", new ChessPiece(' ','W')) ;
		chessboard.put("c2", new ChessPiece(' ','W')) ;
		chessboard.put("d2", new ChessPiece(' ','W')) ;
		chessboard.put("e2", new ChessPiece(' ','W')) ;
		chessboard.put("f2", new ChessPiece(' ','W')) ;
		chessboard.put("g2", new ChessPiece(' ','W')) ;
		chessboard.put("h2", new ChessPiece(' ','W')) ;
		chessboard.put("a7", new ChessPiece(' ','B')) ;
		chessboard.put("b7", new ChessPiece(' ','B')) ;
		chessboard.put("c7", new ChessPiece(' ','B')) ;
		chessboard.put("d7", new ChessPiece(' ','B')) ;
		chessboard.put("e7", new ChessPiece(' ','B')) ;
		chessboard.put("f7", new ChessPiece(' ','B')) ;
		chessboard.put("g7", new ChessPiece(' ','B')) ;
		chessboard.put("h7", new ChessPiece(' ','B')) ;
		chessboard.put("a8", new ChessPiece('R','B')) ;
		chessboard.put("b8", new ChessPiece('N','B')) ;
		chessboard.put("c8", new ChessPiece('B','B')) ;
		chessboard.put("d8", new ChessPiece('Q','B')) ;
		chessboard.put("e8", new ChessPiece('K','B')) ;
		chessboard.put("f8", new ChessPiece('B','B')) ;
		chessboard.put("g8", new ChessPiece('N','B')) ;
		chessboard.put("h8", new ChessPiece('R','B')) ;
		
		piecename = new HashMap<Character,String>();
		piecename.put('K', "King");
		piecename.put('Q', "Queen");
		piecename.put('B', "Bishop");
		piecename.put('R', "Rook");
		piecename.put('N', "Knight");
		piecename.put(' ', "Pawn");
		
	}
	char findPiece(String move){
		return 0;
		
	}
	String findPreviousPosition(char piece, String move){
		return move;
		
	}
	void updateBoard(String previous_position, String new_position){
		
		ChessPiece cp = chessboard.get(previous_position);
		chessboard.remove(previous_position);
		chessboard.put(new_position, cp);
		
	}
	void displayBoard(){
		Iterator it = chessboard.entrySet().iterator();
		while(it.hasNext()){
			String 
		}
		
	}
	void move(String move){
		//calls findPiece
		//findPreviousPosition
		//updateBoard
		//displayBoard
	}
	public static void main(String args[]){
		
	}
}
