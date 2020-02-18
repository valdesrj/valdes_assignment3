
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn multiplication.
//
// CAI2 produces two random, positive one-digit integers; checks the
// students answer of the multiplication and either terminates the program
// with a correct response or repeatedly asks the same question.
//
// Various comments are displayed for the correct and incorrect answers

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
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
	
	// prints one of four responses when a student enters the correct answer
	public static String displayCorrectResponse() {
		// generate random numbers from 0 to 3 inclusive to represent the
		// response, offset by 1 and select the appropriate response
	    switch(1 + randomNumbers.nextInt(4)) {
	        case 1:
	        	return "Very good!\n";
	        case 2:
	        	return "Excellent!\n";
	        case 3:
	        	return "Nice work!\n";
	        case 4:
	        	return "Keep up the good work!\n";
	        default:
	        	return "Very good!\n";
	    }
	}
	
	// prints one of four responses when a student enters an incorrect answer
	public static String displayIncorrectResponse() {
		// generate random numbers from 0 to 3 inclusive to represent the
		// response, offset by 1 and select the appropriate response
	    switch(1 + randomNumbers.nextInt(4)) {
	        case 1:
	        	return "No. Please try again.\n";
	        case 2:
	        	return "Wrong. Try once more.\n";
	        case 3:
	        	return "Don't give up!\n";
	        case 4:
	        	return "No. Keep trying\n";
	        default:
	        	return "No. Please try again.\n";
	    }
	}
}
