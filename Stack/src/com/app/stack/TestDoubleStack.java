package com.app.stack;

import com.app.stack_exception.StackException;
import java.util.Scanner;

public class TestDoubleStack {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			DoubleStack doubleStack = new DoubleStack(10); // Adjust size as needed

			while (!exit) {
				System.out.println("\nEnter your choice: ");
				System.out.println("1. Push in Stack 1\n" + "2. Push in Stack 2\n" + "3. Pop from Stack 1\n"
						+ "4. Pop from Stack 2\n" + "5. Check if Stack 1 is Empty\n" + "6. Check if Stack 2 is Empty\n"
						+ "7. Check if the DoubleStack is Full\n" + "8. Exit and display");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter integer element to push in Stack 1:");
						int data1 = sc.nextInt();
						doubleStack.push1(data1);
						break;
					case 2:
						System.out.println("Enter integer element to push in Stack 2:");
						int data2 = sc.nextInt();
						doubleStack.push2(data2);
						break;
					case 3:
						System.out.println("Popped Element from Stack 1: " + doubleStack.pop1());
						break;
					case 4:
						System.out.println("Popped Element from Stack 2: " + doubleStack.pop2());
						break;
					case 5:
						System.out.println("Stack 1 is Empty: " + doubleStack.isEmpty1());
						break;
					case 6:
						System.out.println("Stack 2 is Empty: " + doubleStack.isEmpty2());
						break;
					case 7:
						System.out.println("DoubleStack is Full: " + doubleStack.isFull());
						break;
					case 8:
						exit = true;
						System.out.println("Elements of the stack are: ");
						/* display stack */
						doubleStack.display();
						System.out.println();
						System.out.println("Exitting...\nSuccessfull!");
						break;
					default:
						System.out.println("Wrong Entry \n");
						break;
					}
				} catch (StackException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
