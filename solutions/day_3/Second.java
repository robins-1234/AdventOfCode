package day_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Second {
	public static void main(String[] args) throws IOException {
		File f = new File(Second.class.getResource("input.txt").getFile());
		int prioritySum = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String first;
			String second;
			String third;
			while ((first = br.readLine()) != null) {
				second = br.readLine();
				third = br.readLine();
				prioritySum += mapPriority(seachCommonChar(first, second, third));
			}
		}
		System.out.println(prioritySum);
	}

	private static char seachCommonChar(String first, String second, String third) {
		for (int i = 0; i < first.length(); i++) {
			String check = "" + first.charAt(i);
			if (second.contains(check) && third.contains(check)) {
				return first.charAt(i);
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
