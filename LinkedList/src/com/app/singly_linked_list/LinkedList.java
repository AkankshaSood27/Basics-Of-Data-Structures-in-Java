package com.app.singly_linked_list;

import java.util.Stack;

import com.app.linked_list_exception.LinkedListException;

public class LinkedList {
	private Node head;

	// getters n setters for node
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// default ctor for newly created linked list
	public LinkedList() {
		head = null;
	}

	// traversing-iteratively
	public int traverse() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			System.out.print(temp.getData() + " ->");
			temp = temp.getNext();
		}
		System.out.print("NULL\n");
		return count;
	}

	// traversing-recursively
	public void traverse(Node head) {

		Node temp = head;
		if (temp != null) {

			System.out.print(temp.getData() + " ");
			traverse(temp.getNext());
		}
		return;
	}

	// Display all the elements in the reverse order- iterative---using stack
	public void displayReverse() {
		Node temp = head;
		Stack<Node> stack = new Stack<Node>();
		while (temp != null) {
			stack.push(temp);
			temp = temp.getNext();
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getData() + " ->");
		}
		System.out.print("NULL\n");
	}

	// Display all elements in the reverse order- recursive
	public void displayReverse(Node head) {
		Node temp = head;
		if (temp != null) {
			displayReverse(temp.getNext());
			System.out.print(temp.getData() + " ");
		} else {
			return;
		}
	}

	// Searching a data element in the list-iterative
	public boolean search(int data) throws LinkedListException {
		Node temp = head;
		while (temp != null) {
			if (temp.getData() == data) {
				return true;
			}
			temp = temp.getNext();
		}
		throw new LinkedListException("Element not Present!");
	}

	// searching a data element in the linked list -recursive
	public boolean search(Node head, int data) throws LinkedListException {
		Node temp = head;
		if (temp == null) {
			throw new LinkedListException("List is empty");
		}
		if (temp.getData() == data) {
			return true;
		} else {
			return search(temp.getNext(), data);
		}
	}

	// searching an element in the sorted list-iterative
	public boolean searchData(int data) {
		Node temp = head;

		while (temp != null) {
			if (temp.getData() == data) {
				return true;
			} else if (temp.getData() < data) {
				temp = temp.getNext();
			} else {
				return false;
			}
		}
		return false;
	}

	// searching a data element in the sorted linked list -recursive
	public boolean searchData(Node head, int data) {
		Node temp = head;
		if (temp.getData() == data) {
			return true;
		} else if (temp.getData() < data) {
			return searchData(temp.getNext(), data);
		} else {
			return false;
		}
	}

	// Note---> searching an element for an array
	// unsorted array:- O(n)
	// sorted array:- O(log n)---> binary search

	// searching an element for linked list
	// unsorted:- O(n)
	// sorted:- O(n)

	// Insertion at the end of the list
	@SuppressWarnings("unused")
	public boolean insertAtEnd(int data) {
		// creating a new node
		Node newNode = new Node(data);

		// newNode is null
		if (newNode == null) {
			return false;
		}

		// head is not referring to any node i.e. empty list
		if (head == null) {
			head = newNode;
			return true;
		}

		// data already exist
		Node temp = head;
		if (head.getData() == data) {
			return false;
		}

		while (temp.getNext() != null) {
			temp = temp.getNext();

			// terminating if the data already has been entered
			if (temp.getData() == data) {
				return false;
			}
		}
		temp.setNext(newNode);
		return true;
	}

	@SuppressWarnings("unused")
	public boolean insertAtBeginning(int data) {
		// creating a new node
		Node newNode = new Node(data);

		// head is not referring to any node i.e. empty list
		// If the list is empty (head is null), set the new node as the head
		if (head == null) {
			head = newNode;
			return true;
		}

		// Inserting newNode at the beginning of the list
	    newNode.setNext(head); // Set newNode's next to the current head
	    head = newNode; // Update head to newNode

		return true;
	}

	// Insertion at a particular position
	@SuppressWarnings("unused")
	public boolean insertAtPositon(int data, int position) {
		// invalid position i.e.
		if (position <= 0 || (head == null && position > 1)) {
			return false;
		}

		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}

		// for the first node
		if (position == 1) {
			newNode.setNext(newNode);
			head = newNode;
			return true;
		}

		/*
		 * for inserting the node at the nth position
		 *
		 * create a node object i.e newNode which you want to insert
		 *
		 * Locate previous (n-1)th node
		 *
		 * newNode->next=position->next
		 *
		 **/

		Node prev = head;
		// iterate till u reach the node previous to the position
		for (int i = 1; i < position - 1; i++) {
			prev = prev.getNext();
			if (prev == null) {
				return false;
			}
		}
		// newNode->next= prev->next
		newNode.setNext(prev.getNext());

		// inserting node at the given position
		prev.setNext(newNode);
		return true;

	}

	// Deletion
	// delete by value

	public boolean deleteByValue(int data) throws LinkedListException {
		// empty list
		if (head == null) {
			throw new LinkedListException("The List is already empty! Underflow");
		}

		// if data need to be deleted is present at the first node
		if (head.getData() == data) {
			head = head.getNext();
			return true;
		}

		Node prev = head;
		Node del = head;
		while (del.getData() != data) {
			prev = del;
			del = del.getNext();
			if (del == null) {
				throw new LinkedListException("Element not found!");
			}
		}
		prev.setNext(del.getNext());
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
			head = head.getNext();
			return true;
		}

		Node prev = head;
		for (int i = 1; i < position - 1; i++) {
			prev = prev.getNext();
			if (prev.getNext() == null) {
				throw new LinkedListException("Element not found!");
			}
		}

		Node del = prev.getNext();
		prev.setNext(del.getNext());
		return true;
	}

	// Deleting the first node
	public int deleteFirst() throws LinkedListException {
		if (head == null) {
			throw new LinkedListException("The List is already empty! Underflow");
		}
		int data = head.getData();
		head = head.getNext();
		return data;
	}

	// Deleting the last node
	public int deleteLast() throws LinkedListException {

		int data;
		// if list is empty
		if (head == null) {
			throw new LinkedListException("The List is already empty! Underflow");
		}

		// If there is only one node in the list
		if (head.getNext() == null) {
			data = head.getData();
			head = null;
			return data;
		}
		Node temp = head;
		Node prev = null;

		// Traverse to the last node, keeping track of the previous node
		while (temp.getNext() != null) {
			prev = temp;
			temp = temp.getNext();
		}

		// Remove the last node
		data = temp.getData();
		prev.setNext(null);

		return data;

	}

	// Reversing the given linked list- iterative
	public void reverse() {
		// in case of first node and empty list
		if (head == null || head.getNext() == null) {
			return;
		}

		Node n1 = head;
		Node n2 = head.getNext();

		while (n2 != null) {
			Node n3 = n2.getNext();
			n2.setNext(n1);
			n1 = n2;
			n2 = n3;
		}

		head.setNext(null);
		head = n1;
	}

	// reverse by recursion
	public void reverse(Node prev, Node curr) {

		// Base case: if the list is empty or only one node
		if (curr == null) {
	        return;
	    }

	    // Base case: if reached the last node
	    if (curr.getNext() == null) {
	        // Update head to be the last node (curr)
	        head = curr;
	        // Set the next of the last node to point to the previous node (prev)
	        curr.setNext(prev);
	        return; // This return is important to stop further recursion
	    }
	    

	    // Recursive case: reverse from the current node onwards
	    Node next = curr.getNext();
	    curr.setNext(prev); // Reverse the pointer

	    // Recursive call to reverse the rest of the list
	    reverse(curr, next);
	}
}
