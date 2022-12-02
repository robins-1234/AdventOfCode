package day_2;

import java.io.IOException;
import java.util.ArrayList;

import common.Util;

public class First {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<String> input = Util.readFile("/AdventOfCode/solutions/day_2/input.txt");
		int opp;
		int reac;
		int sum = 0;

		for (String match : input) {
			opp = getCharValue(match.charAt(0));
			reac = getCharValue(match.charAt(2));
			sum += reac;
			sum += getMatchValue(opp, reac);
		}
		System.out.println(sum);
	}

	private static int getCharValue(char reac) {
		switch (reac) {
		case 'X', 'A':
			return 1;
		case 'Y', 'B':
			return 2;
		case 'Z', 'C':
			return 3;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static int getMatchValue(int opp, int player) {
		if (opp == player)
			return 3;

		if (getNext(opp) == player)
			return 6;

		return 0;
	}

	private static int getNext(int opp) {
		if (opp == 3)
			return 1;

		return opp + 1;
	}

}
