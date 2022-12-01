package day_1;

import java.io.IOException;
import java.util.ArrayList;

import common.Util;

public class Second {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<String> input = Util.readFile("/AdventOfCode/solutions/day_1/input.txt");
		ArrayList<Integer> elves = getElves(input);
		elves.sort(null);
		int result = 0;
		for (int i = 1; i < 4; i++) {
			result += elves.get(elves.size() - i);
		}
		System.out.println(result);
	}

	private static ArrayList<Integer> getElves(ArrayList<String> input) {
		ArrayList<Integer> elves = new ArrayList<>();
		int elfCarry = 0;
		for (String string : input) {
			if (string.isBlank()) {
				elves.add(elfCarry);
				elfCarry = 0;
			} else {
				elfCarry += Integer.parseInt(string);
			}
		}
		return elves;
	}

}