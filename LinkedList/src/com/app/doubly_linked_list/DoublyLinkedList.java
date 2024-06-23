package com.app.doubly_linked_list;

import java.util.Stack;

import com.app.linked_list_exception.LinkedListException;

public class DoublyLinkedList {

	public class Node {
		private Node prev;
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}

	}

	public Node head;
	private Node tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Display all the elements of the list
	public int display() {
		int count = 0;
		Node current = head;
		if (head == null) {
			System.out.println("Doubly linked list is empty");
		}
		while (current != null) {
			count++;
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("NULL");
		return count;
	}

	// insert at the end of the list
	public boolean insertAtEnd(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			return true;
		}

		newNode.prev = tail;
		tail.next = newNode;
		tail = newNode;
		return true;

	}

	// insert at the beginning of the list
	public boolean insertAtBeginning(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			return true;
		}

		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		return true;

	}

	// insert at a position
	@SuppressWarnings("unused")
	public boolean insertAtPosition(int data, int position) throws LinkedListException {
		// in case of invalid position
		if (position <= 0 || (head == null && position > 1)) {
			throw new LinkedListException("Invalid Position Entered!");
		}

		Node newNode = new Node(data);
		if (newNode == null) {
			throw new LinkedListException("Element cannot be entered!");
		}

		if (position == 1) {
			if (head != null) {
				newNode.next = head;
				head.prev = newNode;
			}
			head = newNode;
			return true;
		}

		Node prevNode = head;
		for (int i = 1; i < position - 1; i++) {
			prevNode = prevNode.next;
			if (prevNode == null) {
				throw new LinkedListException("Element cannot be entered!");
			}
		}

		Node nextNode = prevNode.next;

		newNode.prev = prevNode;

		if (nextNode != null) {
			newNode.next = nextNode;
			nextNode.prev = newNode;
		}

		prevNode.next = newNode;
		return true;
	}

	// Delete by value
	public boolean deleteByValue(int data) throws LinkedListException {
		if (head == null) {
			throw new LinkedListException("List is Empty!");
		}

		if (head.data == data) {
			head = head.next;
			// check if there is new first node
			if (head != null) {

				head.prev = null;
			}
			return true;
		}

		Node del = head;
		// locate deletable node

		while (del.data != data) {
			del = del.next;
			if (del == null) {
				throw new LinkedListException("Cannot locate the deletabe node!");
			}
		}

		Node prevNode = del.prev;
		Node nextNode = del.next;

		prevNode.next = nextNode;
		// check if there is a next node
		if (nextNode != null) {
			nextNode.prev = prevNode;
		}

		return true;
	}

	public boolean deleteByPosition(int position) throws LinkedListException {

		if (head == null) {
			throw new LinkedListException("List is Empty!");
		}

		// in case of invalid position
		if (head == null && position > 1) {
			throw new LinkedListException("Invalid Position Entered!");
		}

		if (position == 1) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			return true;
		}

		Node del = head;

		// locate the deletable node

		for (int i = 1; i < position - 1; i++) {
			del = del.next;
			if (del == null) {
				throw new LinkedListException("Cannot locate the deletabe node!");
			}
		}

		Node prevNode = del.prev;
		Node nextNode = del.next;

		prevNode.next = nextNode;
		// check if there is a next node
		if (nextNode != null) {
			nextNode.prev = prevNode;
		}

		return true;
	}

	public boolean search(int data) throws LinkedListException {
		Node temp = head;
		if (temp == null) {
			throw new LinkedListException("List is empty");
		}
		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		throw new LinkedListException("Element not found!");
	}

	public int deleteFirst() throws LinkedListException {

		if (head == null) {
			throw new LinkedListException("The list is empty!");
		}
		int del = head.data;
		head = head.next;
		return del;
	}

	public int deleteLast() throws LinkedListException {

		if (head == null) {
			throw new LinkedListException("The list is empty!");
		}
		int del = tail.data;
		if (tail == head) { // List has only one node
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		return del;
	}

	// display the linked list in reverse order using stack- iterative
	// using head pointer only (using stack)
	public void displayReverse() {
		Node temp = head;
		Stack<Node> stack = new Stack<>();

		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + "<->");
		}
		System.out.println("NULL");
	}

	// using tail pointer only (not using stack)
	public void displayReverseFromTail() throws LinkedListException {
		Node temp = tail;
		if (head == tail) {
			if (tail == null) {
				throw new LinkedListException("The list is empty!");
			}
			System.out.println(head.data);
		}
		while (temp != null) {
			System.out.print(temp.data + "<->");
			temp = temp.prev;
		}
		System.out.println("NULL");
	}

	// display the linked list in reverse order- recursive

	public void displayReverse(Node head) {
		Node temp = head;
		if (temp != null) {
			displayReverse(temp.next);
			System.out.print(temp.data+" ");
		} else {
			return;
		}
	}

	// Reversing the given linked list- iterative
	public void reverse() throws LinkedListException {

		// in case of first node and list is empty
		if (head == tail) {
			if (tail == null) {
				throw new LinkedListException("The list is empty!");
			}
			System.out.println(head.data);
		}

		Node current = head;
		Node nextNode = null;

		while (current != null) {
			nextNode = current.next;
			current.next = current.prev;
			current.prev = nextNode;
			current = nextNode;
		}
		current = head;
		head = tail;
		tail = current;
		System.out.println("Head is pointing to: "+head.data+"\n");
		System.out.println("Tail is pointing to: "+tail.data);
	}

}
