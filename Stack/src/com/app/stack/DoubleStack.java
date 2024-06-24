/*

The DoubleStack class is used to implement two separate stacks within a single array. 
This approach can be beneficial in certain scenarios due to its efficient use of space and memory.

Stack 1 grows from the beginning of the array towards the end.
 
Stack 2 grows from the end of the array towards the beginning.

Top Pointers: top1 points to the last element of Stack 1, and top2 points to the last element of Stack 2.

Full Condition: The stacks are full when top1 + 1 == top2.

*/

package com.app.stack;

import com.app.stack_exception.StackException;

public class DoubleStack {
	private int top1;
	private int top2;
	private int size;
	private int[] arr;

	public DoubleStack(int size) {
		this.size = size;
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	public boolean isFull() {
		return (top1 + 1) == top2;
	}

	public boolean isEmpty1() {
		return top1 == -1;
	}

	public boolean isEmpty2() {
		return top2 == size;
	}

	public boolean push1(int data) throws StackException {
		if (isFull()) {
			throw new StackException("Stack is Full!");
		}
		arr[++top1] = data;
		return true;
	}

	public boolean push2(int data) throws StackException {
		if (isFull()) {
			throw new StackException("Stack is Full!");
		}
		arr[--top2] = data;
		return true;
	}

	public int pop1() throws StackException {
		if (isEmpty1()) {
			throw new StackException("Stack is Empty!");
		}
		return arr[top1--];
	}

	public int pop2() throws StackException {
		if (isEmpty2()) {
			throw new StackException("Stack is Empty!");
		}
		return arr[top2++];
	}
	
	public void display() {
        System.out.println("Stack 1 elements (top to bottom):");
        for (int i = top1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Stack 2 elements (top to bottom):");
        for (int i = top2; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Complete Array:");
        for (int i = 0; i < size; i++) {
            if (i <= top1 || i >= top2) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print("[ ] ");
            }
        }
        System.out.println();
    }

}
