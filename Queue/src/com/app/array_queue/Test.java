package com.app.array_queue;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Queue queue = new Queue(5);
			while (!exit) {
				System.out.println("Enter your choice: ");
				System.out.println("1.Add an element\n" + "2.Delete an element\n" + "3.Empty status\n"
						+ "4.Full status\n" + "5.Display\n"
								+ "6.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the element you want to insert inside the queue: ");
						queue.insert(sc.nextInt());
						break;
					case 2:
						System.out.println("The deleted element is: " + queue.delete());
						break;
					case 3:
						System.out.println("Empty Status: " + queue.isEmpty());
						break;
					case 4:
						System.out.println("Full Status: " + queue.isFull());
						break;
					case 5:
						System.out.println("The elements of the queue are: ");
						queue.display();
						break;
					case 6:
						exit = true;
						System.out.println("Exitting...\nSuccessfull!");
						break;
					default:
						System.out.println("Wrong Entry \n ");
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
