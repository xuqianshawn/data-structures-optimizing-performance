package leetCode;

import java.util.LinkedList;

public class MergeTwoSortedList {
    public static LinkedList<Integer> sortLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2)
    {
    	if(l1==null||l1.size()==0)
    	{
    		return l2;
    	}
    	if(l2==null||l2.size()==0)
    	{
    		return l1;
    	}
    	LinkedList<Integer> List=new LinkedList<Integer>();
    	while(l1.size()>0&&l2.size()>0)
    	{
    		if(l1.peek()>l2.peek())
    		{
    			List.add(l2.pop());
    		}
    		else
    		{
    			List.add(l1.pop());
    		}
    	}
    	if(l2.size()>0)
    	{
    		List.addAll(l2);
    	}
    	if(l1.size()>0)
    	{
    		List.addAll(l1);
    	}
    	return List;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(5);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(2);
		l2.add(6);
		l2.add(7);
		LinkedList<Integer> l3=sortLinkedList(l1, l2);
		System.out.println(l3);
	}

}
