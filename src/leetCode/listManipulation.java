package leetCode;


public class listManipulation {
    public static ListNode reverseLinkList(ListNode root)
    {
    	ListNode Previous=null;
    	ListNode Current=root;
    	ListNode Next=null;
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
		//pass by reference
		l1=reverseLinkList(l1);
	}

}
