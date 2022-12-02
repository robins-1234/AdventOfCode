package day_2;

import java.io.IOException;
import java.util.ArrayList;

import common.Util;

public class Second {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<String> input = Util.readFile("/AdventOfCode/solutions/day_2/input.txt");
		int opp;
		int reac;
		int outcome;
		int sum = 0;

		for (String match : input) {
			opp = getCharValue(match.charAt(0));
			outcome = getCharValue(match.charAt(2));
			reac = getReaction(opp, outcome);
			sum += reac;
			sum += outcome;
		}
		System.out.println(sum);
	}

	private static int getCharValue(char reac) {
		switch (reac) {
		case 'A':
			return 1;
		case 'B':
			return 2;
		case 'C', 'Y':
			return 3;

		case 'X':
			return 0;
		case 'Z':
			return 6;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static int getReaction(int opp, int outcome) {
		if (outcome == 3)
			return opp;

		if (outcome == 6)
			return getNext(opp);

		return getLast(opp);
	}

	private static int getLast(int opp) {
		if (opp == 1)
			return 3;
		return opp - 1;
	}

	private static int getNext(int opp) {
		if (opp == 3)
			return 1;
		return opp + 1;
	}

}