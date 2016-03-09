package edu.usm.cos420.example1.view.impl;

import java.util.Scanner;

import edu.usm.cos420.example1.service.ExampleService;
import edu.usm.cos420.example1.service.impl.Example1Service;

/* 
 * CItemView class 
 *    A Command line User Interface which displays menu of CItem options to user and collects 
 *    the user choice.  
 * 
 */
public class CItemView
{
	public static final int NO_CHOICE = 0; /** {@value} : no choice selected by user */
    public static final int ADDONE = 1;	/** {@value #ADDONE} : Add one CItem to the collection of items */
    public static final int plants = 2;
    public static final int customer = 3;
    public static final int stock = 4;
    public static final int order = 5;
    public static final int displayCustomer = 6;
  
    public static final int displayInventory = 7;
    public static final int displayOrders = 8;
 
    public static final int EXIT = 9; /** {@value #EXIT} : Exit the program */
    //.Object to read menu choices
    private Scanner in = new Scanner(System.in); 
    private ExampleService example1Service;
    //.
    /**
     * This small version of the UI does not need the model or service objects but, in general, 
     *     references to these objects are needed in the UI. Default constructor
     *     creates a reference to Example1Service class to illustrate this.
     */
  public CItemView()
  {
      this.setExample1Service(new Example1Service());
  }

  /**
   * This small version of the UI does not need the model or service objects but, in general, 
   * references to these objects are needed in the UI.
   * @param example1Service reference to class which provides CItem Services
   */
   public CItemView(ExampleService example1Service)
   {
	  this.setExample1Service(example1Service);
   }
   
  /**
   * Display top level menu.
   */
	public void displayMenu ()
	{
		System.out.println();
		System.out.println("Enter the number denoting the action to perform : ");
		System.out.println("Add One..............." + ADDONE);
		System.out.println("Add Plants............" + plants);
		System.out.println("Add Customers........." + customer);
		System.out.println("Add Stock............." + stock);
		System.out.println("Make Order............." + order);
		System.out.println("Display Customers....." + displayCustomer);
		System.out.println("Display Inventory....." + displayInventory);
		System.out.println("Display Orders........" + displayOrders);
		System.out.println("Exit.................." + EXIT);
	}

  /**
   * Read the menu choice from user.
   * @param prompt Text asking user to enter choice
   * @return 
   *  <ul>
   *    <li>{@value #ADDONE}  : Add one item to the collection of items
   *    <li>{@value #plants}  : Add plants in the inventory
   *    <li>{@value #customer}  : Add your ID, name and address.
   *     <li>{@value #displayCustomer}  : Display your customer file. 
   *     <li>{@value #stock}  : Add stock.
   *     <li>{@value #displayOrders}  : view orders
   *     <li>{@value #order}  : Make order
   *     <li>{@value #displayInventory}  : view inventories. 
   *     <li>{@value #removeItem}  : Remove Item.  
   *    <li>{@value #EXIT}  : Exit the program 
   *    
   * </ul>
   */
  public int readIntWithPrompt (String prompt)
  {
    System.out.print(prompt); 
    System.out.flush();
    int choice = in.nextInt();
    return choice;
  }

  public ExampleService getExample1Service()
  {
	return example1Service;
  }

  public void setExample1Service(ExampleService example1Service)
  {
	this.example1Service = example1Service;
  }

}
