package leetCode;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	// http://practice.geeksforgeeks.org/problems/first-non-repeating-Stringacter-in-a-stream/0
	public static void printNoRepeatingString(Character[] inputs) {
		HashMap<Character, Integer> seen = new HashMap<Character, Integer>();
		List<Character> sequence = new LinkedList<Character>();
		for (char i : inputs) {
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
		List<Character[]> inputs = new ArrayList<Character[]>();
		for (int i = 0; i < numberOfTests; i++) {
			int numberOfStrings = Integer.parseInt(sc.nextLine());
			String[] arrayString = sc.nextLine().split(" ");
			Character[] arrayChar=new Character[arrayString.length];
			int j=0;
			for(String s:arrayString)
			{
				arrayChar[j]=s.charAt(0);
				j++;
			}
			inputs.add(arrayChar);
		}
		for (Character[] arrayString : inputs) {
			printNoRepeatingString(arrayString);
		}
	}

}
