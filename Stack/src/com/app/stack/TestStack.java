package com.app.stack;

import java.util.Scanner;

public class TestStack {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			Stack<Integer> stack = new Stack<>(5);

			while (!exit) {

				System.out.println("\nEnter your choice: ");
				System.out.println("1.Push\n" + "2.Pop\n" + "3.Peek\n" + "4.check Empty\n" + "5.check Full\n"
						+ "6.Exit and display");

				try {
					switch (sc.nextInt()) {

					case 1:
						System.out.println("Enter integer element to push");
						stack.push(sc.nextInt());
						break;
					case 2:
						System.out.println("Popped Element: " + stack.pop());
						break;
					case 3:
						System.out.println("Element at the top of the stack is: " + stack.peek());
						break;
					case 4:
						System.out.println("Empty Status: " + stack.isEmpty());
						break;
					case 5:
						System.out.println("Full Status: " + stack.isFull());
						break;
					case 6:
						exit = true;
						System.out.println("Elements of the stack are: ");
						/* display stack */
						stack.display();
						System.out.println();
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
