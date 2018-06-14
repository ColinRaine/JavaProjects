package com.eclipse.ColinMartinez;

/**
 * The Employee class stores data about an employee
 * @author Colin Martinez
 *
 */

public class Employee {
	//Fields
	private String name;
	private int idNumber;
	private String department;
	private String position;
	
	/**
	 * Constructor 1 initializes all fields.
	 * @param nam Employee's Name
	 * @param idN Employee's idNumber
	 * @param dep Employee's department
	 * @param pos Employee's position
	 */
	public Employee(String nam, int idN, String dep, String pos)
	{
		name = nam;
		idNumber = idN;
		department = dep;
		position = pos;
	}
	
	/**
	 * Constructor 2 initializes name and idNumber field.
	 * @param nam Employee's Name
	 * @param idN Employee's idNumber
	 */
	public Employee(String nam, int idN)
	{
		name = nam;
		idNumber = idN;
		department = "";
		position = "";
	}
	
	/**
	 * no-argument Constructor initializes string fields with an empty
	 * string and places a value of 0 for the int field
	 */
	public Employee()
	{
		name = "";
		idNumber = 0;
		department = "";
		position = "";
	}
	
	/**
	 * The setName method stores a literal in
	 * the name field.
	 * @param nam Employee's name
	 */
	public void setName(String nam)
	{
		name = nam;
	}
	
	/**
	 * The setIdNumber method stores a literal
	 * in the idNumber field.
	 * @param idN Employee's id number
	 */
	public void setIdNumber(int idN)
	{
		idNumber = idN;
	}
	
	/**
	 * The setDepartment method stores a literal
	 * in the department field.
	 * @param dep Employee's department
	 */
	public void setDepartment(String dep)
	{
		department = dep;
	}
	
	/**
	 * The setPostion method stores a literal
	 * in the position field.
	 * @param pos Employee's position
	 */
	public void setPosition(String pos)
	{
		position = pos;
	}
	
	/**
	 * The getName method returns the value
	 * of the name field.
	 * @return The name of the Employee
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * The getIdNumber method returns the value
	 * of the idNumber field.
	 * @return The idNumber of the Employee
	 */
	public int getIdNumber()
	{
		return idNumber;
	}
	
	/**
	 * The getDepartment method returns the value
	 * of the department field.
	 * @return The Employee's department.
	 */
	public String getDepartment()
	{
		return department;
	}
	
	/**
	 * The getPosition method returns the value
	 * of the position field.
	 * @return The Employee's position
	 */
	public String getPosition()
	{
		return position;
	}
}
