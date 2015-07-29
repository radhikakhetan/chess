import java.util.ArrayList;
import java.util.List;

class ChessPiece {
	
	final int[][] kingMoves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	final int[][] knightMoves = {{2, 1}, {1, 2}, {1, -2}, {2, -1}, 
									{-2, -1}, {-1, -2}, {-1, 2}, {-2, 1}};
	final int[][] rookMoves = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, 
								{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0},
								{0, -1}, {0, -2}, {0, -3}, {0, -4}, {0, -5}, {0, -6}, {0, -7}, 
								{-1, 0}, {-2, 0}, {-3, 0}, {-4, 0}, {-5, 0}, {-6, 0}, {-7, 0}};

	final int[][] bishopMoves = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7},
								  {-1, -1}, {-2, -2}, {-3, -3}, {-4, -4}, {-5, -5}, {-6, -6}, {-7, -7},
								  {1, -1}, {2, -2}, {3, -3}, {4, -4}, {5, -5}, {6, -6}, {7, -7},
								  {-1, 1}, {-2, 2}, {-3, 3}, {-4, 4}, {-5, 5}, {-6, 6}, {-7, 7}};
	char name;
	char color;
	
	public ChessPiece(char x, char y) {
		name = x;
		color = y;
	}

	public ChessPiece() {
		name = '*';
		color = 'E';
	}

	public boolean isWhite() {
		return color == 'W';
	}

	public List<String> findAllValidMoves(String from) {
		switch ( this.name ) {
			case 'K':
				return findAllValidKingMoves(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			case 'Q':
				return findAllValidQueenMoves(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			case 'R':
				return findAllValidRookMoves(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			case 'N':
				return findAllValidKnightMoves(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			case 'B':
				return findAllValidBishopMoves(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			case ' ':
				return findAllValidPawnMoves(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			default:
				return new ArrayList<String>();
		}	
	}

	private List<String> findAllValidKingMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<String>();
		
		return possibleMoves;
	}

	private List<String> findAllValidQueenMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<String>();
		return possibleMoves;
	}

	private List<String> findAllValidRookMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<String>();
		return possibleMoves;	
	}

	private List<String> findAllValidKnightMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<String>();
		for ( int[] row : knightMoves) {
			String next = Character.toString((char)(file + row[0])) + Integer.toString(rank + row[1]);
			possibleMoves.add(next);
		}
		return possibleMoves;
	}

	private List<String> findAllValidBishopMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<String>();
		return possibleMoves;
	}

	private List<String> findAllValidPawnMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<String>();
		return possibleMoves;
	}
	private boolean insideBoard(char file, int rank){
		return ('a' <= file && file <= 'h') && (1 <= rank && rank <= 8);
	}
}