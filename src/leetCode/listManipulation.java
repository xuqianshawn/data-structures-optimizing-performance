package leetCode;

import java.awt.List;

public class listManipulation {
    public static ListNode reverseLinkList(ListNode root)
    {
    	ListNode Previous=null;
    	ListNode Current=root;
    	ListNode Next=Current.next;
    	while(Current!=null)
    	{
    		Next=Current.next;    			
    		Current.next=Previous;
    		Previous=Current; 
    		Current=Next;
    		
    	}
    	return Previous;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		reverseLinkList(l1);
	}

}
