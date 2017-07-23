package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E>
 *            The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode(null);
		tail = new LLNode(null);
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element
	 *            The element to add
	 */
	public boolean add(E element) {
		if(element==null)
		{
			throw new NullPointerException(); 
		}
		// TODO: Implement this method
		LLNode temparyNode = new LLNode(element);
		if (size == 0) {
			head = temparyNode;
			tail = temparyNode;
		} else {
			tail.next = temparyNode;
			temparyNode.prev = tail;
			tail = temparyNode;
		}
		size++;
		return true;
	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E get(int index) {
		// TODO: Implement this method.
		if (index < 0 || (index > size - 1)) {
			throw new IndexOutOfBoundsException();
		}
		int tempIndex = 0;
		LLNode returnNode = head;
		while (tempIndex < index) {
			returnNode = returnNode.next;
			tempIndex++;
		}
		return (E) returnNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The
	 *            index where the element should be added
	 * @param element
	 *            The element to add
	 */
	public void add(int index, E element) {

		// assume index is the value where element will occupy
		if (index < 0 || (index > size)) {
			throw new IndexOutOfBoundsException();
		}
		if(element==null)
		{
			throw new NullPointerException(); 
		}
		LLNode e = new LLNode(element);
		// TODO: Implement this method
		LLNode tempRefPoint = head;
		for (int i = 1; i <= index - 1; i++) {
			// loop to find the point just before where New point should be
			tempRefPoint = tempRefPoint.next;
		}
		if (tempRefPoint.next == null) {
			// new point is at last
			tempRefPoint.next = e;
			e.prev=tempRefPoint;
		} else {
			//new point is between sth
			e.next = tempRefPoint.next;
			e.prev = tempRefPoint;
			if(tempRefPoint.next!=null)
			{
			tempRefPoint.next.prev = e;			
			}
			tempRefPoint.next=e;
		}
		
		if (index == size) {
			// add to tail
			tail = e;
		}
		if (index == 0) {
			head = e;
		}
		size++;
	}

	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index
	 *            The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException
	 *             If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {
		// TODO: Implement this method
		if (index < 0 || (index > size - 1)) {
			throw new IndexOutOfBoundsException();
		}
		LLNode tempRefPoint = head;
		for (int i = 1; i <= index; i++) {
			tempRefPoint = tempRefPoint.next;
		}
		if (tempRefPoint.prev != null) {
			// this point that needs to be removed is not head
			tempRefPoint.prev.next = tempRefPoint.next;
		} else {
			// head is removed
			head = tempRefPoint.next;
		}
		if (tempRefPoint.next != null) {
			// this point that needs to be removed is not tail
			tempRefPoint.next.prev = tempRefPoint.prev;
		} else {
			// remove tail
			tail = tempRefPoint.prev;
		}
		tempRefPoint.prev=null;
		tempRefPoint.next=null;
		size--;
		return (E) tempRefPoint.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index
	 *            The index of the element to change
	 * @param element
	 *            The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method
		//return the value that was replaced
		if (index < 0 || (index > size - 1)) {
			throw new IndexOutOfBoundsException();
		}
		if(element==null)
		{
			throw new NullPointerException(); 
		}

		LLNode tempRefPoint = head;
		for (int i = 1; i <= index; i++) {
			tempRefPoint = tempRefPoint.next;
		}
		E returnVal=(E) tempRefPoint.data;
		tempRefPoint.data = element;
		return returnVal;
	}
}

class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
