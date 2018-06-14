package com.eclipse.ColinMartinez;
import java.util.*;		//Imports all java.util packages

/**
 * Uses the Employee class to call objects, stores employee data
 * and returns the fields to the user for display.
 * @author Colin Martinez
 *
 */

public class EmployeeClassCM {

	public static void main(String[] args) {
		//Declare Variables
		String employeeName;		// holds Employee's Name
		int employeeNumber;			// holds Employee's Number
		String employeeDepartment;	// holds Employee's Department
		String employeePosition;	// holds Employee's Position
		
		
		
		//Employee class instances. Passes data entered as 
		//arguments for the constructor.
		 
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
						
		//Scanner Class Instance
		Scanner userInput = new Scanner(System.in);
		
		//Prompt for getting the first employee's information.
		System.out.println("What is the first employee's name?");
		employeeName = userInput.nextLine();
		employee1.setName(employeeName);
		System.out.println("What is the first employee's number?");
		employeeNumber = userInput.nextInt();
		employee1.setIdNumber(employeeNumber);
		userInput.nextLine();
		System.out.println("What is the first employee's department?");
		employeeDepartment = userInput.nextLine();
		employee1.setDepartment(employeeDepartment);
		System.out.println("What is the first employee's position?");
		employeePosition = userInput.nextLine();
		employee1.setPosition(employeePosition);
		
		//Prompt for getting the second employee's information
		System.out.println("What is the second employee's name?");
		employeeName = userInput.nextLine();
		employee2.setName(employeeName);
		System.out.println("What is the second employee's number?");
		employeeNumber = userInput.nextInt();
		employee2.setIdNumber(employeeNumber);
		userInput.nextLine();
		System.out.println("What is the second employee's department?");
		employeeDepartment = userInput.nextLine();
		employee2.setDepartment(employeeDepartment);
		System.out.println("What is the second employee's position?");
		employeePosition = userInput.nextLine();
		employee2.setPosition(employeePosition);
		
		//Prompt for getting the third employee's name
		System.out.println("What is the third employee's name?");
		employeeName = userInput.nextLine();
		employee3.setName(employeeName);
		System.out.println("What is the third employee's number?");
		employeeNumber = userInput.nextInt();
		employee3.setIdNumber(employeeNumber);
		userInput.nextLine();
		System.out.println("What is the third employee's department?");
		employeeDepartment = userInput.nextLine();
		employee3.setDepartment(employeeDepartment);
		System.out.println("What is the third employee's position?");
		employeePosition = userInput.nextLine();
		employee3.setPosition(employeePosition);
		
		
		//Get data from employees and display it
		System.out.println("");
		System.out.println("Here are the current employees: ");
		System.out.printf("%-20s\t%-20s\t%-20s\t%-20s\n", "Name", "ID Number", "Department", "Position");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%-20s\t%-20d\t%-20s\t%-20s\n", employee1.getName(), employee1.getIdNumber(), employee1.getDepartment(), employee1.getPosition());
		System.out.printf("%-20s\t%-20d\t%-20s\t%-20s\n", employee2.getName(), employee2.getIdNumber(), employee2.getDepartment(), employee2.getPosition());
		System.out.printf("%-20s\t%-20d\t%-20s\t%-20s\n", employee3.getName(), employee3.getIdNumber(), employee3.getDepartment(), employee3.getPosition());

	}

}
