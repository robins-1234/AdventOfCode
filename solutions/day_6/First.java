package day_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class First {

	public static void main(String[] args) throws IOException {

		File f = new File(First.class.getResource("input.txt").getFile());

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			ArrayList<Character> list = new ArrayList<>();
			int count = 0;
			char nextChar;
			while ((nextChar = (char) br.read()) != -1) {
				count++;
				if (list.size() > 3)
					list.remove(0);
				list.add(nextChar);
				if (noDuplicates(list) && list.size() == 4) {
					break;
				}
			}
			System.out.println(count);
		}
	}

	private static boolean noDuplicates(ArrayList<Character> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.subList(i + 1, list.size()).contains(list.get(i))) {
				return false;
			}
		}
		return true;
	}
}
