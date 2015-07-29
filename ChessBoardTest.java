import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ChessBoardTest {


	@Test
	public void testFindPiece() {
		ChessBoard chessboard=new ChessBoard() ;
		ChessPiece valid = new ChessPiece ( 'K' , 'W' ) ;
		ChessPiece check = chessboard.findPiece("Ke8",1) ;
		assertEquals(valid, check);
		valid = new ChessPiece ( ' ' , 'W' ) ;
		check = chessboard.findPiece("e8",1) ;
		assertEquals(valid, check);
		valid = new ChessPiece ( 'K' , 'B' ) ;
		check = chessboard.findPiece("Ke8",2) ;
		assertEquals(valid, check);
		
	}

	
	public void testFindPreviousPosition() {
		String valid = "e2" ;
		ChessBoard chessboard=new ChessBoard() ;
		String check = chessboard.findPreviousPosition(new ChessPiece(' ','W'), "e3") ;
		assertEquals(valid, check);
		valid = "e7" ;
		check = chessboard.findPreviousPosition(new ChessPiece(' ','B'), "e6") ;
		assertEquals(valid, check);
	}

	
}
