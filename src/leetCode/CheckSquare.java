package leetCode;

public class CheckSquare {
//    public static boolean checkIfNumberIsSquare(long input)
//    {
//    	long start=0;
//    	long end=Integer.MAX_VALUE;
//    	for(long i=1;i<input/2;i++)
//    	{
//    		if(i*i==input)
//    		{
//    			
//    			return true;
//    		}
//    		else if(i*i>input)
//    		{
//    			return false;
//    		}
//    	}
//    	return false;
//    }
	private static long LoopCounter=0;
	public static boolean checkIfNumberIsSquare(long input)
	{
		long start=1;
    	long end=input/2;
		return checkIfNumberIsSquare(input, start, end);
	}
    public static boolean checkIfNumberIsSquare(long input, long lowerBound,long upperBound)
    {
    	LoopCounter++;
    	if(lowerBound*lowerBound>input || LoopCounter>1000|| lowerBound==upperBound)
    	{
    		return false;
    	}
    	else if(lowerBound*lowerBound==input || upperBound*upperBound==input)
    	{
    		return true;
    	}
    	if((upperBound*upperBound)>input)
    	{
    	long midpoint=(lowerBound+upperBound)/2;
    	 System.out.println("lower "+lowerBound+" upper "+midpoint);
    	return checkIfNumberIsSquare(input, lowerBound,midpoint);
    	}
    	if((upperBound*upperBound)<input)
    	{
    	long endpoint=lowerBound+upperBound;
    	 System.out.println("lower "+upperBound+" upper "+endpoint);
    	return checkIfNumberIsSquare(input,upperBound,endpoint);
    	}
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
     System.out.println(checkIfNumberIsSquare(10000));
     System.out.println(LoopCounter);
	}

}
