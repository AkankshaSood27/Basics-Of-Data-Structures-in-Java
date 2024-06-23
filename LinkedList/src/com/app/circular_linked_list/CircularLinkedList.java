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
		Node temp = head;
		int count = 0;

		if (head == null) {
			throw new LinkedListException("List is empty!");
		}
		do {
			count++;
			System.out.print(temp.data + "-> ");
			temp = temp.next;
		} while (temp != head);
		System.out.println(head.data);
		return count;
	}

	// method to insert the node at the end of the circular linked list
	public void insert(int data) {
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
		for (int i = 1; i < pos - 1; i++) {
			prev = prev.next;
			if (prev == null) {
				return false;
			}

		}
		newNode.next = prev.next;
		prev.next = newNode;
		return true;

	}

	// search an element
	public boolean search(int data) throws LinkedListException {
		if (head == null) {
			throw new LinkedListException("List is Empty!");
		}
		Node temp = head;
		int count = 0;

		do {
			count++;
			if (temp.data == data) {
				System.out.println("The element is found at the position " + count);
				return true;
			}
			temp = temp.next;
		} while (temp != head);
		return false;
	}

	// Delete by value
	public boolean deleteByVal(int val) throws LinkedListException {
		if (head == null) {
			throw new LinkedListException("The list is empty!");
		}
		// if data to be deleted is present at the first node!
		if (head.data == val) {
			head = head.next;
			return true;
		}
		Node prev = head;
		Node del = head;
		while (del.data != val) {
			prev = del;
			del = del.next;
			if (del == null) {
				throw new LinkedListException("Element not found!");
			}
		}

		prev.next = del.next;
		return true;
	}

	public boolean deleteByPosition(int position) throws LinkedListException {
		// in case of empty linked list or invalid position
		if (head == null) {
			throw new LinkedListException("The List is already empty! Underflow");
		}
		if (position <= 0) {
			throw new LinkedListException("The position entered is invalid! Please entered a valid position");
		}

		// in case of first position
		if (position == 1) {
			head = head.next;
			return true;
		}

		Node prev = head;
		for (int i = 1; i < position - 1; i++) {
			prev = prev.next;
			if (prev.next == head) {
				throw new LinkedListException("Element not found!");
			}
		}
		Node del = prev.next;
		prev.next = del.next;
		return true;

	}

	public int deleteLast() throws LinkedListException {
		
		int data;
		// if list is empty
		if (head == null) {
			throw new LinkedListException("The List is already empty! Underflow");
		}
		Node temp = head;
		Node prev = null;
		
		//if there is only one node in the list
		if(head.next==head) {
			data=head.data;
			head=null;//list will be empty
			return data;
		}
		//traverse till you reach the last node
		do {
			prev=temp;
			temp=temp.next;
			
		}while(temp.next!=head);
		
		//remove the last node
		data=temp.data;
		prev.next=head;
		return data;
	}
	
	
	
	public void reverse() {
		
		//there is only one node in the list
		if(head==null||head.next==null) {
			return;
		}
		Node prev=null;
		Node current=head;
		Node next=null;
		//Node tail=head;
		
		do {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}while(current!=head);
		
		head.next=prev;
		head=prev;
	}
}
