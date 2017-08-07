package leetCode;


import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.LinkedList;

public class MergeLinkedList {
	private static void populateSetByList(ListNode l1, TreeSet<Integer>set)
	{
		ListNode temp1=l1;
		while(temp1!=null)
		{
			set.add(temp1.val);
			temp1=temp1.next;
		}
	}
	public static ListNode MergeLinkedList(ListNode l1,ListNode l2)
	{
		if(l1==null)
		{
		return l2;
		}
		if(l2==null)
		{
		return l1;
		}
		TreeSet<Integer> set=new TreeSet<Integer>(Collections.reverseOrder());
		
		populateSetByList(l1,set);
		populateSetByList(l2,set);
		
		ListNode prev=null;
		for(int i:set)
		{
			ListNode temp=new ListNode(i);
		    temp.next=prev;
		    prev=temp;
		}
		return prev;
	}
	public static void MergeLinkedList(LinkedList l1,LinkedList l2)
	{
	 for(Object e:l1)
	 {
		if(!l2.contains(e)) 
		{
			l2.add(e);
		}
	 }
	 Collections.sort(l2);
	 //sort using Comparator equivalent to Collections.sort
//	 l2.sort(new Comparator<Integer>(){
//		@Override
//		public int compare(Integer n1, Integer n2) {
//		     //TODO return 1 if rhs should be before lhs 
//		     //     return -1 if lhs should be before rhs
//		     //     return 0 otherwise
//			 if(n1<n2)
//			 {
//				 return -1;
//			 }
//			 else if(n1>n2){
//				
//					 return 1;
//				 
//			 }
//			 else {
//				return 0;
//			}
//		}
//	 });
	 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList<Integer> l1 = new LinkedList<Integer>();
//		l1.add(1);
//		l1.add(2);
//		l1.add(3);
//		LinkedList<Integer> l2 = new LinkedList<Integer>();
//		l2.add(5);
//		l2.add(3);
//		l2.add(4);
//		MergeLinkedList(l1, l2);
//		System.out.println(l2);
		
		ListNode l1=new ListNode(1);
		ListNode l12=new ListNode(2);
		ListNode l13=new ListNode(3);
		l1.next=l12;
		l12.next=l13;
		
		
		
		ListNode l2=new ListNode(3);
		ListNode l22=new ListNode(3);
		ListNode l23=new ListNode(5);
		l2.next=l22;
		l22.next=l23;
		
		
		ListNode l3=MergeLinkedList(l1,l2);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
	}

}
