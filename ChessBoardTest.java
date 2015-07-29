import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ChessBoardTest {

	@Test
	public void testFindPreviousPosition() {
		String valid = "e2" ;
		ChessBoard chessboard=new ChessBoard() ;
		String check = chessboard.findPreviousPosition( new ChessMove( "e3" , 1) );
		assertEquals(valid, check);
		valid = "e7" ;
		check = chessboard.findPreviousPosition( new ChessMove("e6" , 2)) ;
		assertEquals(valid, check);
	}

	
}
