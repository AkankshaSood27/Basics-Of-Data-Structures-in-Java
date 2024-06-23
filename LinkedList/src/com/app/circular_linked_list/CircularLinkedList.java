package com.app.circular_linked_list;

import com.app.linked_list_exception.LinkedListException;

public class CircularLinkedList {

	public class Node {

		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head;

	public CircularLinkedList() {
		this.head = null;
	}
	
	
	public int display() throws LinkedListException {
		Node temp=head;
		int count = 0;
		
		if(head==null) {
			throw new LinkedListException("List is empty!");
		}
		do {
			count++;
			System.out.print(temp.data+"-> ");
			temp=temp.next;
		}while(temp!=head);
		System.out.println(head.data);
		return count;
	}

	// method to insert the node at the end of the circular linked list
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);

		// if the list is empty
		if (head == null) {
			head = newNode;
			newNode.next = head;// point to itself to make it circular linked list
		}

		Node temp = head;

		// traverse to the last node
		while (temp.next != head) {
			temp = temp.next;
		}

		// insert the new node at the end and make it circular
		temp.next = newNode;
		newNode.next = head;
	}

	public boolean insertAtPosition(int data, int pos) {
		if ((head == null && pos > 1) || pos < 1) {
			return false;
		}

		Node newNode = new Node(data);

		if (pos == 1) {
			if (head == null) {
				head = newNode;
				newNode.next = head;
			}

			Node temp = head;

			while (temp.next != head) {
				temp = temp.next;
				if (temp == null) {
					return false;
				}

			}
			temp.next = newNode;
			newNode.next = head;
			return true;
		}

		Node prev = head;
		for (int i = 1; i < pos-1; i++) {
			prev = prev.next;
			if (prev == null) {
				return false;
			}

		}
		newNode.next = prev.next;
		prev.next = newNode;
		return true;

	}
}
