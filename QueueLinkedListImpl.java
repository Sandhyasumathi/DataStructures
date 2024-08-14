package datastruct;

public class QueueUsingLinkedList<T> {
	Node front;
	Node rear;

	class Node {
		T data;
		Node next;

		Node(T val) {
			data = val;
			next = null;
		}
	}

	QueueUsingLinkedList() {
		front = null;
		rear = null;
	}

	public void enqueue(T val) {
		Node newNode = new Node(val);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public T dequeue() {
		if (front == null) {
			throw new IndexOutOfBoundsException("Queue is Empty");
		}
		T temp = front.data;
		front = front.next;

		if (front == null) {
			rear = null;
		}
		return temp;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public T elementAtfront() {
		if (front == null) {
			throw new IndexOutOfBoundsException("Queue is Empty");
		}
		return front.data;
	}

}
