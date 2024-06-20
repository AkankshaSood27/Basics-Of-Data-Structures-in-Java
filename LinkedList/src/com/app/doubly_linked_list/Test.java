package com.app.doubly_linked_list;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			DoublyLinkedList l = new DoublyLinkedList();

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
						int n=l.display();
						System.out.println("The number of nodes in the list are: "+n);
						break;
					case 2:
						System.out.println("Enter the element you want to insert at the end of the linked list: ");
						l.insertAtEnd(sc.nextInt());
						break;
					case 3:
						System.out.println("Enter the element you want to insert at the beginning of the linked list: ");
						l.insertAtBeginning(sc.nextInt());
						break;
					case 4:
						System.out.println("Enter the element you want to insert and the position where you want to insert the element: ");
						l.insertAtPosition(sc.nextInt(), sc.nextInt());
						break;
					case 5:
						break;
					case 6:
						System.out.println("Enter the value you want to delete: ");
						l.deleteByValue(sc.nextInt());
						break;
					case 7:
						System.out.println("Enter the position of the element you want to delete: ");
						l.deleteByPosition(sc.nextInt());
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
