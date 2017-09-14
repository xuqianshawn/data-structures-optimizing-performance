package leetCode;

import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class test {
	double getSquaredDistance(List<Integer> list) {
		double square = 0;
		for (Integer i : list) {
			square = square + i * i;
		}
		return square;
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<List<Integer>> closestLocations(int totalCrates, List<List<Integer>> allLocations, int truckCapacity) {
		// WRITE YOUR CODE HERE
		allLocations.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				// TODO return 1 if l2 should be before l1
				// return -1 if l1 should be before l2
				// return 0 otherwise
				if (getSquaredDistance(l1) < getSquaredDistance(l2)) {
					return -1;
				} else if (getSquaredDistance(l1) > getSquaredDistance(l2)) {

					return 1;

				} else {
					return 0;
				}
			}
		});
		// System.out.println(allocations);
		return allLocations;
	}

	public static class TextInput {
		static List<String> _list = new ArrayList();

		public static void add(char c) {

			_list.add(Character.toString(c));
		}

		public static String getValue() {
			return String.join("", _list);
		}
	}

	public static class NumericInput extends TextInput {
		public static void add(char c) {
			if (c >= 48 && c <= 57) {
				_list.add(Character.toString(c));
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("Deleveled"));

		TextInput input = new NumericInput();
		input.add('1');
		input.add('a');
		input.add('0');
		System.out.println(input.getValue());
	}

	public static boolean isPalindrome(String word) {
		char[] inputs = word.toLowerCase().toCharArray();
		for (int i = 0; i <= inputs.length / 2; i++) {
			if (inputs[i] != inputs[inputs.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}