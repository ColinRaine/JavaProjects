package linkedList.ColinMartinez;

public class LinkedList0<E>
{
	/**
	 * The Node class represents a list node.
	 */
	
	private class Node
	{
		E value;
		Node next;
		
		/**
		 * Constructor
		 * @param val The element to store in this node.
		 * @param n The reference to the next node.
		 */
		
		Node(E val, Node n)
		{
			value = val;	//List head
			next = n;		//Last element in list
		}
		
		/**
		 * Constructor
		 * @param val The element to store in this node.
		 */
		
		Node(E val)
		{
			value = val;
			next = null;
		}		
	}
	
	//Reference to the first and last node in the list.
	private Node first;
	private Node last;
	
	/**
	 * Constructor		
	 */
	
	public LinkedList0()
	{
		first = null;
		last = null;
	}
	
	/**
	 * The isEmpty method checks to see
	 * is the list is empty.
	 * @return true if list is empty,
	 * false otherwise.
	 */
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	/**
	 * The size method returns the length of the list.
	 * @return the number of elements in the list.
	 */
	
	public int size()
	{
		int count = 0;
		Node p = first;
		
		while (p != null)
		{
			//There is an element at p.
			count++;
			p = p.next;
		}
		return count;
	}
	
	/**
	 * The add method adds an element to
	 * the end of the list.
	 * @param e The value to add to the end of the list.
	 */
	
	public void add(E e)
	{
		if (isEmpty())
		{
			first = new Node(e);
			last = first;
		}
		else
		{
			//Add to end of existing list
			last.next = new Node(e);
			last = last.next;
		}
	}
	
	/**
	 * the add method adds an element at a position.
	 * @param index The position at which to add the element.
	 * @param e The element to add to the list.
	 * @exception IndexOutOfBoundsException When
	 * index is out of bounds.
	 */
	
	public void add(int index, E e)
	{
		if (index < 0 || index > size())
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		
		//Index is at least 0
		if (index == 0)
		{
			//New element goes at beginning
			first = new Node(e, first);
			if (last == null)
				last = first;
			return;
		}
		
		//Set a reference pred to point to the node that
		//will be the predecessor of the new node
		Node pred = first;
		for (int k = 1; k <= index - 1; k++)
		{
			pred = pred.next;
		}
		
		//Splice in a node containing the new element
		pred.next = new Node(e, pred.next);
		
		//Is there a new last element?
		if (pred.next.next == null)
			last = pred.next;
	}
	
	/**
	 * The remove method removes an element at an index.
	 * @param index The index of the element to remove.
	 * @return The element removed.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */
	
	public E remove(int index)
	{
		if (index < 0 || index >= size())
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		
		E element; //The element to return
		if (index == 0 )
		{
			//Removal of the first item in list
			element = first.value;
			first = first.next;
			if (first == null)
				last = null;
		}
		else
		{
			//To remove an element other than the first,
			//find the predecessor of the element to be removed.
			Node pred = first;
			
			//Move pred forward index - 1 times
			for (int k = 1; k <= index - 1; k++)
				pred = pred.next;
			
			//Store the value to return
			element = pred.next.value;
			
			//Route link around the node to be removed
			pred.next = pred.next.next;
			
			//Check if pred is now last
			if (pred.next == null)
				last = pred;
			
		}
		return element;	
	}
	
	/**
	 * The remove method removes and element
	 * @param element The element to remove.
	 * @return true if the remove succeeded,
	 * false otherwise.
	 */
	
	public boolean remove(E element)
	{
		if (isEmpty())
			return false;
		
		if (element.equals(first.value))
		{
			//Removal of first item in list
			first = first.next;
			if (first == null)
				last = null;
			return true;
		}
		
		//Find the predecessor of the element to remove
		Node pred = first;
		while (pred.next != null && !pred.next.value.equals(element))
		{
			pred = pred.next;
		}
		
		//pred.next == null OR pred.next.value is element
		if (pred.next == null)
			return false;
		
		//pred.next.value is element
		pred.next = pred.next.next;
		
		//check if pred is now last
		if (pred.next == null)
			last = pred;
		
		return true;		
	}
	/**
	 * The get method returns the element at the given index.
	 * @param index The index of the element to return.
	 * @return The value of the element at the index.
	 */
	public E get(int index)
	{
		if (index < 0 || index > size())
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		
		Node p = first;
		int pos = 0;
		
		//Move to the correct position
		while (pos < index)
		{
			p = p.next;
			pos++;
		}
		
		//Return the value of the element at the index
		return p.value;
	}
	
	/**
	 * The print method traverses the list and prints
	 * all its elements.
	 */
	public void print()
	{
		Node ref = first;
		while (ref != null)
		{
			System.out.print(ref.value + " ");
			ref = ref.next;
		}
	}
	/**
	 * The removeAll method removes all elements from the list
	 */
	public void removeAll()
	{
		Node ref = first;
		while (ref != null)
		{
			first = null;
			ref = ref.next;
		}
	}
}
