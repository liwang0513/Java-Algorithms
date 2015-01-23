package shell_sort;

import java.util.Arrays;

public class ShellSort {

	private int[] theArray;

	private int arraySize;

	ShellSort(int arraySize) {

		this.arraySize = arraySize;

		theArray = new int[arraySize];

		generateRandomArray();

	}

	public void sort() {

		int inner, outer, temp;

		int interval = 1;

		while (interval <= arraySize / 3) {

			interval = interval * 3 + 1;

		}

		while (interval > 0) {

			for (outer = interval; outer < arraySize; outer++) {

				temp = theArray[outer];

				System.out.println("Copy " + theArray[outer] + " into temp");

				inner = outer;

				System.out.println("Checking if " + theArray[inner]
						+ " in index " + inner + " is bigger than " + temp);

				while (inner - interval >= 0 && theArray[inner - interval] > temp) {

					System.out.println("In while checking if " + theArray[inner-interval] + " is bigger than "
							+ temp);

					printHorzArray(inner, outer, interval);

					theArray[inner] = theArray[inner-interval];

					System.out.println(theArray[inner-interval] + " moved to index "
							+ inner);
					
					inner -= interval;

					System.out.println("Inner = " + inner);

					printHorzArray(inner, outer, interval);
				}

				theArray[inner] = temp;

				printHorzArray(inner, outer, interval);

			}
			
			interval = (interval - 1) / 3;

		}

	}

	public static void main(String[] args) {

		ShellSort theSort = new ShellSort(10);

		System.out.println(Arrays.toString(theSort.theArray));

		theSort.sort();

		System.out.println(Arrays.toString(theSort.theArray));

	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;

		}

	}

	public void printHorzArray(int i, int j, int h) {

		if (i == j)
			i = i - h;

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print("| " + theArray[n] + " ");

		}

		System.out.println("|");

		for (int n = 0; n < 51; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			int spacesBeforeFront = 5 * i + 1;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("I");

			// Number of spaces to put before the R

			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("O");

			System.out.println("\n");

		}

	}

}
