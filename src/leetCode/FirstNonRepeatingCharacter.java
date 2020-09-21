package leetCode;

import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstNonRepeatingCharacter {
	// https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
	public char printNoRepeatingString(String s) {
		char[] inputs = s.toCharArray();
		HashSet<Character> seen = new HashSet<Character>();
		List<Character> sequence = new LinkedList<Character>();
		for (char i : inputs) {
			if (!seen.contains(i)) {
				seen.add(i);
				sequence.add(i);
			} else {
				// Saw this char before
				if (sequence.contains(i)) {
					sequence.remove((Object)i);
				}
			}

		}
		if (sequence.size() > 0) {
			return sequence.get(0);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("please provide the character string followed by Enter");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		FirstNonRepeatingCharacter target = new FirstNonRepeatingCharacter();
		System.out.print(target.printNoRepeatingString(str));

	}

}
