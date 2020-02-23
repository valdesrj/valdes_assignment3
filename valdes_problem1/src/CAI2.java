
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn multiplication.
//
// This CAI produces two random, positive one-digit integers; checks the
// student's answer of the multiplication question and either terminates the 
// program for a correct response or repeatedly asks the same question for
// an incorrect response.
//
// This CAI extends both the correct and incorrect responses with 
// 3 additional phrases for each.

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
    // randomNumbers object will produce secure random numbers
    private static final SecureRandom randomNumbers = new SecureRandom();
	
    // input object will get input from the console
    private static Scanner input = new Scanner(System.in);
    
    // class fields
    private int totalQuestions = 10;
 
    public static void main(String[] args)
	{
	    // start the quiz
		CAI2 q = new CAI2();
    	q.quiz();
	}
	
	// the program logic
    public void quiz() {
		// generate two random, positive one-digit integers from 0 to 9 inclusive
    	int num1 = generateRands(totalQuestions);
    	int num2 = generateRands(totalQuestions);
	    
	    // prompt the user with the question
	    askQuestion(num1, num2);
	    	    
		// continue asking the user until the correct response is provided
	    while (!isAnswerCorrect(num1, num2, readResponse())) {
	    	System.out.printf("%s", displayIncorrectResponse());
	    	askQuestion(num1, num2);
	    }
		
	    // correct answer was provided and program terminates
	    System.out.printf("%s", displayCorrectResponse());
	}
    
	// generates a random number from 0 to range-1 inclusive
	public static int generateRands(int range) {
		return randomNumbers.nextInt(range);
	}
	
	// prints the problem to the screen
    public void askQuestion(int num1, int num2) {
		System.out.printf("How much is %d times %d? ", num1, num2);
	}
	
	// reads the answer from the student
    public int readResponse() {
		int answer = input.nextInt();
		input.nextLine();
		return answer;
	}
	
	// compares the student answer to the correct answer and returns
	// 0 for false and 1 for true
    public boolean isAnswerCorrect(int num1, int num2, int answer) {
		return num1 * num2 == answer;
	}
	
	// prints one of four responses when a student enters the correct answer
    public static String displayCorrectResponse() {
		// generate random numbers from 0 to 3 inclusive to represent the
		// response, offset by 1 and select the appropriate response
	    switch(1 + generateRands(4)) {
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
    public String displayIncorrectResponse() {
		// generate random numbers from 0 to 3 inclusive to represent the
		// response, offset by 1 and select the appropriate response
	    switch(1 + generateRands(4)) {
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
