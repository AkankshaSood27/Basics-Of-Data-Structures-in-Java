package com.app.singly_linked_list;

public class Node {
	// (collection of) data
	private int data;

	// reference to the next node
	private Node next;

	// ctor for new node
	public Node(int data) {
		this.data = data;
		next = null;
	}

	// getters and setters
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
