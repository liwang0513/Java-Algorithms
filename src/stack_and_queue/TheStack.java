package stack_and_queue;

import java.util.Arrays;

public class TheStack {

	private String[] stackArray;
	
	private int stackSize;
	
	private int topOfStack = -1;
	
	TheStack(int size) {
		
		stackSize = size;
		
		stackArray = new String[size];
		
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input) {
		
		if (topOfStack + 1 < stackSize) {
			
			topOfStack++;	
			
			stackArray[topOfStack] = input;
			
		} else System.out.println("Sorry But the stack is full.");
		
		displayTheStack();
		
		System.out.println("PUSH "+ input + " Was Added to the Stack.");
		
	}
	
	public void displayTheStack() {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < stackSize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < stackSize; n++) {

			if (stackArray[n].equals("-1"))
				System.out.print("|     ");

			else
				System.out.print(String.format("| %2s " + " ", stackArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

	}
	
	public String pop() {
		
		if (topOfStack >= 0) {
			
			displayTheStack();
			
			System.out.println("POP "+ stackArray[topOfStack] + " Was Removed From the Stack.");
			
			stackArray[topOfStack] = "-1";
			
			return stackArray[topOfStack--];
			
		} else {
			
			displayTheStack();
			
			System.out.println("Sorry But the Stack is Empty.");
			
			return "-1";
			
		}
	}
	
	public String peek() {
		
		displayTheStack();
		
		System.out.println("PEEK "+ stackArray[topOfStack] + " Is at the Top of the Stack.");
		
		return stackArray[topOfStack];
	}
	
	public void pushMany(String multipleValues) {
		
		String[] tempString = multipleValues.split(" ");
		
		for (String s : tempString) {
			
			push(s);
			
		}
	}
	
	public void popAll() {
		
		for (int i=topOfStack; i>=0; i--) {
			
			pop();
		}
	}
	
	public static void main(String[] args) {
		
		TheStack theStack = new TheStack(10);
		
		theStack.push("10");
		
		theStack.push("15");
		
		theStack.peek();
		
		theStack.pop();
		
		theStack.pushMany("20 12 43 22");
		
		theStack.popAll();
	}
}
