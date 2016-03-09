package edu.usm.cos420.example1.controller;

import java.awt.*;
import javax.swing.JOptionPane; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//.
import edu.usm.cos420.example1.service.ExampleService;
import edu.usm.cos420.example1.view.impl.CItemView;
import edu.usm.cos420.example1.dao.domain.CustomersDao;
import edu.usm.cos420.example1.dao.domain.PlantsDao;
import edu.usm.cos420.example1.dao.domain.OrdersDao;
import edu.usm.cos420.example1.domain.Customers;
import edu.usm.cos420.example1.domain.Plants;
import edu.usm.cos420.example1.domain.Orders;
//.
/**
 *   A Controller class to execute user's menu choice.
 *     List of possible choices can be found at {@link edu.usm.cos420.example1.view.TextUI}
 *   
 */	 
public class CItemController
{
	private ExampleService atMyService; 
	private CItemView view;
	
	/**
	 * Constructor : pass in a service class which can provide access to cItem operations. 
	 * @param view 
	 * @param service
	 */
	public CItemController(CItemView view, ExampleService service)
	{
		this.view = view;
		this.atMyService = service;
	}

	/**
	 * Allow the user to access the citem collection
	 * 
	 */
    public void provideCItemAccess()
    {
        int choice = CItemView.NO_CHOICE;
        while(choice != CItemView.EXIT) {
          view.displayMenu();
          choice = view.readIntWithPrompt("Enter choice : ");
      
          executeChoice(choice);
        }
    }

	/**
	 *   Performs the branching logic to call appropriate functions to satisfy user choice
	 *   @param choice represents the user selection of action they want accomplished. 
 	 */
	public void executeChoice(int choice)
	{
	    System.out.println();
	    if(choice == CItemView.ADDONE) {
	    	atMyService.addACItem();
	    	System.out.println(CItemView.ADDONE + ". Please Enter any number of your choice below : ");
	    }
	    else if(choice == CItemView.customer) { //.Add Customer -------------------------------------------
	    	Long idNumber = 0L + view.readIntWithPrompt("Pleae Enter Customer ID : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name = "";
			System.out.println(CItemView.customer + ". Please Enter Customer Name : ");
			try {
				name = br.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			BufferedReader bre = new BufferedReader(new InputStreamReader(System.in));
			String address = "";
			System.out.println("Please Enter Customer Address : ");
			try {
				address = bre.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			atMyService.addmyCustomers(idNumber, name, address);
			System.out.println("Your customer info is added, Thank you.");
	    }
	    else if(choice == CItemView.plants) { //.Add Plant ------------------------------------------------
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	String discription = "";
	    	System.out.println(CItemView.plants + ". Please Enter Plant Name or Description : ");
	    	try {
	    		discription = br.readLine();
	    	}
	    	catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	Long itemNumber = 0L + view.readIntWithPrompt("Pleae Enter Plant ID Number : ");
	    	atMyService.addmyPlants(discription, itemNumber);
	    }
	   
	    else if(choice == CItemView.stock) { //.Add Stock -------------------------------------------------
			String strPlantName = "";
			Plants plantForUpdate;
			while(true) {
				strPlantName = "";
				BufferedReader brplant = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(CItemView.stock + ". Please enter Plant Name / Description : ");
				try {
					strPlantName = brplant.readLine();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				plantForUpdate = verifyPlantByDesc(strPlantName);
				if(plantForUpdate == null) {
					System.out.println("Plant with name '" + strPlantName + "' cannot be found !");
				}
				else{
					break;
				}
			}
			//.
			BufferedReader brQuantity = new BufferedReader(new InputStreamReader(System.in));
			String strQuantity = "";
			System.out.println("Please Enter Additional Quantity : ");
			try {
				strQuantity = brQuantity.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			int nQuantForUpdate = Integer.parseInt(strQuantity);
	    	atMyService.updatemyPlants(plantForUpdate, nQuantForUpdate);
	    }
	  
	    else if(choice == CItemView.order) { //.Add Order -------------------------------------------------
	    	String strCustName = "";
	    	Customers custForOrder;
			while(true) { //.Get Customer Name
				strCustName = "";
				BufferedReader brcustomer = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please enter Customer Name :");
				try {
					strCustName = brcustomer.readLine();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				custForOrder = verifyCustByName(strCustName);
				if(custForOrder == null) {
					System.out.println("Customer with name '" + strCustName + "' cannot be found !");
				}
				else {
					break;
				}
			}
			String strPlantName = "";
			Plants plantForOrder;
			while(true) { //.Get Plant Description
				strPlantName = "";
				BufferedReader brplant = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please enter Plant Name / Description : ");
				try {
					strPlantName = brplant.readLine();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				plantForOrder = verifyPlantByDesc(strPlantName);
				if(plantForOrder == null) {
					System.out.println("Plant with name '" + strPlantName + "' cannot be found !");
				}
				else{
					break;
				}
			}
			//.
			BufferedReader brQuantity = new BufferedReader(new InputStreamReader(System.in));
			String strQuantity = "";
			System.out.println("Please enter your quantity : ");
			try {
				strQuantity = brQuantity.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			int nQuantForOrder = Integer.parseInt(strQuantity);
			if(nQuantForOrder > plantForOrder.getMyInteger()) {
				System.out.println("Sorry, only " + plantForOrder.getMyInteger() + " '" + plantForOrder.getDiscription()  + "' in stock");
				System.out.println("Reducing order of '" + plantForOrder.getDiscription() + "' to " + plantForOrder.getMyInteger());
				nQuantForOrder = plantForOrder.getMyInteger();
			}
			//.
			Date dateForOrder = new Date(System.currentTimeMillis());
			System.out.println("Current Date & Time : " + dateForOrder.toString());
			//.
			double total = 0.0;
			atMyService.addmyOrders(custForOrder, plantForOrder, nQuantForOrder, dateForOrder, total);
			atMyService.updatemyPlants(plantForOrder, (-1 * nQuantForOrder));
		}
	    else if(choice == CItemView.displayCustomer) { //.Display Customers -------------------------------
	    	displayCustomers();
	    }
	    else if(choice == CItemView.displayInventory) { //.Display Stock ----------------------------------
	    	displayPlants();
	    }
	    else if(choice == CItemView.displayOrders) { //.Display Stock ----------------------------------
	    	displayOrders();
	    }
	    else if(choice == CItemView.EXIT) { //.Exit Program -----------------------------------------------
	    	System.out.println("Goodbye.");
	    }
	}
	

	private void displayCustomers()
	{
		List<Customers> list = new ArrayList<Customers>();
		CustomersDao customerdao = new CustomersDao("myCustomers.ser");
		list =  customerdao.list();
		Iterator<Customers> itr = list.iterator();
		//.
		System.out.println("ID\t\tNAME\t\t\tADDRESS\n");
		while(itr.hasNext()) {
			Customers element = itr.next();
			int ID = element.getId().intValue();
			String name = element.getName();
			String address = element.getAddress();
			System.out.printf("%06d\t\t%-20s\t%-40s\n", ID, name, address);
		}
		System.out.println();
	}


	private void displayPlants()
	{
		List<Plants> list = new ArrayList<Plants>();
		PlantsDao plantdao = new PlantsDao("myPlants.ser");
		list = plantdao.list();
		Iterator<Plants> itr = list.iterator();
		//.
		System.out.println("DISCRIPTION\t\t\tID NUMBER\t\t\tSTOCK\n");
		while(itr.hasNext()) {
			Plants element = itr.next();
			String strPlant = element.getDiscription();
			int Id = element.getId().intValue();
			int Stock = element.getMyInteger();
			System.out.printf("%-30s\t%06d\t\t\t%06d\n", strPlant, Id, Stock);
		}
		System.out.println("");
	}

	private void displayOrders()
	{
		List<Orders> list = new ArrayList<Orders>();
		OrdersDao orderdao = new OrdersDao("myOrders.ser");
		list = orderdao.list();
		Iterator<Orders> itr = list.iterator();
		//.
		System.out.println("CUSTOMER\t\tPLANT NAME\t\tQUANTITY\tDATE\n");
		while(itr.hasNext()) {
			Orders element = itr.next();
			String strCustName = element.getCustomers().getName();
			String strPlantName = element.getPlants().getDiscription();
			int nOrderQuant = element.getQuantity();
			String strOrderDate = element.getDate().toString();
			System.out.printf("%-18s \t %-18s \t %06d \t %-15s \n", strCustName, strPlantName, nOrderQuant, strOrderDate);
		}
		System.out.println();
	}

	private Customers verifyCustByName(String strCustName)
	{
		List<Customers> list = new ArrayList<Customers>();
		CustomersDao customerdao = new CustomersDao("myCustomers.ser");
		list =  customerdao.list();
		Iterator<Customers> itr = list.iterator();
		while(itr.hasNext()) {
			Customers element = itr.next();
			int ID = element.getId().intValue();
			String name = element.getName();
			if(name.equalsIgnoreCase(strCustName)) {
				return(element);
			}
		}
		return(null);
	}
	
	
	private Customers verifyCustById(int nCustId)
	{
		List<Customers> list = new ArrayList<Customers>();
		CustomersDao customerdao = new CustomersDao("myCustomers.ser");
		list =  customerdao.list();
		Iterator<Customers> itr = list.iterator();
		while(itr.hasNext()) {
			Customers element = itr.next();
			int ID = element.getId().intValue();
			if(ID == nCustId) {
				return(element);
			}
		}
		return(null);
	}

	private Plants verifyPlantByDesc(String strPlantDesc)
	{
		List<Plants> list = new ArrayList<Plants>();
		PlantsDao plantdao = new PlantsDao("myPlants.ser");
		list = plantdao.list();
		Iterator<Plants> itr = list.iterator();
		while(itr.hasNext()) {
			Plants element = itr.next();
			String discription = element.getDiscription();
			int ID = element.getId().intValue();
			if(discription.equalsIgnoreCase(strPlantDesc)) {
				return(element);
			}
		}
		return(null);
	}

}
//.
//.
//.
