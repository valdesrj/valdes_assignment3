
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn multiplication.
//
// CAI1 produces two random, positive one-digit integers; checks the
// students answer of the multiplication and either terminates the program
// with a correct response or repeatedly asks the same question.

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	// randomNumbers object will produce secure random numbers
    private static final SecureRandom randomNumbers = new SecureRandom();
	
    // input object will get input from the console
 	private static Scanner input = new Scanner(System.in);
 
	public static void main(String[] args)
	{
	    // start the quiz
		quiz();
	}
	
	// the program logic
	public static void quiz() {
		// generate random numbers from 0 to 9 inclusive
	    int a = randomNumbers.nextInt(10);
	    int b = randomNumbers.nextInt(10);
	    
	    // prompt the user with the multiplication question
	    askQuestion(a, b);
	    	    
		// continue asking the user until the correct response is provided
	    while (!isAnswerCorrect(a, b, readResponse())) {
	    	System.out.printf("%s", displayIncorrectResponse());
	    	askQuestion(a,b);
	    }
		
	    // correct answer was provided and program terminates
	    System.out.printf("%s", displayCorrectResponse());
	}
	
	// prints the problem to the screen
	public static void askQuestion(int a, int b) {
		System.out.printf("How much is %d times %d? ", a, b);
	}
	
	// reads the answer from the student
	public static int readResponse() {
		int answer = input.nextInt();
		input.nextLine();
		return answer;
	}
	
	// checks the student answer to the correct answer
	public static boolean isAnswerCorrect(int a, int b, int answer) {
		return a * b == answer;
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
