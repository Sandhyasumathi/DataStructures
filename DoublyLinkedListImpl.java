package datastruct;

import java.util.Iterator;

public class DoublyLinkedList<T> {

	Node head;
	Node tail;

	class Node {
		T data;
		Node next;
		Node prev;

		Node(T val) {
			data = val;
			next = null;
			prev = null;
		}
	}

	DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public void insertAtBegining(T val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;

	}

	public void insertAtPos(int pos, T val) {
		if (pos == 0) {
			insertAtBegining(val);
			return;
		}
		Node newNode = new Node(val);
		Node temp = head;
		for (int i = 1; i < pos; i++) {
			temp = temp.next;
			if (temp == null)
				throw new IndexOutOfBoundsException("Invalid Pos");
		}

		newNode.next = temp.next;
		newNode.prev = temp;
		if (temp == tail) {
			temp.next = newNode;
			newNode.prev = temp;
			tail = newNode;
		} else {
			temp.next.prev = newNode;
			temp.next = newNode;
		}
	}

	public void deleteAtBeginning() {
		if (head == null)
			throw new IndexOutOfBoundsException("Deletion attempted on empty list ");

		head = head.next;
		if (head == null) {
			tail = null;
		}
		head.prev = null;
	}

	public void deleteAtPos(int pos) {
		if (head == null) {
			throw new IndexOutOfBoundsException("Deletion attempted on empty list");
		}
		if (pos == 0) {
			deleteAtBeginning();
			return;
		}
		Node temp = head;
		Node prev = null;
		for (int i = 1; i <= pos; i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		if (temp == tail) {
			tail = prev;
			return;
		}
		temp.next.prev = prev;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void displayreverse() {
		Node temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
	}
}
