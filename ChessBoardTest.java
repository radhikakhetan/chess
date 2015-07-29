import static org.junit.Assert.*;

import org.junit.Test;


public class ChessBoardTest {


	@Test
	public void testFindPiece() {
		ChessBoard chessboard=new ChessBoard() ;
		ChessPiece valid = new ChessPiece ( 'K' , 'W' ) ;
		ChessPiece check = chessboard.findPiece("Ke8",0) ;
		assertEquals(valid, check);
		valid = new ChessPiece ( ' ' , 'W' ) ;
		check = chessboard.findPiece("e8",0) ;
		assertEquals(valid, check);
		
		
	}

	/*@Test
	public void testFindPreviousPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}*/

}
