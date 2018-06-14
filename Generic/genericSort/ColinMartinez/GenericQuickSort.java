package genericSort.ColinMartinez;

import java.util.Arrays;

public class GenericQuickSort {

	public static void main(String[] args) {
		// Three different arrays to pass to the generic sort method
		String[] names = {"Thor", "Colin", "Lorena", "Water Boy", "Grease"};
		Integer[] numbers = {4,2,3,1,25,5,193,74,18};
		Double[] dub = {1.1,3.1,2.1,6.4,3.67,5.78,9.1,7.25};
		
		// Calling the generic sort method. Passing each array and 
		// printing out each to the display
		BubbleSort(names);
		System.out.println(Arrays.toString(names));
		BubbleSort(numbers);
		System.out.println(Arrays.toString(numbers));
		BubbleSort(dub);
		System.out.println(Arrays.toString(dub));			

	}

	/**
	 * This Bubblesort algorithm is generic and accepts different object types
	 * to be sorted.
	 * @param array the array to be sorted
	 * @return returns the array to the main method
	 */
	public static <E extends Comparable<E>> E[] BubbleSort(E[] array)
	{
		int lastPos;		// Marks the last position to compare
		int index; 			// Index of element to compare
		E temp;				// Used to swap elements
		
		for ( lastPos = array.length - 1; lastPos >= 0; lastPos-- )	// The for loop will run as long as
																	// the lastPos is greater than or equal to 0.
																	// each successful loop decrements the lasPos value.
		{
			// The nested for loop will run as long as the index value is less than
			// the last position. Incrementing the index with each pass.
			for (index = 0; index <= lastPos - 1; index++)			
			{
				// The if statement swaps adjacent elements if one is 
				// greater than the other.
				if (array[index].compareTo(array[index + 1]) > 0)
				{
					temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
				}
			}
		}
		return array;
	}

}


