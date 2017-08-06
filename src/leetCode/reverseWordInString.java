package leetCode;

import java.util.Scanner;

public class reverseWordInString {
	// http://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
	public static String reverseWord(String input) {
		String[] words = input.split("\\.");
		String returnStr = "";
		if(words.length==0)
		{
			return returnStr;
		}
		
		for (int i = words.length - 1; i >= 0; i--) {
			returnStr = returnStr+words[i] + ".";
		}
		return returnStr.substring(0, returnStr.length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int inputNum = Integer.parseInt(scanner.nextLine());
		String[] inputs = new String[inputNum];
		for (int i = 0; i < inputNum; i++) {
			inputs[i] = scanner.nextLine();
		}
		for (int i = 0; i < inputNum; i++) {
			System.out.println(reverseWord(inputs[i]));
		}
	}

}
