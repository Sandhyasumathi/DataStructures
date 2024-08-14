package datastruct;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
	Node head;
 
	class Node {
		T data;
		Node next;

		Node(T val) {
			data = val;
			next = null;
		}
	}

	LinkedList() {
		head = null;
	}

	public void insertAtBegining(T val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;

		}
	}
	
	public void insertAtPos(int pos,T val) {
		if(pos == 0) {
			insertAtBegining(val);
			return;
		}
		Node newNode = new Node(val);
		Node temp = head;
		for(int i=1;i<pos;i++) {
			temp = temp.next;
		}
		
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void deleteAtPos(int pos) {
		if(head == null) {
			throw new IndexOutOfBoundsException("Deletion attempted on empty list");
		}
		if(pos == 0) {
			head = head.next;
			return;
		}
		Node temp = head;
		Node prev = null;
		for(int i=1;i<=pos;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
	
	public T get (int pos) {
		Node temp = head;
		for(int i=1;i<=pos;i++) {
		   temp = temp.next;
		}
		return temp.data;
	}
	public void update (int pos, T value) {
		Node temp = head;
		for(int i=1;i<=pos;i++) {
			temp = temp.next;
		}
		temp.data = value;
	}
	
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public void reverseALinkedList() {
		Node prev = null;
		Node current = head;
		Node next = head.next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
            Node temp = head;
			@Override
			public boolean hasNext() {
				return temp!=null;
			}

			@Override
			public T next() {
				T value = temp.data;
				temp = temp.next;
				return value;
			}
		
		};
	}
}
