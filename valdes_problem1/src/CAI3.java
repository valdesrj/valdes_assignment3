
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn multiplication.
//
// This CAI uses the question-generation method askQuestion() to ask the 
// student 10 different multiplication questions. The student is given one
// chance at answering each question. The CAI then counts the number of correct
// and incorrect responses typed by the student.
// After the CAI asks 10 questions (and the student types 10 answers), it
// calculates the percentage that are correct and displays an appropriate
// message. The CAI then resets so another student can try the questions.

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CAI3 {
    // randomNumbers object will produce secure random numbers
    private static final SecureRandom randomNumbers = new SecureRandom();
	
    // input object will get input from the console
    private static Scanner input = new Scanner(System.in);
    
    // class fields
  	private static ArrayList<Integer> num1 = new ArrayList<Integer>();
  	private static ArrayList<Integer> num2 = new ArrayList<Integer>();
  	private static int answer;
  	private static int totalQuestions = 10;
  	private static int currentQuestion = 0;
  	private static int correct = 0;
  	private static int incorrect = 0;
 
    public static void main(String[] args)
	{
	    // start the quiz
		quiz();
	}
	
	// the program logic
    public static void quiz() {
    	// repeat the set of numQuestions as long as students are interested
    	do {
    		// ask numQuestions number of different questions
    		System.out.println("Please answer the following questions:");
    		askQuestion();
    		
    		for (int i = 0; i < 10; i++)
    		{
			    // check if response was correct or incorrect and increase the
			    // appropriate counter
    			System.out.printf("%nAnswer %d. is ", currentQuestion + 1);
			    if (isAnswerCorrect(readResponse()))
			    {
			    	// correct answer was provided: display random response
			    	// and increment counter correct
				    System.out.printf("%s", displayCorrectResponse());
				    correct++;
			    }
			    else
			    {
			    	// incorrect answer was provided: display random response
			    	// and increment counter incorrect
			    	System.out.printf("%s", displayIncorrectResponse());
			    	incorrect++;
			    }
			    currentQuestion++; // go to next question in ArrayList
    		}
    		// display the percent correct and appropriate response
    		displayCompletionMessage();
    	// ask user for another go
    	} while (resetQuiz());
	}
    
    // displays the completion message of the student's score and appropriate
    // response
    public static void displayCompletionMessage() {
    	double percCorrect = (double) correct / (correct +  incorrect) * 100.;
    	if (percCorrect < 75.0 )
    	{
    		System.out.printf("%s %.1f%s%n%s", "Your percent correct is ", 
    			percCorrect, "%", "Please ask your teacher for extra help.");
    	}
    	else
    	{
    		System.out.printf("%s %.1f%s%n%s", "Your percent correct is ", 
        		percCorrect, "%", 
        		"Congratulations, you are ready to go to the next level!");
    	}
    	correct = 0;
    	incorrect = 0;
    	currentQuestion = 0;
    }
    
    // prompts the user whether they would like to continue or exit the quiz
    public static boolean resetQuiz() {
    	System.out.printf("%n%n%s", 
    		"Would you like to continue with a new problem set? (y/n) ");
    	String res = input.nextLine();
    	if (res.toLowerCase().equals("y")) 
    	{    		
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    // generates a random number from 0 to range-1 inclusive
	public static int generateRands(int range) {
		return randomNumbers.nextInt(range);
	}
	
	// prints the problem(s) to the screen
    public static void askQuestion() {
    	for (int i = 0; i < totalQuestions; i++)
    	{
    		// generate two random, positive one-digit integers from 0 to 9
			// inclusive
	    	num1.add(generateRands(10));
	    	num2.add(generateRands(10));
    		System.out.printf("%d. How much is %d times %d?%n", i+1, 
    			num1.get(i), num2.get(i));
    	}
	}
	
	// reads the answer from the student
    public static int readResponse() {
    	try {
		    answer = input.nextInt();
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Exception caught: expecting integer");
    	}
    	input.nextLine();
    	return answer;
	}
	
	// compares the student answer to the correct answer and returns
	// 0 for false and 1 for true
    public static boolean isAnswerCorrect(int answer) {
		return num1.get(currentQuestion) * num2.get(currentQuestion) == answer;
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
    public static String displayIncorrectResponse() {
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
