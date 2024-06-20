package com.app.circular_linked_list;

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
	
	//method to insert the node at the end of the circular linked list
	public void insertAtEnd(int data) {
		Node newNode=new Node(data);
		
		//if the list is empty
		if(head==null) {
			head=newNode;
			newNode.next=head;//point to itself to make it circular linked list
		}
		
		Node temp=head;
		
		//traverse to the last node
		while(temp.next!=head) {
			temp=temp.next;
		}
		
		//insert the new node at the end and make it circular
		temp.next=newNode;
		newNode.next=head;
	}
}
