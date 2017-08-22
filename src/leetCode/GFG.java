package leetCode;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	// http://practice.geeksforgeeks.org/problems/first-non-repeating-Stringacter-in-a-stream/0
	public static void printNoRepeatingString(String[] inputs) {
		HashMap<String, Integer> seen = new HashMap<String, Integer>();
		List<String> sequence = new LinkedList<String>();
		for (String i : inputs) {
			if (!seen.containsKey(i)) {
				seen.put(i, 1);
				sequence.add(i);
				System.out.print(sequence.get(0) + " ");
			} else {
				seen.put(i, seen.get(i) + 1);
				if (sequence.contains(i)) {
					sequence.remove((Object) i);
				}
				if (!sequence.isEmpty()) {
					System.out.print(sequence.get(0) + " ");
				} else {
					System.out.print(-1 + " ");
				}
			}

		}
		System.out.print('\n');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numberOfTests = Integer.parseInt(sc.nextLine());
		List<String[]> inputs = new ArrayList<String[]>();
		for (int i = 0; i < numberOfTests; i++) {
			int numberOfStrings = Integer.parseInt(sc.nextLine());
			String[] arrayString = sc.nextLine().split(" ");
			inputs.add(arrayString);
		}
		for (String[] arrayString : inputs) {
			printNoRepeatingString(arrayString);
		}
	}

}
