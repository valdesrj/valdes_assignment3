
// Using Computer-Assisted Instruction (CAI) help elementary school
// students learn multiplication.
//
// This CAI asks the student for the difficulty level of the questions.
// The student is asked 10 different multiplication questions where they
// are given one chance at answering each question. The CAI then counts
// the number of correct and incorrect responses typed by the student.
// After the CAI asks 10 questions (and the student types 10 answers), it
// calculates the percentage that are correct and displays an appropriate
// message. The CAI then resets so another student can try the questions.

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CAI4 {
    // randomNumbers object will produce secure random numbers
    private static final SecureRandom randomNumbers = new SecureRandom();
	
    // input object will get input from the console
    private static Scanner input = new Scanner(System.in);
    
    // class fields
  	private int totalQuestions = 10;
 
    public static void main(String[] args)
	{
	    // start the quiz
    	CAI4 q = new CAI4();
		q.quiz();
	}
	
	// the program logic
    public void quiz() {
    	// repeat the set of totalQuestions as long as students are interested
    	do {
    		// initialize the variables
    		int correct = 0;
        	int incorrect = 0;
        	int currentQuestion = 0;
        	
    		// ask the student for the difficulty level of the current quiz
			int difficulty = readDifficulty();
    		
    		// ask totalQuestions number of different mathematics questions  		
    		for (int i = 0; i < totalQuestions; i++)
    		{
    			currentQuestion++;
    			
    			// generate two random, positive integers based on difficulty
    		    int num1 = randomNumbers.nextInt(generateQuestionArgument(difficulty));
    		    int num2 = randomNumbers.nextInt(generateQuestionArgument(difficulty));
    			
    			// ask the student the mathematics question
    			askQuestion(currentQuestion, num1, num2);
    			
			    // check if response was correct or incorrect and increase the
			    // appropriate counter
			    if (isAnswerCorrect(num1, num2, readResponse()))
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
    		displayCompletionMessage(correct, incorrect);
    	// ask student for another go
    	} while (resetQuiz());
	}
    
    // read the difficulty level from the student as an integer 1, 2, 3, or 4
    // convert input to range of 0-9, 0-99, 0-999, or 0-9999, respectively
    public int readDifficulty() {
    	int difficulty;
    	System.out.println("Difficulty Levels:");
    	System.out.println("1. Numbers in range 0-9");
    	System.out.println("2. Numbers in range 0-99");
    	System.out.println("3. Numbers in range 0-999");
    	System.out.println("4. Numbers in range 0-9999");
    	do {
    		System.out.printf("Please enter a diffuculty level (1, 2, 3, or 4): ");
    		difficulty = input.nextInt();
    	} while (difficulty > 4 || difficulty < 1);
    	input.nextLine();
    	return difficulty;
    }
    
    
    // displays the completion message of the student's score and appropriate
    // response
    public void displayCompletionMessage(int correct, int incorrect) {
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
    public boolean resetQuiz() {
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
    
    // generates the argument based on the difficulty level 
	public int generateQuestionArgument(int difficulty) {
		// set the random number range
    	switch(difficulty) {
    	    case 1:
    	    	return 9;
    	    case 2:
    	    	return 99;
    	    case 3:
    	    	return 999;
    	    case 4:
    	    	return 9999;
    	    default:
    	    	return 9;
    	}
	}
	
	// prints the problem to the screen
    public void askQuestion(int currentQuestion, int num1, int num2) {
    	System.out.printf("%d. How much is %d times %d? ", currentQuestion,
    			num1, num2);
	}
	
	// reads the answer from the student
    public int readResponse() {
    	int answer = 0;
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
    public boolean isAnswerCorrect(int num1, int num2, int answer) {
		return num1 * num2 == answer;
	}
	
	// prints one of four responses when a student enters the correct answer
    public String displayCorrectResponse() {
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
    public String displayIncorrectResponse() {
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
