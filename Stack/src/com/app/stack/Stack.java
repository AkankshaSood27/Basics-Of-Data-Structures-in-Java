package com.app.stack;

import com.app.stack_exception.StackException;

public class Stack<T> {
	T []arr;//using array to implement stack
	int size;//size of the stack i.e. array
	int top;//points to the top most element of the stack
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		this.size=size;
		top=-1;
		arr=(T []) new Object[size];
	}
	
	public boolean isEmpty() {
		//returns true if the stack is empty--- checks underflow
		//returns true if top is -1
		return top==-1;
	}
	
	public boolean isFull() {
		//returns true if the stack is full--- checks overflow
		//returns true if the top is size-1
		return top==(size-1);
	}
	
	public boolean push(T data) throws StackException {
		//check overflow
		if(isFull()) {
			throw new StackException("Stack is Full!");
		}
		//push the element into the stack
		arr[++top]=data;
		return true;
	}
	
	public T pop() throws StackException {
		//check underflow
		if(isEmpty()) {
			throw new StackException("Stack is Empty!");
		}
		return arr[top--];
	}
	
	public T peek() throws StackException {
		if(isEmpty()) {
			throw new StackException("Stack is Empty!");
		}
		return arr[top];
		
		/*T val=pop();
		 * push(val);
		 * return val;
		 * */
	}
	
	public void display() {
		
		if(size==0) {
			System.out.println("The Stack is Empty!");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
