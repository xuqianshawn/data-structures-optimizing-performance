package leetCode;

public class hummingDistance {
    //https://leetcode.com/problems/hamming-distance/description/
	private static String convertIntToBinary(int input)
	{
		
	  String strReturn="";
	  System.out.print(input);
	  while(input>0)
	  {
		  if(input%2>0)
		  {
			  strReturn="1"+strReturn;
		  }
		  else
		  {
			  strReturn="0"+strReturn;
		  }
		  input=input/2;
	  }
	  System.out.println(" "+strReturn);
	  return strReturn;
	}
	public static int getHummingDist(int input1, int input2)
	{
		String str1=convertIntToBinary(input1);//Integer.toBinaryString(input1); //system function
		String str2=convertIntToBinary(input2);  //my function to do the same thing
		//System.out.println(str1);
		if(str1.length()<str2.length())
		{			
			return getHummingDist(str1,str2);
		}
		else
		{
			return getHummingDist(str2,str1);
		}
	}
	public static int getHummingDist(String inputShorter, String inputLonger)
	{
		int counter=0;
		while(inputShorter.length()<inputLonger.length())
		{
			inputShorter="0"+inputShorter;
		}
		for(int i=0;i<inputShorter.length();i++)
		{
			if(!inputShorter.substring(i, i+1).equals(inputLonger.substring(i, i+1)))
			{
				counter++;			
			}
			
		}
		return counter;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getHummingDist(5, 2));

	}

}
