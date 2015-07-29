package chess;
class ChessPiece {
	
	char name;
	char color;
	
	public ChessPiece(char x, char y) {
		name = x;
		color = y;
	}

	public boolean isWhite() {
		return color == 'W';
	}
}