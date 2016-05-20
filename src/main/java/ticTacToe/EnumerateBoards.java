package ticTacToe;

import java.util.List;
import java.util.Stack;

import ticTacToe.Board.Piece;

public class EnumerateBoards {

	/**
	 * determine the number of possible boards and which piece wins more often,
	 * X or O. Find how many time each piece wins.
	 * */

	public static void main(String[] args) {
		Stack<Board> stack = new Stack<Board>();

		Board board;
		int numberBoards = 0;
		int ties = 0;
		int xWin = 0;
		int oWin = 0;

		Board emptyBoard = new Board();
		stack.push(emptyBoard);

		while (!stack.isEmpty()) {
			Board b = stack.pop();
			numberBoards++;

			Piece winner = b.getWinner();
			if (winner == Piece.X) {
				xWin++;
				continue;
			} else if (winner == Piece.O) {
				oWin++;
				continue;
			} else if (b.tie()) {
				ties++;
			}

			Board.Piece activePlayer = b.getActivePlayer();
			List<Integer> moves = b.getMoves();

			for (int move : moves) {
				Board child = new Board(b);
				child.set(move, activePlayer);
				stack.push(child);
			}
		}
		System.out.printf("numberBoards=%d, ties=%d x=%d, o=%d, tiesAndWins=%d", numberBoards, ties, xWin, oWin, ties
				+ xWin + oWin);
		// 46080 ties
		// 255168 leaves
		// numberBoards=549946
		// x=131184, o=77904
	}
}
