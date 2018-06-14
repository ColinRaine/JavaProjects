package com.eclipse.palindromes;
import java.util.*;

public class PalindromeDemo {
	
	public static void main(String[] args)
	{
	// Variable(s)
	String testStrings = "";
	// Create a Scanner object to collect user input.
	Scanner userInput = new Scanner(System.in);

	// Test the string.
	// Use an if statement to call isPalindrome(String)
	// if it's true then print " is a palindrome."
	// if it's false then print "is not a palindrome."
	System.out.println( "Enter a WORD to check whether it is or is not a palindrome: ");
	testStrings = userInput.nextLine();
	System.out.println();
	System.out.println( "Your word is " + "\"" + testStrings + "\"." );
	if ( isPalindrome(testStrings) == true )
			System.out.println( "\"" + testStrings + "\"" + " is a palindrome.");
	else
		System.out.println( "\"" + testStrings + "\"" + " is not a palindrome.");
	}
	
	/**
	The isPalindrome method determines whether a string
	is a palindrome.
	@param str The string to test.
	@return This method returns true if str contains a
	palindrome. It returns false otherwise.
	*/
	//isPalindrome(String) the recursive method that takes a string and returns boolean
	//{
	// set boolean variable to false
	// if the string length <= 1
	// then boolean is set to true
	// else if the charAt(0) is equal to the last character
	// set boolean variable equal to isPalindrome(the new substring (1, str.length()-1) 
	// return boolean variable
	//}
	public static boolean isPalindrome( String str ){
		boolean bool = false;
		if ( str.length() <= 1 )
			bool = true;
		else if ( str.charAt(0) == str.charAt(str.length() - 1) )
			bool = isPalindrome(str.substring(1, str.length() -1 ));
		return bool;
	}
}

