package day_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class First {
	public static void main(String[] args) throws IOException {
		File f = new File(First.class.getResource("input.txt").getFile());
		int prioritySum = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				prioritySum += useLine(line);
			}
		}
		System.out.println(prioritySum);
	}

	private static int useLine(String line) {
		String firstHalf = line.substring(0, line.length() / 2);
		String secondHalf = line.substring(line.length() / 2, line.length());
		return mapPriority(seachCommonChar(firstHalf, secondHalf));
	}

	private static char seachCommonChar(String firstHalf, String secondHalf) {

		for (int i = 0; i < firstHalf.length(); i++) {
			if (secondHalf.contains("" + firstHalf.charAt(i))) {
				return firstHalf.charAt(i);
			}
		}
		throw new IllegalArgumentException();
	}

	private static int mapPriority(char common) {
		if (Character.isUpperCase(common)) {
			return common - 38;
		} else {
			return common - 96;
		}
	}
}
