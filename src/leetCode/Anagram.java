package leetCode;

import java.util.*;

public class Anagram {
	// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
	public static HashMap<Character, Integer> constructHashMapByString(String input)
	{
		HashMap<Character, Integer> s1 = new HashMap<Character, Integer>();
		for (char c : input.toCharArray()) {
			if (!s1.containsKey(c)) {
				s1.put(c, 1);
			} else {
				s1.put(c, s1.get(c) + 1);
			}
		}
		return s1;
	}
	public static boolean checkAnagramFromStr(String input1, String input2) {
		if(input1.equals(input2))
		{
			return true;
		}
		if (input1.length() != input2.length()) {
			return false;
		}
		
		if (constructHashMapByString(input1).equals(constructHashMapByString(input2))) {
			return true;
		} else {
			return false;
		}
	}

	public static List<Integer> findIndexOfAnagramFromStr(String input, String pattern) {
		ArrayList<Integer> returnArr = new ArrayList<Integer>();
		int patternSize = pattern.length();
		// find them all
		for (int i = 0; i <= input.length() - patternSize; i++) {
			if (checkAnagramFromStr(input.substring(i, i + patternSize), pattern)) {
				// System.out.println(i);
				returnArr.add(i);
			}
		}

		return returnArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// set are equal not based on reference
		// TreeSet<Character> t1 = new TreeSet<Character>();
		// t1.add('a');
		// t1.add('b');
		// TreeSet<Character> t2 = new TreeSet<Character>();
		// t2.add('a');
		// t2.add('b');
		// t2.add('a');
		// System.out.println(t1.equals(t2));
		HashMap<Character, Integer> s1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> s2 = new HashMap<Character, Integer>();
		s1.put('a', 1);
		s2.put('a', 1);
		//System.out.println(s1.equals(s2));
		List<Integer> test = findIndexOfAnagramFromStr("ababababab", "aab");
		for (Integer i : test) {
			System.out.println(i);
		}
		System.out.println("===========");
		List<Integer> test2 = findIndexOfAnagramFromStr("abab", "ab");
		for (Integer i : test2) {
			System.out.println(i);
		}
	}

}
