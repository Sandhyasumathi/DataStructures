package datastruct;

public class StackArray<T> {
	static final int MAX_SIZE = 30;
	@SuppressWarnings("unchecked")
	T arr[] = (T[]) new Object[MAX_SIZE];
	int top;

	StackArray() {
		top = -1;
	}

	public void push(T val) {
		if (top == MAX_SIZE - 1) {
			throw new IndexOutOfBoundsException("Stack OverFlow");
		}
		arr[++top] = val;
	}

	public T pop() {
		if (top == -1) {
			throw new IndexOutOfBoundsException("Stack UnderFlow");
		} else {
			return arr[top--];
		}
	}

	public T peek() {
		return arr[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
