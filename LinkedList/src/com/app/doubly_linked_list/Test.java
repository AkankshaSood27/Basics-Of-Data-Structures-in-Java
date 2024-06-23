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
						+ "5.Search an element\n" + "6.Deletion by value\n" + "7.Deletion by position\n"
						+ "8.Delete the first node\n" + "9.Delete the last node\n"
						+ "10.Display the elements of the list in reverse order from head using stack\n"
						+ "11.Display the elements of the list in reverse order from tail using iterative approach\n"
						+ "12.Display the linked list in reverse order using recursive approach\n"
						+ "13.Reverse the given list using iterative approach\n" + "14.Exit\n");
				try {
					switch (sc.nextInt()) {
					case 1:
						int n = l.display();
						System.out.println("The number of nodes in the list are: " + n);
						break;
					case 2:
						System.out.println("Enter the element you want to insert at the end of the linked list: ");
						l.insertAtEnd(sc.nextInt());
						break;
					case 3:
						System.out
								.println("Enter the element you want to insert at the beginning of the linked list: ");
						l.insertAtBeginning(sc.nextInt());
						break;
					case 4:
						System.out.println(
								"Enter the element you want to insert and the position where you want to insert the element: ");
						l.insertAtPosition(sc.nextInt(), sc.nextInt());
						break;
					case 5:
						System.out.println("Enter the element you want to search: ");
						boolean res=l.search(sc.nextInt());
						if(res) {
							System.out.println("The element is present inside the list");
						}
						else
						{
							System.out.println("Element not found!");
						}
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
						System.out.println(l.deleteFirst() + " has been deleted!");
						break;
					case 9:
						System.out.println(l.deleteLast() + " has been deleted!");
						break;
					case 10:
						System.out.println("Displaying the linked list in reverse order from head using stack: ");
						l.displayReverse();
						break;
					case 11:
						System.out.println(
								"Displaying the linked list in reverse order from tail using iterative approach: ");
						l.displayReverseFromTail();
						break;

					case 12:
						System.out.println("Displaying the linked list in reverse order using recursive approach: ");
						l.displayReverse(l.head);
						break;
					case 13:
						System.out.println("Reversing the given linked list- iterative");
						l.reverse();
						break;
					case 14:
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
