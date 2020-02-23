
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
 	private int totalQuestions = 10;
 
	public static void main(String[] args)
	{
	    // start the quiz
		CAI1 q = new CAI1();
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
		
	    // correct response was provided and program terminates
	    System.out.printf("%s", displayCorrectResponse());
	}
	
	// generates a random number from 0 to range-1 inclusive
	public int generateRands(int range) {
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
	
	// prints the response when a student enters the correct answer
	public String displayCorrectResponse() {
		return "Very good!\n";
	}
	
	// prints the response when a student enters an incorrect answer
	public String displayIncorrectResponse() {
		return "No. Please try again.\n";
	}
}
