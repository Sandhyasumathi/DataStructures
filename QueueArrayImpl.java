package datastruct;

public class QueueArrays<T> {
	 static final int MAX_SIZE = 30;
     T arr[];
     int front, rear;
     
     @SuppressWarnings("unchecked")
	QueueArrays(){
    	 arr = (T[]) new Object[MAX_SIZE];
    	 front = -1;
    	 rear = -1;
     }
     
     public void enQueue(T val) {
    	 if(rear == MAX_SIZE-1) 
    		 throw new IndexOutOfBoundsException("Queue is full");
    	 
    	 if(front == -1)
    		 front = front + 1;
    	 
    	 arr[++rear] = val;
     }
     
     public T deQueue() {
    	 if(front == -1 || front > rear)
    		 throw new IndexOutOfBoundsException("Queue is Empty");
    	 
    	 return arr[front++];
     }
}
