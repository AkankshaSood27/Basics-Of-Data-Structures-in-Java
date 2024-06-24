package com.app.linked_list_stack;

import com.app.stack_exception.StackException;

public class MyStack {

	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			return;
		}
		// insert at the beginning of the list-> both insertion and deletion will be
		// from one end
		newNode.next = head;
		head = newNode;
	}

	public int pop() {
		int top = head.data;
		head = head.next;
		return top;
	}

	public int peek() {
		int top =head.data;
		return top;
	}
	public void display() throws StackException {
		if (isEmpty()) {
			throw new StackException("The List is Empty!");
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
