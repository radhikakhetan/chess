package chess;
import static org.junit.Assert.*;

import org.junit.Test;

public class ChessMoveTest {

	ChessMove m;
	public void testIsCapturing() {
		m = new ChessMove("e3",1);
		assertEquals(m.isCapturing(), false);
		
		m = new ChessMove("Nxh4",1);
		assertEquals(m.isCapturing(), true);
		
		m = new ChessMove("xe7",1);
		assertEquals(m.isCapturing(), true);
	}

	@Test
	public void testIsAmbiguous() {
		m = new ChessMove("e3",1);
		assertEquals(m.isAmbiguous(), false);
		
		m = new ChessMove("Nfh4",1);
		assertEquals(m.isAmbiguous(), true);
		
		m = new ChessMove("xe7",1);
		assertEquals(m.isAmbiguous(), false);
	}

	@Test
	public void testGetAmbiguousPosition() {
		m = new ChessMove("hg7",1);
		assertEquals(m.getAmbiguousPosition(), 'h');
		
		m = new ChessMove("Nfh4",1);
		assertEquals(m.getAmbiguousPosition(), 'f');
		
		m = new ChessMove("xe7",1);
		assertEquals(m.getAmbiguousPosition(), ' ');
	}

	@Test
	public void testIsCastling() {
		m = new ChessMove("e3",1);
		assertEquals(m.isCastling(), false);
		
		m = new ChessMove("O-O",1);
		assertEquals(m.isCastling(), true);
		
		m = new ChessMove("O-O-O",1);
		assertEquals(m.isCastling(), true);
	}	

	@Test
	public void testIsKingCastling() {
		m = new ChessMove("e3",1);
		assertEquals(m.isKingCastling(), false);
		
		m = new ChessMove("O-O",1);
		assertEquals(m.isKingCastling(), true);
		
		m = new ChessMove("O-O-O",1);
		assertEquals(m.isKingCastling(), false);
	}

	@Test
	public void testIsQueenCastling() {
		m = new ChessMove("e3",1);
		assertEquals(m.isQueenCastling(), false);
		
		m = new ChessMove("O-O",1);
		assertEquals(m.isQueenCastling(), false);
		
		m = new ChessMove("O-O-O",1);
		assertEquals(m.isQueenCastling(), true);
	}
	
	@Test
	public void testIsEnpassant() {
		m = new ChessMove("e3",1);
		assertEquals(m.isEnpassant(), false);
		
		m = new ChessMove("Nd8e.p.",1);
		assertEquals(m.isEnpassant(), true);
		
		m = new ChessMove("O-O-O",1);
		assertEquals(m.isEnpassant(), false);
	}
	
	@Test
	public void testGetMove() {
		m = new ChessMove("e3",1);
		assertEquals(m.getMove(), "e3");
		
		m = new ChessMove("O-O",1);
		assertEquals(m.getMove(), " -1");
		
		m = new ChessMove("Nxe6",1);
		assertEquals(m.getMove(), "e6");
		
		m = new ChessMove("Ne6",1);
		assertEquals(m.getMove(), "e6");
		
		m = new ChessMove("Nhe6",1);
		assertEquals(m.getMove(), "e6");
	}

}