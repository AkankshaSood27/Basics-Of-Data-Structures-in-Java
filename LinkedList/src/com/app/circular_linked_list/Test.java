package com.app.circular_linked_list;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			CircularLinkedList l = new CircularLinkedList();

			// adding values to the list at the ends
			l.insert(10);
			l.insert(20);
			l.insert(30);
			l.insert(40);
			l.insert(50);

			while (!exit) {

				System.out.println("\nEnter your choice: ");
				System.out.println("1.Display\n" + "2.Insertion at the end of the list\n"
						+ "3.Insertion at a particular position\n" + "4.Search an element\n" + "5.Deletion by value\n"
						+ "6.Deletion by position\n" + "7.Delete the last node\n"
						+ "8.Reversing the given linked list- iterative\n" + "9.Exit\n");

				try {
					switch (sc.nextInt()) {
					case 1:
						int count = l.display();
						System.out.println("No of nodes in the list is: " + count);
						break;
					case 2:
						System.out.println("Enter the element you want to add at the end: ");
						l.insert(sc.nextInt());
						break;
					case 3:
						System.out.println("Enter the element and its position: ");
						l.insertAtPosition(sc.nextInt(), sc.nextInt());
						break;
					case 4:
						System.out.println("Enter the element you want to search: ");
						boolean result = l.search(sc.nextInt());
						if (!result) {
							System.out.println("The element is not found!");
						}
						break;
					case 5:
						System.out.println("Enter the element you want to delete: ");
						if (l.deleteByVal(sc.nextInt())) {
							System.out.println("Element deleted successfully!");
						}
						break;
					case 6:
						System.out.println("Enter the position at which you want to delete the element: ");
						if (l.deleteByPosition(sc.nextInt())) {
							System.out.println("Element deleted successfully!");
						}
						break;
					case 7:
						int del = l.deleteLast();
						System.out.println(del + " has been removed from the list!");
						break;
					case 8:
						l.reverse();
						l.display();
						break;
					case 9:
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
