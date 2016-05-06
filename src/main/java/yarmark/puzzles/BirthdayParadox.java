package yarmark.puzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class BirthdayParadox {

	public static void main(String[] args) {

		ArrayList<Integer> people = new ArrayList<Integer>();
		Random rand = new Random();
		HashSet<Integer> ppl = new HashSet<Integer>();

		int win = 0;
		int lose = 0;
		people.add(rand.nextInt(365));
		// adds a person
		for (int i = 1; i <= 75; i++) {
			ppl = new HashSet<Integer>();
			people.add(rand.nextInt(365));

			// go through the simulation 100 times for each number of people
			for (int simulation = 0; simulation < 100; simulation++) {
				ppl = new HashSet<Integer>();
			
				// reset bdays
				for (int j = 0; j < people.size(); j++) {
					people.set(j, rand.nextInt(365));
					ppl.add(people.get(j));
				}

				if (ppl.size() == people.size()) {
					lose++;
				} else {
					win++;
				}
			}
			System.out.println("People: " + i + " Win " + win + " Loss " + lose);
			win = lose = 0;
		}

	}

}
