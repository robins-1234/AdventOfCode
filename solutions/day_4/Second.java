package day_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Second {
	public static void main(String[] args) throws IOException {
		File f = new File(First.class.getResource("input.txt").getFile());
		int result = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				int comma = line.indexOf(',');
				int[] first = getValues(line, 0, comma);
				int[] second = getValues(line, comma + 1, line.length());

				result += overlaps(first, second) ? 1 : 0;
			}
		}
		System.out.println(result);
	}

	private static int[] getValues(String line, int start, int end) {
		int[] values = new int[2];
		String half = line.substring(start, end);
		values[0] = Integer.valueOf(half.substring(0, half.indexOf('-')));
		values[1] = Integer.valueOf(half.substring(half.indexOf('-') + 1, half.length()));
		return values;
	}

	private static boolean overlaps(int[] first, int[] second) {
		int[] earlier;
		int[] later;

		if (first[1] <= second[1]) {
			later = second;
			earlier = first;
		} else {
			later = first;
			earlier = second;
		}

		return later[0] <= earlier[1];
	}

}
