package com.app.array_queue;

import com.app.queue_exception.QueueException;

public class Queue {
	private int []arr;
	private int front,rear;
	private int size;
	
	public Queue(int size) {
		this.size=size;
		arr=new int[size];
		front=rear=-1;	
	}
	
	public boolean isEmpty() {
		return (front==-1&&rear==-1)||(front>rear);
	}
	
	public boolean isFull() {
		return rear==(size-1);
	}
	
	//Insertion->Rear end--- and ---Deletion->Front end
	
	public boolean insert(int data) throws QueueException {
		if(isFull()) {
			throw new QueueException("Queue is full!");
		}
		arr[++rear]=data;
		if(front==-1) {
			front=0;
		}
		return true;
	}
	public int delete() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty!");
		}
		return arr[front++];
	}
	public void display() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		for (int i = front; i <= rear; i++) {
			System.out.println(arr[i] + " ");
		}
	}

}
