
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn arithmetic.
//
// This CAI asks the student for the difficulty level of the questions.
// It then asks for the type of arithmetic problem: addition, subtraction,
// multiplication, division or a mixture of all.
// The student is asked 10 different arithmetic questions where they
// are given one chance at answering each question. The CAI then counts
// the number of correct and incorrect responses typed by the student.
// After the CAI asks 10 questions (and the student types 10 answers), it
// calculates the percentage that are correct and displays an appropriate
// message. The CAI then resets so another student can try the questions.

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CAI5 {
    // randomNumbers object will produce secure random numbers
    private static final SecureRandom randomNumbers = new SecureRandom();
	
    // input object will get input from the console
    private static Scanner input = new Scanner(System.in);
    
    // class fields
    private static int correct = 0;
    private static int currentQuestion = 0;
    private static int incorrect = 0;
  	private static double num1;
  	private static double num2;
  	private static int rangeRands;
  	private static int totalQuestions = 10;
  	private static int difficulty;
  	private static int problemType;
  	private static char mathSymbol;
  	private static boolean mixMaths;
 
    public static void main(String[] args)
	{
	    // start the quiz
		quiz();
	}
	
	// the program logic
    public static void quiz() {
    	// repeat the set of totalQuestions as long as students are interested
    	do {
    		// ask the student for the difficulty level of the current quiz
			readDifficulty();
			
			// ask the student for the type of arithmetic problem to study
			readProblemType();
    		
    		// loop for totalQuestions times  		
    		for (int i = 0; i < totalQuestions; i++)
    		{
    			currentQuestion++;
    			
    			// ask the student the mathematics question
    			askQuestion();
    			
			    // check if response was correct or incorrect and increase the
			    // appropriate counter
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
    		}
    		// display the percent correct and appropriate response
    		displayCompletionMessage();
    	// ask student for another go
    	} while (resetQuiz());
	}
    
    // read the problem type: 1 for addition, 2 for subtraction,
    // 3 for multiplication, 4 for division, and 5 for a random mixture.
    // convert input to operator
    public static void readProblemType() {
    	problemType = 2;
    	System.out.println("\nArithmetic Problem Type:");
    	System.out.println("1. Addition");
    	System.out.println("2. Multiplication");
    	System.out.println("3. Subtraction");
    	System.out.println("4. Division");
    	System.out.println("5. Random Mixture of Arithmetic");
    	try {   		
	    	do {
	    		System.out.printf("Please enter a problem type (1, 2, 3, 4, or 5): ");
	    		problemType = input.nextInt();
	    	} while (problemType > 5 || problemType < 1);
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Exception caught: expecting integer.");
    		System.out.println("Problem Type set to Multiplication");
    	}
    	input.nextLine();
    	System.out.println();
    	
    	// set the random problem type to true
    	if (problemType == 5)
    	{
    		mixMaths = true;
    	}
    }
    
    // read the difficulty level from the student as an integer 1, 2, 3, or 4
    // convert input to range of 0-9, 0-99, 0-999, or 0-9999, respectively
    public static void readDifficulty() {
    	difficulty = 1;
    	System.out.println("Difficulty Levels:");
    	System.out.println("1. Numbers in range 0-9");
    	System.out.println("2. Numbers in range 0-99");
    	System.out.println("3. Numbers in range 0-999");
    	System.out.println("4. Numbers in range 0-9999");
    	try {
	    	do {
	    		System.out.printf("Please enter a diffuculty level (1, 2, 3, or 4): ");
	    		difficulty = input.nextInt();
	    	} while (difficulty > 4 || difficulty < 1);
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Exception caught: expecting integer.");
    		System.out.println("Difficulty Level set to 1.");
    	}
    	input.nextLine();
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
    }
    
    // prompts the student whether they would like to continue or exit the quiz
    public static boolean resetQuiz() {
    	System.out.printf("%n%n%s", 
    		"Would you like to continue with a new problem set? (y/n) ");
    	String res = input.nextLine();
    	if (res.toLowerCase().equals("y")) 
    	{
    		correct = 0;
        	incorrect = 0;
        	currentQuestion = 0;
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    // generates a random number from 0 to rangeRands inclusive
	public static double generateQuestionArgument() {
		// set the random number range
    	switch(difficulty) {
    	    case 1:
    	    	rangeRands = 9;
    	    	break;
    	    case 2:
    	    	rangeRands = 99;
    	    	break;
    	    case 3:
    	    	rangeRands = 999;
    	    	break;
    	    case 4:
    	    	rangeRands = 9999;
    	    	break;
    	    default:
    	    	rangeRands = 9;
    	}
		return randomNumbers.nextInt(rangeRands + 1);
	}
	
	// prints the problem to the screen
    public static void askQuestion() {
    	// if problemType is a random mixture, generate a random arithmetic
    	// problem
    	if (mixMaths)
    	{
    		problemType = 1 + randomNumbers.nextInt(4);
    	}
    	
    	// set the problem type arithmetic symbol
    	switch(problemType) {
		    case 1:
		    	mathSymbol = '+';
		    	break;
		    case 2:
		    	mathSymbol = '*';
		    	break;
		    case 3:
		    	mathSymbol = '-';
		    	break;
		    case 4:
		    	mathSymbol = '/';
		    	break;
		    default:
		    	mathSymbol = '*';
		}
    	
    	// generate a random, positive integer
	    num1 = generateQuestionArgument();
	    
	    // if the problem type is division, generate a random positive
	    // non-zero integer
	    do {
	    	num2 = generateQuestionArgument(); 	
	    } while (problemType == 4 && num2 == 0);
	    
    	System.out.printf("%d. How much is %.0f %c %.0f? ", currentQuestion,
    		               num1, mathSymbol, num2);
	}
	
	// reads the answer from the student
    public static double readResponse() {
    	double answer = 0;
    	try {
		    answer = input.nextDouble();
    	}
    	catch (InputMismatchException e) {
    		System.out.println("Exception caught: expecting double.");
    	}
    	input.nextLine();
    	return answer;
	}
	
	// compares the student answer to the correct answer and returns
	// 0 for false and 1 for true
    public static boolean isAnswerCorrect(double answer) {
    	double eps = 0.000001;
    	switch (problemType)
    	{
    	    case 1:
    	    	return Math.abs(num1 + num2 - answer) < eps;
    	    case 2:
    	    	return Math.abs(num1 * num2 - answer) < eps;
    	    case 3:
    	    	return Math.abs(num1 - num2 - answer) < eps;
    	    case 4:
    	    	return Math.abs(num1 / num2 - answer) < eps;
    	    default:
    	    	return Math.abs(num1 * num2 - answer) < eps;
    	}
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
