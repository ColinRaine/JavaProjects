package com.names.ColinMartinez;

import java.io.*;
import javax.swing.*;
import java.util.*;


public class Quicksort {

	public static void main(String[] args) throws IOException {
		// Variables
		String searchValue, input;	// holds user input
		int result;					// holds the returned value from the binary search
		
		ArrayList<String> names = new ArrayList<String>(); //Holds input from binary file
		
		names = ReadBinaryFile(names);	// Call ReadBinaryFile Method
		names = insertionSort(names);		// Sort array name using BubbleSort method
		
		// Start search for user entered value 
		do
		{
			
			searchValue = JOptionPane.showInputDialog("Enter search value");			//userInput is set to search value
		
			//Search for value
			result = BinarySearch(names, searchValue);  //Array List is run through search
														//against the search value. Returned
														//value from method is held in result
			//Display results
			if (result == -1)
				JOptionPane.showMessageDialog(null, searchValue + " was not found.");
			else
				JOptionPane.showMessageDialog(null, searchValue + " was found at index " + result);

			//Does the user want to search again
			input = JOptionPane.showInputDialog("Do you want to search again? (Y or N): ");
			if (input == null)	//If the user hits cancel the program closes
				System.exit(0);
			
		} while (input.isEmpty() || input.toLowerCase().charAt(0) == 'y'); //repeats the search if user chooses to	
																		   //Had an issue where a user pressing enter would cause an error. isEmpty() fixed that.
																		
		System.exit(0);                                                    	
	}
	
	/**
	 * ReadBinaryFile reads input from a binary file and stores 
	 * the data in an ArrayList
	 * @param nameList the ArrayList that data is read to
	 * @return returns the ArrayList
	 * @throws IOException
	 */
	public static ArrayList<String> ReadBinaryFile(ArrayList<String> nameList) throws IOException 
	{
		
		boolean endofFile = false;			// End of File boolean 
		nameList = new ArrayList<String>();	// ArrayList object - Holds input from binary file
		
		// Binary file input
		DataInputStream inputFile = new DataInputStream(new FileInputStream("names.dat"));
		
		// While loop - reads file and inputs data to ArrayList object
		while (!endofFile)
		{
			try {
				nameList.add(inputFile.readUTF());
			}
			catch (EOFException e) {
				endofFile = true;
			}
		}
		inputFile.close();
		return nameList;
	}
	
	/**
	 * BubbleSort sorts the desired array in ascending order before returning.
	 * @param array the ArrayList that is sorted
	 * @return returns sorted list 
	 */
	public static ArrayList<String> BubbleSort(ArrayList<String> array)
	{
		int lastPos;		// Marks the last position to compare
		int index; 			// Index of element to compare
		String temp;		// Used to swap elements
		
		for ( lastPos = array.size() - 1; lastPos >= 0; lastPos-- )
		{
			for (index = 0; index <= lastPos - 1; index++)
			{
				if (array.get(index).compareTo(array.get(index + 1)) > 0)
				{
					temp = array.get(index);
					array.set(index, array.get(index + 1));
					array.set(index + 1, temp);
				}
			}
		}
		return array;
	}
	
	/**
	 * SelectionSort sorts the desired array in ascending
	 * order using the Selection sort algorithm before returning.
	 * @param array the ArrayList to be sorted
	 * @return returns the sorted array to main
	 */
	public static ArrayList<String> selectionSort(ArrayList<String> array)
	{
		int startScan; //Starting position of the scan
		int index; 	   //holds subscript value
		int minIndex;  //Element with smallest value in scan
		String minValue;  //Smallest value found in scan
		
		for (startScan = 0; startScan < (array.size() - 1); startScan++)
		{
			//assume the first element in scannable area is smallest value
			minIndex = startScan;
			minValue = array.get(startScan);
			//Scan array starting at 2nd index in scannable area looking for smallest value
			for (index = startScan + 1; index < array.size(); index++)
			{
				if (array.get(index).compareTo(minValue) < 0)
				{
					minValue = array.get(index);
					minIndex = index;
				}
			}
			//Swap the element with the smallest value with the first element in scannable area
			array.set(minIndex, array.get(startScan));
			array.set(startScan, minValue);			
		}	
		return array;
	}
	
	/**
	 * InsertionSort sorts the array in ascending order using the Insertion
	 * algorithm before returning
	 * @param array the ArrayList to be sorted
	 * @return returns the sorted array to main
	 */
	public static ArrayList<String> insertionSort(ArrayList<String> array)
	{
		String unsortedValue;	//the first unsorted value
		int scan;				//used to scan the array
		
		for (int index = 1; index < array.size(); index++)
		{
			//first element outside sorted portion is stored in unsorted value
			unsortedValue = array.get(index);
			//start scan at the subscript of the first element in the unsorted part
			scan = index;
			//move first element in unsorted part into proper position within sorted part
			while (scan > 0 && array.get(scan - 1).compareTo(unsortedValue) > 0)
			{
				array.set(scan, array.get(scan - 1));
				scan--;
			}
			//insert the unsorted value in it's proper position in sorted part
			array.set(scan, unsortedValue);
		}
		return array;
	}
	
	/**
	 * Performs a search for the entered value using the Binary approach
	 * @param arrayForSearch the array that will be searched
	 * @param value the value that will be searched for
	 * @return returns the position which is either -1 or the index of the matched value
	 */
	public static int BinarySearch(ArrayList<String> arrayForSearch, String value)
	{
		int first = 0;						   //first array index
		int last = arrayForSearch.size() - 1;  //last array index
		int middle;							   //midpoint of search
		int position = -1;					   //position of search value
		boolean found = false;				   //flag
		
		while (!found && first <= last)
		{
			// Calculate midpoint
			middle = (first + last) / 2;
			// If value is found at middle
			if (arrayForSearch.get(middle).compareToIgnoreCase(value) == 0)
			{
				found = true;
				position = middle;
			}
			// else if value is in lower half
			else if (arrayForSearch.get(middle).compareToIgnoreCase(value) > 0)
				last = middle - 1;
			
			// else if value is in upper half
			else 
				first = middle + 1;
		
		}
		// return the position or -1 if not found
		return position;

	
	}
	
	
	
	
	
}
