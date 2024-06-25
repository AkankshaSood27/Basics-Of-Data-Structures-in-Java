import com.app.queue_exception.QueueException;

public class CircularQueue {
	
	private int []arr;
	int front,rear;
	int size;
	
	public CircularQueue(int size) {
		this.size=size;
		arr= new int[size];
		front=rear=-1;
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
	
	public boolean isFull() {
		return ((front==-1&&rear==(size-1)))||((rear+1)%size==front);
	}
	public boolean insert(int data) {
		if(isFull()) {
			return false;
		}
		
		rear=(rear+1)%size;
		arr[rear]=data;
		return true;
	}
	
	public int delete() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		
		front=(front+1)%size;
		return arr[front];
	}
	
	public void display() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty!");
		}
		
		int i=front;
		while(true) {
			System.out.print(arr[i]+" ");
			if(i==rear) {
				break;
			}
			i=(i+1)%size;
		}
		System.out.println();
	}
}
