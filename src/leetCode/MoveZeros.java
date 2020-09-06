package leetCode;

import java.util.Arrays;

public class MoveZeros {
	// https://leetcode.com/problems/move-zeroes/
	public void moveZeroes(int[] nums) {
		int zeroCount = 0;
		int currentCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				// increase 0 count
				zeroCount++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				// increase 0 count
				currentCount++;
			} else {
				nums[i - currentCount] = nums[i];
			}
			// set the rest elements as 0
			if(i >= nums.length - zeroCount){
				nums[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] input = { 0, 1, 0, 3, 12 };
		// Act
		MoveZeros target = new MoveZeros();
		target.moveZeroes(input);
		System.out.println(Arrays.toString(input));
		
	    int[] input2 = { 0, 1, 0};
		// Act
	    target = new MoveZeros();
		target.moveZeroes(input2);
		System.out.println(Arrays.toString(input2));
	}

}
