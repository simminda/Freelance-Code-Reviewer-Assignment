package isbn;

import java.util.Scanner;

public class ISBN {

	public static void main(String[] args) {
		
		// welcome message and user prompts		
		System.out.println("\n*** Welcome to ISBN Validator ***\n");
		
		// getting user input and validating
		while (true) {
			System.out.println("\nEnter a number to check if it is valid: \n");
			
			Boolean numInputValidation = false;
			
			while(numInputValidation == false) {
				Scanner input = new Scanner(System.in);
				String numInput = input.nextLine();
				
				if (numInput.length() == 13) {
					i13Validator(numInput);
					mainOrExit();
					numInputValidation = true;		
				}else if (numInput.length() == 10) {
					i10Validator(numInput);	
					mainOrExit();
					numInputValidation = true;
				} else {
					System.out.println("Please enter a 10 or 13 digit number: \n ");
				}
			}
		}	
	}
	
	
	// This method checks if a number is a valid isbn10 number	
	public static void i10Validator(String numInput) {
		// Declaring variables
		int sum=0;
		final int[] isbn10 = {10,9,8,7,6,5,4,3,2,1};
		
		// Creating int array of string length
		int [] numArr = new int[numInput.length()];
		
		// add string chars to int array 
		for (int i = 0; i < numInput.length(); i++) {
			numArr[i] = numInput.charAt(i) - '0';
		}
				
		// Multiply corresponding elements of arrays and add to sum
		for (int i = 0; i < numArr.length; i++) {
			int num1 = numArr[i];
			int num2 = isbn10[i];
			sum += num1 * num2;
		}
		
		// Return applicable output based on whether sum is divisible by 11
		if (sum % 11 == 0) {
			System.out.println("The number " + arrToStr(numArr) + " is a VALID ISBN-10 number.");
			converter(numInput);
		} else {
			System.out.println("The number " + arrToStr(numArr) + " is NOT a valid ISBN-10 or ISBN-13 number.");
		}
	}
	
	
	// This method checks if a number is a valid isbn10 number	
	public static void i13Validator(String numInput) {
		// Declaring variables
		int sum=0;
		final int[] isbn13 = {1,3,1,3,1,3,1,3,1,3,1,3,1};
		
		// Creating int array of string length
		int [] numArr = new int[numInput.length()];
		
		// add string chars to int array 
		for (int i = 0; i < numInput.length(); i++) {
			numArr[i] = numInput.charAt(i) - '0';
		}

		// Multiply corresponding elements of arrays
		for (int i = 0; i < numArr.length; i++) {
			int num1 = numArr[i];
			int num2 = isbn13[i];
			sum += num1 * num2;
		}
		
		// Return applicable output based on whether sum is divisible by 10
		if (sum % 10 == 0) {
			System.out.println("The number " + arrToStr(numArr) + " is a valid ISBN-13 number.\n");
		} else {
			System.out.println("The number " + arrToStr(numArr) + " is NOT a valid ISBN-13 number.\n");
		}
	}
	
	
	// This method converts a valid isbn10 number to isbn13	
	public static void converter(String numInput) {
		String expanded = "978" + numInput;
		
		// Creating int array of string length
		int [] numArr = new int[expanded.length()];

		// add string chars to int array 
		for (int i = 0; i < expanded.length(); i++) {
			numArr[i] = expanded.charAt(i) - '0';
		}
		
		// Changing last number
		numArr[12] = numArr[12] + 1;
		
		// Convert back to string
		//arrToStr(numArr);
		
		System.out.println("The number " + numInput + " converted to ISBN-13: " + arrToStr(numArr));
	}

	
	// This method takes an int array and returns a string
	public static String arrToStr(int[] numArr) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < numArr.length; i++) {
		    stringBuilder.append(Integer.valueOf(numArr[i]));
		}
		String joinedString = stringBuilder.toString();
		
		return joinedString;
	}
	
	
	// this method allows user to exit or go back to the main menu after each use case
	private static void mainOrExit() {
		System.out.println("\n\nEnter any key to continue or enter 'e' to exit: ");
		Scanner scan = new Scanner(System.in);
		char choice = scan.next().charAt(0);
		if (choice == 'e') {
			System.out.println("\nThank You!!!");
			System.exit(0);	
		}
	}

	
}
	