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

	final int[][] pawnMoves = {{0, 1}, {0, -1}};
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
				return findMovesForPiece(from.charAt(0), Character.getNumericValue(from.charAt(1)), kingMoves);
			case 'Q':
				return findMovesForQueen(from.charAt(0), Character.getNumericValue(from.charAt(1)));
			case 'R':
				return findMovesForPiece(from.charAt(0), Character.getNumericValue(from.charAt(1)), rookMoves);
			case 'N':
				return findMovesForPiece(from.charAt(0), Character.getNumericValue(from.charAt(1)), knightMoves);
			case 'B':
				return findMovesForPiece(from.charAt(0), Character.getNumericValue(from.charAt(1)), bishopMoves);
			case ' ':
				return findMovesForPiece(from.charAt(0), Character.getNumericValue(from.charAt(1)), pawnMoves);
			default:
				return new ArrayList<String>();
		}	
	}

	private List<String> findMovesForPiece(char file, int rank, int[][] pieceMoves) {
		List<String> possibleMoves = new ArrayList<String>();
		for ( int[] row : pieceMoves) {
			char newFile = (char) (file + row[0]);
			int newRank = rank + row[1];
			if ( insideBoard(newFile, newRank) ) {
				possibleMoves.add(newFile + "" + newRank);
			}
		}
		return possibleMoves;
	}

	private List<String> findMovesForQueen(char file, int rank) {
		List<String> possibleMoves = findMovesForPiece(file, rank, rookMoves);
		possibleMoves.addAll(findMovesForPiece(file, rank, bishopMoves));
		return possibleMoves;
	}

	private boolean insideBoard(char file, int rank){
		return ('a' <= file && file <= 'h') && (1 <= rank && rank <= 8);
	}
	
	@Override
	public boolean equals(Object o) {
		if ( this == o )
			return true;
		
		if ( !(o instanceof ChessPiece) )
			return false;
		
		ChessPiece c = (ChessPiece) o;
		return this.name == c.name && this.color == c.color;
	}
}