package com.eclipse.ColinMartinez;
import java.util.Random;  // Imports Random Class
import java.util.Scanner; // Imports Scanner Class

/** Takes user input and compares it against a randomly
 * generated number in a game of Rock, Paper, Scissors
 * @author Colin Martinez
 */

public class RockPaperScissorsGameCM {

	public static void main(String[] args) {
		//Initialized Variables
		int compChoice = computerChoice(); // Gets Comp. Choice
		int userChoice = userChoice();     // Gets User Choice
		
		//Displays Computer's Choice to User
		compDisplay(compChoice);
		
		//Runs Through Control Structures
		compare(userChoice, compChoice);
		
		//Play Again Prompt
		Scanner userInput = new Scanner(System.in);
		System.out.println("Play Again?");
		System.out.println("y=Yes, n=No");
		String playAgain = userInput.nextLine();
		//Play Again Loop Structure
		if (playAgain.equals("y"))
			do{
				compChoice = computerChoice();     // 
				userChoice = userChoice();         //This is
				compDisplay(compChoice);           //just
				compare(userChoice, compChoice);   //duplicate code
				System.out.println("Play Again?"); //from above
				System.out.println("y=Yes, n=No"); //
				playAgain = userInput.nextLine();  //		
			}
			while (playAgain.equals("y"));
		else
			System.exit(0);
			
	}
	
	/**The computerChoice method generates a random number
	 * for the Computer.
	 * @return Returns the Computer's number
	 */
	public static int computerChoice(){
		//Random Instance
		Random rPC = new Random();
		//Initialized Variables
		int computerNumber = rPC.nextInt(3);
		//Return Value
		return computerNumber;
	}
	
	/**The comDisplay method displays the computer's choice
	 * to the user.
	 * @param compNum The Computer's number
	 */
	public static void compDisplay(int compNum){
		//Switch Structure
		switch (compNum){
			case 0:
				System.out.println("The Computer chose Rock.");
				break;
			case 1:
				System.out.println("The Computer chose Paper.");
				break;
			case 2:
				System.out.println("The Computer chose Scissors.");
				break;
			}
		}
	
	/**The userChoice method prompts the user to pick
	 * between 0,1,and 2.
	 * @return Returns the User's Number
	 */
	public static int userChoice(){
		//Scanner Instance
		Scanner userInput = new Scanner(System.in);
		//Declared Variable
		int pick;
		//Prompt for User Input
		System.out.println("Let's play Rock, Paper, Scissors!");
		System.out.println("0 = Rock, 1 = Paper, 2 = Scissors: ");
		//Initialized Variable
		pick = userInput.nextInt();
		//Return Value
		return pick;
	}
	
	/**The compare method uses control structures
	 * to evaluate the User and Computer's choices.
	 * @param num1 The User's Choice
	 * @param num2 The Computer's Choice
	 */
	public static void compare(int num1, int num2){
		//Class Instances
		Scanner userInput = new Scanner(System.in);
		Random rPC = new Random();
		
		//Loop Structure
		while (num1 == num2){
			System.out.println("TIE!! Try again!");
			System.out.println("0 = Rock, 1 = Paper, 2 = Scissors: ");
			num1 = userInput.nextInt();
			num2 = rPC.nextInt(2);
			compDisplay(num2);
		}
		
		//Switch Structure
		switch (num1){
			case 0:
				if (num1 == 0 && num2 == 1)
					System.out.println("Paper covers Rock! You lose!");
				else if (num1 == 0 && num2 == 2)
					System.out.println("Rock smashes Scissors! You win!");
				break;
			case 1:
				if (num1 == 1 && num2 == 0)
					System.out.println("Paper covers Rock! You win!");
				else if (num1 == 1 && num2 == 2)
					System.out.println("Scissors cuts Paper! You Lose!");
				break;
			case 2:
				if (num1 == 2 && num2 == 0)
					System.out.println("Rock smashes Scissors! You lose!");
				else if (num1 == 2 && num2 == 1)
					System.out.println("Scissors cuts Paper! You win!");
				break;
			}
	}
}
