package com.app.doubly_linked_list;

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
		
		if(position ==1) {
			head=head.next;
			if(head!=null) {
				head.prev=null;
			}
			return true;
		}
		
		Node del=head;
		
		//locate the deletable node
		
		for(int i=1;i<position-1;i++) {
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
	}
