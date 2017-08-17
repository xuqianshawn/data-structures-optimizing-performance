package leetCode;

import java.util.Stack;

import org.reactfx.value.Var;

public class ImplementQueueUsingStack<E> {
    private Stack<E> _stack=new Stack<E>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementQueueUsingStack<Integer> queue= new ImplementQueueUsingStack<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

	
	public boolean offer(E e) {
		// TODO Auto-generated method stub.
		_stack.add(e);
		return true;
	}
	public E poll() {
		// TODO Auto-generated method stub
		Stack<E> temp=new Stack<E>();
		while(!_stack.isEmpty())
		{
			temp.push(_stack.pop());		
		}
		E returnVal=temp.pop();
		while(!temp.isEmpty())
		{
			_stack.push(temp.pop());		
		}
		return returnVal;
	}

	

}
