import java.util.*;

public class DList<E> implements Iterable<E> {
	
	private class Node{
		E data;
		Node next;
		Node prev;
		
	}
	 private Node nil;
	 private int size;
	
	//create a empty list
	public DList() {
		nil = new Node();
		nil.prev = nil;
        nil.next = nil;
        nil.data = null; 
		
	}
	
	public void addFirst(Object elem) {
		//adds elem to the front of the list
		Node newNode = new Node();
		newNode.data = (E)elem;
		newNode.prev = nil;
		newNode.next = nil.next;
		
		if(nil.next==nil)
			nil.prev = newNode;
		else 
			nil.next.prev = newNode;
		
		nil.next = newNode;
		
		size++;
	}
	
	public void addLast(Object elem) {
		//adds elem to the end of the list
		Node newNode = new Node();
		newNode.data = (E)elem;
		newNode.prev = nil.prev;
		newNode.next = nil;
		
		if(nil.prev == nil)
			nil.next = newNode;
		else
			nil.prev.next = newNode;
		
		nil.prev = newNode;
		
		size++;

	}
	
	// getFirst
	public Object getFirst() {
		return nil.next.data;
	}
	
	// getLast
	public Object getLast() {
		return nil.prev.data;
		
	}
	// removes the front element of the list and returns it
	public Object removeFirst() {
		if(size == 0)
			throw new NoSuchElementException("List is empty");
		
		Object temp = nil.next.data;
		nil.next = nil.next.next;
		
		if(nil.next == nil)
			nil.prev = nil;
		
		size--;
		return temp;
	}
	
	// public String removeLast() 
	public Object removeLast() {
		if(size==0)
			throw new NoSuchElementException("List is empty");
		
		Object temp = nil.prev.data;
		nil.prev = nil.prev.prev;
		
		if(nil.prev == nil)
			nil.next = nil;
		else
			nil.prev.next=nil;
		
		size--;
		
		return temp;
	}
	
	//Returns the value at “position” index. An IndexOutOfBoundsException should be
    //thrown if the index doesn’t exist.
	public Object get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is out of bound for list length" + size);
		
		int count = 0;
		Node temp = nil.next;
		
		while(count < index) {
			count++;
			temp = temp.next;
		}
		
		return temp.data;
	}
	
	// changes the value at “position” index and returns the old value. An
	//IndexOutOfBoundsException should be thrown if the index doesn’t exist. 
	public E set(int index, Object value) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index is out of bound for list length" + size);
		
		
		int count = 0;
		Node temp = nil.next;
		
		while(count < index) {
			count++;
			temp = temp.next;
		}
		
		E old = temp.data;
		temp.data = (E)value;
		
		return old;
	}
	
	//Returns true if obj appears in the list and false otherwise. 
	public boolean contains(Object obj) {
		if(size == 0)
			return false;
		
		if(indexOf(obj) == -1)
			return false;
		
		return true;
	}
	
	//return the size
	public int size() {
		return size;
	}
	
	//Returns the index of obj if it is in the list and -1 otherwise. 
	public int indexOf(Object obj) {
		int index = 0;
		Node curr = nil.next;
		
		while(curr != nil) {
			if(curr.data.equals(obj))
				return index;
			index++;
			curr = curr.next;
		}
		return -1;
	}

	//
	@Override
	public Iterator<E> iterator() {
		//return null;
		DListIterator iter = new DListIterator();
		while(iter.hasNext())
			System.out.println((String)iter.next());
		
		return iter;
		
	}
	
	 private class DListIterator implements Iterator<E> {
		 private Node pointer;

		 public DListIterator() {
		 pointer = nil.next;
		 }

		@Override
		public boolean hasNext(){
			return pointer != nil;
		}

		@Override
		public E next(){
			E a = pointer.data;
			pointer = pointer.next;
			return a;
		} 
	 }
	
	
	public static void main(String[] args) {
		DList<String> test = new DList<String>();
		test.addFirst("Hello");
		test.addFirst("World");
		test.addFirst("Class");
		test.addLast("Bye");
		
		test.iterator(); //iterate through the list
		
		//System.out.println(test); //print list
		System.out.println();

		System.out.println("First is : " + test.getFirst()); //print class
		System.out.println("Last is : " + test.getLast()); //print Bye
		
		System.out.println("Does the list contains Bye : " + test.contains("Bye")); //True
		System.out.println("Does the list contains Hi : " + test.contains("Hi")); //False
		System.out.println("Size : " + test.size()); //4
		System.out.println("Index 0 is : " + test.get(0)); //Class
		System.out.println("Index 1 is : " + test.get(1)); //world
		System.out.println("Index 2 is : " + test.get(2)); //Hello
		System.out.println("Index 3 is : " + test.get(3)); //Bye
		System.out.println("Index of world is : " + test.indexOf("World")); //print 1
		System.out.println("Change world to Yes - Old index 1 is : " + test.set(1, "Yes") + "|| New index 1 is : " + test.get(1));
		System.out.println();
		
		System.out.println("Remove " + test.removeFirst()); //print Remove Class
		System.out.println("New First is : " + test.getFirst()); //print world
		System.out.println("Remove " + test.removeLast()); // remove Bye
		System.out.println("New Last is : " + test.getLast()); //print Hello
		System.out.println("New Size : " + test.size()); //2
		System.out.println();
		
		//EXTRA CREDIT : Make the list generic 
		test.addLast(1);
		System.out.println("Int as new last : " + test.getLast());

	}

}
