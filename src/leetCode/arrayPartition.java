package leetCode;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class arrayPartition {
    //https://leetcode.com/problems/array-partition-i/description/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputs={1,2,3,4};
      System.out.println(arrayPartition(inputs));
	}
    public static int arrayPartition(int[] nums)
    {
    	Arrays.sort(nums);
    	//equivalent to get sort the array and get 2n (n=0,1,2,3)...position of the array
    	int n=0;
        int sum=0;
    	while(2*n<nums.length)
    	{
    		sum=sum+nums[2*n];
    		n++;
    	}
    	return sum;
    }
}
