
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn multiplication.
//
// This CAI produces two random, positive one-digit integers; checks the
// student's answer of the multiplication question and either terminates the 
// program for a correct response or repeatedly asks the same question for
// an incorrect response.

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	// randomNumbers object will produce secure random numbers
    private static final SecureRandom randomNumbers = new SecureRandom();
	
    // input object will get input from the console
 	private static Scanner input = new Scanner(System.in);
 	
 	// class fields
 	private static int num1;
 	private static int num2;
 	private static int answer;
 
	public static void main(String[] args)
	{
	    // start the quiz
		quiz();
	}
	
	// the program logic
	public static void quiz() {
        // generate two random, positive one-digit integers from 0 to 9 inclusive
		num1 = generateRands(10);
		num2 = generateRands(10);
	    
	    // prompt the user with the question
	    askQuestion();
	    	    
		// continue asking the user until the correct response is provided
	    while (!isAnswerCorrect(readResponse())) {
	    	System.out.printf("%s", displayIncorrectResponse());
	    	askQuestion();
	    }
		
	    // correct response was provided and program terminates
	    System.out.printf("%s", displayCorrectResponse());
	}
	
	// generates a random number from 0 to range-1 inclusive
	public static int generateRands(int range) {
		return randomNumbers.nextInt(range);
	}
	
	// prints the problem to the screen
	public static void askQuestion() {
		System.out.printf("How much is %d times %d? ", num1, num2);
	}
	
	// reads the answer from the student
	public static int readResponse() {
		answer = input.nextInt();
		input.nextLine();
		return answer;
	}
	
	// compares the student answer to the correct answer and returns
	// 0 for false and 1 for true
	public static boolean isAnswerCorrect(int answer) {
		return num1 * num2 == answer;
	}
	
	// prints the response when a student enters the correct answer
	public static String displayCorrectResponse() {
		return "Very good!\n";
	}
	
	// prints the response when a student enters an incorrect answer
	public static String displayIncorrectResponse() {
		return "No. Please try again.\n";
	}
}
