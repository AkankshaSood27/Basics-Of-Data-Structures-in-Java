package com.app.singly_linked_list;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			LinkedList l = new LinkedList();

			// adding values to the list at the end
			l.insertAtEnd(10);
			l.insertAtEnd(20);
			l.insertAtEnd(30);
			l.insertAtEnd(40);
			l.insertAtEnd(50);

			while (!exit) {

				System.out.println("\nEnter your choice: ");
				System.out.println("1.Traverse-Iterative\n" + "2.Traverse-Recursively\n"
						+ "3.Display all the elements in the reverse order- iterative\n"
						+ "4.Display all elements in the reverse order- recursive\n" + "5.Searching data-Iterative\n"
						+ "6.Searching data-Recursive\n" + "7.Searching data in sorted list-Iterative\n"
						+ "8.Searching data in sorted list-Recursive\n" + "9.Insertion at the end of the list\n"
						+ "10.Insertion at the beginning\n" + "11.Insertion at a particular position\n"
						+ "12.Deletion by value\n" + "13.Deletion by position\n" + "14.Delete the first node\n"
						+ "15.Delete the last node\n" + "16.Reversing the given linked list- iterative\n"
						+ "17.Reverse the list by recursion\n" + "18.Exit\n");
				try {
					switch (sc.nextInt()) {

					case 1:
						int count = l.traverse();
						System.out.println("Number of nodes in the list are: " + count);
						break;
					case 2:
						l.traverse(l.getHead());
						
						break;
					case 3:
						l.displayReverse();
						break;
					case 4:
						l.displayReverse(l.getHead());
						break;
					case 5:
						System.out.println("Enter the element you want to search: ");
						boolean res = l.search(sc.nextInt());
						if(res) {
							System.out.println("The element is present inside the list!");
						}
						else {
							System.out.println("The element is not present inside the list!");
						}
						break;
					case 6:
						System.out.println("Enter the element you want to search: ");
						boolean res1 = l.search(l.getHead(),sc.nextInt());
						if(res1) {
							System.out.println("The element is present inside the list!");
						}
						else {
							System.out.println("The element is not present inside the list!");
						}
						break;
					case 7:
						System.out.println("Enter the element you want to search: ");
						boolean res2 = l.searchData(sc.nextInt());
						if(res2) {
							System.out.println("The element is present inside the list!");
						}
						else {
							System.out.println("The element is not present inside the list!");
						}
						break;
					case 8:
						System.out.println("Enter the element you want to search: ");
						boolean res3 = l.searchData(l.getHead(),sc.nextInt());
						if(res3) {
							System.out.println("The element is present inside the list!");
						}
						else {
							System.out.println("The element is not present inside the list!");
						}
						break;
					case 9:
						System.out.println("Enter the element you want to insert at the end: ");
						l.insertAtEnd(sc.nextInt());
						break;
					case 10:
						System.out.println("Enter the element you want to insert at the beginning: ");
						l.insertAtBeginning(sc.nextInt());
						break;
					case 11:
						System.out.println("Enter the element and the position where you want to insert the element: ");
						l.insertAtPositon(sc.nextInt(), sc.nextInt());
						break;
					case 12:
						System.out.println("Enter the element you want to delete: ");
						l.deleteByValue(sc.nextInt());
						break;
					case 13:
						System.out.println("Enter the position at which you want to delete the element: ");
						l.deleteByPosition(sc.nextInt());
						break;
					case 14:
						int del=l.deleteFirst();
						System.out.println(del+" has been removed from the list!");
						break;
					case 15:
						int d=l.deleteLast();
						System.out.println(d+" has been removed from the list!");
						break;
					case 16:
						l.reverse();
						l.traverse();
						break;
					case 17:
						l.reverse(null, l.getHead());
						l.traverse();
						break;
					case 18:
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
