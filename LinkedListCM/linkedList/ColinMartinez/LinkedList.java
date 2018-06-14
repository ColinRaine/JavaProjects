package linkedList.ColinMartinez;

import java.io.*;

public class LinkedList {	

	public static void main(String[] args) throws IOException {
		//LinkedList object
		LinkedList0 ll = new LinkedList0();
		
		String names = "";
		boolean eof = false;
		
		//Creation of binary file input object
		DataInputStream inputFile = new DataInputStream( new FileInputStream("names.dat"));
		
		//add file to linked list until null
		System.out.println("Reading from binary file...\n");
		while(!eof)
		{
			try
			{
				names = inputFile.readUTF();
				ll.add(names);
			}
			catch(EOFException e)
			{
				eof = true;
			}
		}
		
		inputFile.close(); //close the file
		
		//Check if list is empty (isEmpty method)
		if (ll.isEmpty())
		{
			System.out.println("List is empty.");
		}
		else
			{
				System.out.println("List contains data: " + ll.size() + " names"); //size method
				ll.print();	//print method
			}
		
		//Demonstrate remove methods 
		System.out.println("\n\nI don't like Mary so she's gone.\nRemoving Mary...");
		ll.remove("MARY"); //first remove method
		ll.print();
		System.out.println("\n\nBye Barabara! Me no like you either!\nRemoving Barabara...");
		ll.remove(2); //second remove method
		ll.print();
		
		//Demonstrate add methods
		System.out.println("\n\nLet me add some better names to the list: ");
		ll.add("*LORENA");	//first add method
		ll.add(1, "*THOR"); //second add method
		ll.print();
		
		//Demonstrate get method
		System.out.println("\n\nLet me just grab a name...\n...\n...\n" + ll.get(8) + "!");
		
		//Demonstrate removeAll method
		System.out.println("\n\nYou know what? Let's just remove all the names!\nRemoving names...");
		ll.removeAll();
		System.out.print("Is the list empty? " + ll.isEmpty());
		}
}


