package day_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class First {
	public static void main(String[] args) throws IOException {
		File f = new File(First.class.getResource("input.txt").getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			boolean gotCraneSetup = false;
			ArrayList<String> craneSetup = new ArrayList<>();
			ArrayList<ArrayList<Character>> crane = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				if (gotCraneSetup && !line.isEmpty()) {
					crane = moveCrates(line, crane);
				} else {
					craneSetup.add(line);
					if (line.contains("1")) {
						crane = setupInitialCrates(craneSetup);
						gotCraneSetup = true;
					}
				}

			}
			StringBuilder bld = new StringBuilder();
			for (int i = 0; i < crane.size(); i++) {
				ArrayList<Character> stack = crane.get(i);
				bld.append(stack.get(stack.size() - 1));
			}
			System.out.println(bld.toString());
		}

	}

	private static ArrayList<ArrayList<Character>> setupInitialCrates(ArrayList<String> craneSetup) {
		Collections.reverse(craneSetup);
		ArrayList<ArrayList<Character>> crane = new ArrayList<>();
		for (String row : craneSetup) {
			int stackIndex = 0;
			while ((stackIndex * 4) + 1 < row.length()) {
				char crate = row.charAt((stackIndex * 4) + 1);
				if (crate != ' ') {
					mapCrateToStack(crane, crate, stackIndex);
				}
				stackIndex++;
			}
		}
		return crane;
	}

	private static void mapCrateToStack(ArrayList<ArrayList<Character>> crane, char crate, int stackIndex) {
		ArrayList<Character> stack;
		if (crane.size() - 1 < stackIndex) {
			stack = new ArrayList<>();
		} else {
			stack = crane.remove(stackIndex);
		}
		stack.add(crate);
		crane.add(stackIndex, stack);
	}

	private static ArrayList<ArrayList<Character>> moveCrates(String line, ArrayList<ArrayList<Character>> crane) {
		String stringValue = line.substring(line.lastIndexOf("move") + 4, line.lastIndexOf("from")).trim();
		int numberOfCrates = Integer.parseInt(stringValue);
		stringValue = line.substring(line.lastIndexOf("from") + 4, line.lastIndexOf("to")).trim();
		int fromIndex = Integer.parseInt(stringValue) - 1;
		stringValue = line.substring(line.lastIndexOf("to") + 2).trim();
		int toIndex = Integer.parseInt(stringValue) - 1;

		ArrayList<Character> from = crane.get(fromIndex);
		ArrayList<Character> to = crane.get(toIndex);

		for (int i = 0; i < numberOfCrates; i++) {
			char cargo = from.remove(from.size() - 1);
			to.add(cargo);
		}
		return crane;

	}

}
