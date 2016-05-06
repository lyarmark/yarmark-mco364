package yarmark.puzzles;

import java.util.Random;

public class MonteyHall {
	public static void main(String[] args) {
		Random random = new Random();

		int win = 0, lose = 0;

		for (int i = 0; i < 100; i++) {
			int[] doors = new int[] { 0, 0, 0 };
			int carIndex = random.nextInt(3);
			doors[carIndex] = 1;

			int choiceIndex = random.nextInt(3);
			if (doors[choiceIndex] == doors[carIndex]) {
				lose++;
			} else {
				win++;
			}
		}
		System.out.println("win: " + win + "\tlose: " + lose);
	}
}