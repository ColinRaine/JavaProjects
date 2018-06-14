package stacksAndQueues.ColinMartinez;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StacksAndQueues {

	public static void main(String[] args) throws IOException {
		String fileName;								// String variable to hold filename
		int userSelection;								// int variable to hold the user's selection
		
		Scanner userInput = new Scanner(System.in);		// Scanner object for user input
		
		System.out.println("Please input a .txt file: ");
		fileName = userInput.nextLine();				//assigns user input data to filename
		
		System.out.println("Opening file...");
		File currentFile = new File(fileName);			// opens user file
		Scanner inputFile = new Scanner(currentFile);	// to read from
		
		System.out.println("Please select the operation you would like performed: " +
							"\n1. Reverse" + "\n2. Convert" + "\n3. Compare");
		userSelection = userInput.nextInt();			// assigns user input to userSelection
		
		//********************//
		//	Switch Statement  // Takes userSelection and switches 
		//********************// to the appropriate case.
		switch (userSelection)
		{
			case 1:
				Stack<Character> stack = new Stack<Character>();	// Stack character object
				
															 //***************************************************************************************
				while (inputFile.hasNext())					 // Took a second to figure this out									
					{										 // Okay, so while there's a token in input we'll push a 
						stack.push('\n');				     // new line character on the stack. This will preserve the lines from the txt file.
						String s1 = inputFile.nextLine();	 // we'll assign a line of input (excluding the newline char) to a String variable. 													
						for(char ch : s1.toCharArray())		 // We'll then iterate over that String	and assign each element to a character variable. 
						{									 // That element is then pushed on the stack. Once that string has been iterated
								stack.push(ch);				 // over we jump out of the for loop.
						}									 // The process continues until there are no longer any tokens in the input.															
					}										 //****************************************************************************************
															 
				PrintWriter outputFile1 = new PrintWriter("reverse.txt");  // opens a new file to be written to
				
				while (!stack.isEmpty())				// so long as the stack isn't empty
					outputFile1.print(stack.pop());     // it will be popped and each value written to the new file
				
				outputFile1.close();
				inputFile.close();		
										
				System.out.println("reverse.txt created");
				break;
			case 2:
				Queue<Character> queue = new LinkedList<Character>();	//Queue object
					
				while (inputFile.hasNext())							//*************************************
				{													// The same thing as the case 1
					String s2 = inputFile.nextLine();               // while statement with the only 
					for(char ch : s2.toUpperCase().toCharArray())   // major difference being converting
					{												// the text to upper case and putting
						queue.add(ch);								// the new line character statement
					}												// below the for loop
					queue.add('\n');								//*************************************
				}												    
					 				
				PrintWriter outputFile2 = new PrintWriter("convert.txt");	// opens new file to be written to
				
				while (!queue.isEmpty())												 
				{											 							
					outputFile2.print(queue.poll()); // While statement that removes from the head of the queue																	 																	
				}									 // until empty and prints to the output file
				
				outputFile2.close();
				inputFile.close();
					
				System.out.println("convert.txt created");
				break;
			case 3:	
				String case3FileName;	// String variable to store the new filename
				Queue<Character> firstFile = new LinkedList<Character>();	// Queue obj. for first file
				Queue<Character> secondFile = new LinkedList<Character>();  // Queue obj. second file
			
				System.out.println("Please enter another .txt file: ");	
				userInput.nextLine();									// assigning the user input 
				case3FileName = userInput.nextLine();					// to the file name
				
				File case3File = new File(case3FileName);			// opens the new file
				Scanner case3InputFile = new Scanner(case3File);	// to read from
				
				while (inputFile.hasNext())							//*******************************
				{													// The same while statement
					String s3 = inputFile.nextLine();				// as case 2. Difference being
					String s4 = case3InputFile.nextLine();			// no conversion to uppercase,
					for (char ch : s3.toCharArray())                // two string variables, and
					{  												// two for loops accomplishing
						firstFile.add(ch);							// the same thing for each file
					}												//*******************************
					firstFile.add('\n');
					for (char ch2 : s4.toCharArray())				
					{						
						secondFile.add(ch2);			
					}
					secondFile.add('\n');
				}													
																				
				if (firstFile.equals(secondFile))						// if the two queues match 
					System.out.println("The two lists match!"); 		// this statement will print
				else													// else if they don't match
					System.out.println("The two lists do not match!");	// this statement will print
				
				case3InputFile.close(); 
				inputFile.close();
								
				break;
			default:
				System.out.println("User Selection is invalid. Closing Program.");	//If the user selection does not match any cases it will default here.
		}
		userInput.close();
		System.out.print("Program complete.");
	}

}
