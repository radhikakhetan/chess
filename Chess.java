import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess {
	public static void main (String [] args) throws FileNotFoundException {
		ChessBoard chessboard = new ChessBoard() ;
		if (args.length == 0) {
			System.out.println("Usage java Chess <filename>");
			return;
		}
		Scanner reader = new Scanner(new File(args[0]));
		while ( reader.hasNextLine() ) {
			String[] round = reader.nextLine().trim().split(" ");
			chessboard.move(round[0], 1);
			chessboard.move(round[1], 2);
		}
		reader.close();
		chessboard.displayBoard();
	}

}
