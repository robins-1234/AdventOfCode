package day_1;

import java.io.IOException;
import java.util.ArrayList;

import common.Util;

public class First {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<String> input = Util.readFile("/AdventOfCode/solutions/day_1/input.txt");
		ArrayList<Integer> elves = getElves(input);
		elves.sort(null);
		System.out.println(elves.get(elves.size() - 1));
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
