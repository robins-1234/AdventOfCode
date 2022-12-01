package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

	public static ArrayList<String> readFile(String input) throws IOException {
		input = trimName(input);
		File f = new File(Util.class.getResource(input).getFile());

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			ArrayList<String> list = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			return list;
		}
	}

	private static String trimName(String input) {
		String thisName = "/AdventOfCode/solutions/common/Util.java";
		StringBuilder common = new StringBuilder();
		for (int i = 0; i < thisName.length(); i++) {
			if (thisName.charAt(i) == input.charAt(i)) {
				common.append(thisName.charAt(i));
			} else {
				break;
			}
		}
		input = "/" + input.substring(common.length());
		return input;
	}

}
