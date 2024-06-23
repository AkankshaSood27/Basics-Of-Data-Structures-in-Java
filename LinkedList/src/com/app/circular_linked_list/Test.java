package com.app.circular_linked_list;

import java.util.Scanner;

import com.app.doubly_linked_list.DoublyLinkedList;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			CircularLinkedList l = new CircularLinkedList();

			// adding values to the list at the end
			l.insertAtEnd(10);
			l.insertAtEnd(20);
			l.insertAtEnd(30);
			l.insertAtEnd(40);
			l.insertAtEnd(50);

			while (!exit) {

				System.out.println("\nEnter your choice: ");
				System.out.println("1.Display\n" + "2.Insertion at the end of the list\n"
						+ "3.Insertion at the beginning\n" + "4.Insertion at a particular position\n"
						+ "5.Search an element\n" + "6.Deletion by value\n"
						+ "7.Deletion by position\n" + "8.Delete the first node\n"
						+ "9.Delete the last node\n" + "10.Reversing the given linked list- iterative\n"
						+ "11.Reverse the list by recursion\n" + "12.Exit\n");
				
				try {
					switch (sc.nextInt()) {
					case 1:
						int count=l.display();
						System.out.println("No of nodes in the list is: "+count);
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("Enter the element and its position: ");
						l.insertAtPosition(sc.nextInt(), sc.nextInt());
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						break;
					case 10:
						break;
					case 11:
						break;
					case 12:
						exit = true;
						System.out.println("Exitting...\nSuccessfull!");
						break;

					default:
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
