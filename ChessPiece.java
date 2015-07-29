class ChessPiece {
	
	final int[][2] king = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
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
				return findAllValidKingMoves(from.charAt(0), Integer.parseInt(1));
			case 'Q':
				return findAllValidQueenMoves(from.charAt(0), Integer.parseInt(1));
			case 'R':
				return findAllValidRookMoves(from.charAt(0), Integer.parseInt(1));
			case 'N':
				return findAllValidKnightMoves(from.charAt(0), Integer.parseInt(1));
			case 'B':
				return findAllValidBishopMoves(from.charAt(0), Integer.parseInt(1));
			case '':
				return findAllValidPawnMoves(from.charAt(0), Integer.parseInt(1));
			default:
				return new ArrayList<String>();
		}	
	}

	private List<String> findAllValidKingMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<>();
		return possibleMoves;
	}

	private List<String> findAllValidQueenMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<>();
		return possibleMoves;
	}

	private List<String> findAllValidRookMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<>();
		return possibleMoves;	
	}

	private List<String> findAllValidKnightMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<>();
		return possibleMoves;
	}

	private List<String> findAllValidBishopMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<>();
		return possibleMoves;
	}

	private List<String> findAllValidPawnMoves(char file, int rank) {
		List<String> possibleMoves = new ArrayList<>();
		return possibleMoves;
	}
}