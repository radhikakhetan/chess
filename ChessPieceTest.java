import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class ChessPieceTest {
	
	@Test
	public void testFindAllPossibleMoves() {
		ChessPiece piece = new ChessPiece('N', 'W');
		List<String> valid = new ArrayList<>();
		valid.add("f6");
		valid.add("g5");
		valid.add("g3");
		valid.add("f2");
		valid.add("d2");
		valid.add("c3");
		valid.add("c5");
		valid.add("d6");
		List<String> check = piece.findAllValidMoves("e4", false);
		assertTrue(valid.containsAll(check) && check.containsAll(valid));
	}
	
	@Test
	public void testFindAllPossibleMovesBoundary() {
		ChessPiece piece = new ChessPiece('B', 'W');
		List<String> valid = new ArrayList<>();
		valid.add("a1");
		valid.add("a3");
		valid.add("c1");
		valid.add("c3");
		valid.add("d4");
		valid.add("e5");
		valid.add("f6");
		valid.add("g7");
		valid.add("h8");
		List<String> check = piece.findAllValidMoves("b2", false);
		assertTrue(valid.containsAll(check) && check.containsAll(valid));
	}
	
	@Test
	public void testFindAllPossibleMovesBlack() {
		ChessPiece piece = new ChessPiece('B', 'B');
		List<String> valid = new ArrayList<>();
		valid.add("a1");
		valid.add("f8");
		valid.add("h6");
		valid.add("c3");
		valid.add("d4");
		valid.add("e5");
		valid.add("f6");
		valid.add("b2");
		valid.add("h8");
		List<String> check = piece.findAllValidMoves("g7", false);
		assertTrue(valid.containsAll(check) && check.containsAll(valid));
	}
	
	@Test
	public void testFindAllPossibleMovesPawnCapture() {
		ChessPiece piece = new ChessPiece(' ', 'B');
		List<String> valid = new ArrayList<>();
		valid.add("f5");
		valid.add("d5");
		List<String> check = piece.findAllValidMoves("e6", true);
		assertTrue(valid.containsAll(check) && check.containsAll(valid));
	}
}