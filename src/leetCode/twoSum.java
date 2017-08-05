package leetCode;

import java.util.HashMap;

import javax.net.ssl.HandshakeCompletedEvent;

public class twoSum {
    public static int[] checkTwoSumOfTarget(int[] input, int target)
    {
    	int[] arrReturn=new int [2];
    	HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>(); //<value, index>
    	for(int i=0;i<input.length;i++)
    	{
    		hashMap.put(input[i],i);	    		
    	}
    	for(int j=0;j<input.length;j++)
    	{
    		int anothervalue=target-input[j];
    		if(hashMap.containsKey(anothervalue)&& hashMap.get(anothervalue)!=j)
    		{
    			
    			arrReturn[0]=hashMap.get(anothervalue);
    			arrReturn[1]=j;
    		}
    		
    	}
    	
    	return arrReturn;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={1,2,3,4,5};
        int[] check=checkTwoSumOfTarget(input, 8);
        System.out.println(check[0]+" "+check[1]);
	}

}
