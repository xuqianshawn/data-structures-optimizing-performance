package leetCode;

import java.util.HashMap;

public class NonRepeatingCharactor {
	public static char Find1NonRepeating(String input)
	{
	  HashMap<Character,Integer> temp=new HashMap<Character,Integer>();
	  char[] sequence=input.toCharArray();
	  for(int i=0;i<input.length();i++)
	  {
	   char c=input.substring(i,i+1).charAt(0);
	  if(!temp.containsKey(c))
	    {
	   temp.put(c,1);
	   }
	   else
	   {
	   temp.put(c,temp.get(c)+1);
	   }
	  }
	  for(int i=0;i<input.length();i++)
	  {
	    if(temp.get(sequence[i])==1){
		return sequence[i];
		}
	  }
	  return input.charAt(input.length()-1);
	}

	public static void main(String[] args) {
		System.out.println(Find1NonRepeating("GeeksforGeeks"));
	}
}