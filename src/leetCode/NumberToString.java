package leetCode;

public class NumberToString {
	public static String[] digit= {"", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	 public static final String[] tens = {
	            "",        // 0
	            "",        // 1
	            "twenty",  // 2
	            "thirty",  // 3
	            "forty",   // 4
	            "fifty",   // 5
	            "sixty",   // 6
	            "seventy", // 7
	            "eighty",  // 8
	            "ninety"   // 9
	    };
//    public static String convertNumToStr(Integer num)
//	{
//		String numStr="";
//		
//		return numStr;
//	}
	 public static String convertNumToStrOverall(Integer num)
		{
			if(num==0)
			{
				return "zero";
			}
			else
			{
				return convertNumToStr(num);
			}
		}
	public static String convertNumToStr(Integer num)
	{
		if(num<0)
		{
			return "minus "+convertNumToStr(-num);
		}
	
		if(num<20)
		{
			return digit[num];
		}
		if(num<100)
		{
			int temp=num/10;
			return tens[temp]+" "+convertNumToStr(num-temp*10);
		}
		if(num<1000)
		{
			int temp=num/100;
			return convertNumToStr(temp)+" hundred "+convertNumToStr(num-temp*100);
		}
		if(num<1000000)
		{
			int temp=num/1000;
			return convertNumToStr(temp)+" thousand "+convertNumToStr(num-temp*1000);
		}
		if(num<1000000000)
		{
			int temp=num/1000000;
			return convertNumToStr(temp)+" million "+convertNumToStr(num-temp*1000000);
		}
		return "";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(convertNumToStrOverall(0));
      System.out.println(convertNumToStrOverall(123));
      System.out.println(convertNumToStrOverall(12));
      System.out.println(convertNumToStrOverall(97));
      System.out.println(convertNumToStrOverall(111197));
	}

}
