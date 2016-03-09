package edu.usm.cos420.example1.service.impl;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;


import edu.usm.cos420.example1.dao.domain.myOrdersDao;
import edu.usm.cos420.example1.dao.domain.myCustomersDao;
import edu.usm.cos420.example1.dao.domain.myPlantsDao;
import edu.usm.cos420.example1.domain.myOrders;
import edu.usm.cos420.example1.domain.myCustomers;
import edu.usm.cos420.example1.domain.myPlants;
import edu.usm.cos420.example1.service.ExampleService;

/**
 * 
 *  The Example1 Service Layer Implementation is based a design pattern
 *  which aims to organize the functionality of the application into logical units 
 *  that are typically layered on top of much of the low level functionality of the 
 *  application. This organization helps support service oriented architectures. 
 *
 */
public class Example1Service implements ExampleService
{
	myOrdersDao dao;
	myPlantsDao plantDatabase; 
	myCustomersDao customersDatabase;
	myOrdersDao ordersDatabase;
	/**
	 * Default Constructor creates a default CItemDao object 
	 */
	
    public Example1Service()
    {
        this.dao = new myOrdersDao();	
        this.plantDatabase = new myPlantsDao();
        this.customersDatabase= new myCustomersDao();
        this.ordersDatabase = new myOrdersDao();
        
    }

    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public Example1Service(myOrdersDao dao, myPlantsDao plantDatabase, myCustomersDao customersDatabase)
    {
        this.dao = dao;	
    }
 
    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public Example1Service(myPlantsDao plantDatabase)
    {
        this.plantDatabase = plantDatabase; // adding plant items
    }

    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public Example1Service(myOrdersDao ordersDatabase)
    {
        this.ordersDatabase = ordersDatabase;// adding customers info
    }
 
    public Example1Service(myCustomersDao customersDatabase)
    {
        this.customersDatabase = customersDatabase;// adding customers info
    }
    
	/**
	 * Add a randomly generated CItem element to the repository
	 */
    public void addACItem() 
    {
    	int randomNum = 1 + (int)(Math.random() * 100000); 
    	myOrders anItem = new myOrders(new Long(randomNum), randomNum, "String with random number " + randomNum);
        dao.add(anItem);
    }
    
    public void addmyPlants(String discription, Long itemNumber)
    {
    	myPlants item = new myPlants(discription, itemNumber);
    	plantDatabase.add(item);
    }

    public void updatemyPlants(myPlants myPlantsObj, int nUpdate)
    {
    	int nCurrStock = 0;
    	//.
    	nCurrStock = myPlantsObj.getMyInteger();
    	nCurrStock += nUpdate;
    	myPlantsObj.setMyInteger(nCurrStock);
    	plantDatabase.update(myPlantsObj);
    }
    
	public void addmyCustomers(Long idNumber, String name, String address)
	{
    	myCustomers customers = new myCustomers(idNumber, name, address);
    	customersDatabase.add(customers);
    }
 
	public void addmyOrders(myCustomers customers, myPlants inventory, int quantity, Date date, double total)
	{
		myOrders orders = new myOrders(customers, inventory, quantity, date, total);
		ordersDatabase.add(orders);
	}

    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */
	public Long maxCItemId()
	{
    	List<myOrders> list = dao.list();
    	Long max = 0L;
    	if(list.isEmpty()) {
    		 return max;
    	}
    	else {
    		Iterator<myOrders> iter = list.iterator();
    		max = iter.next().getId();
    		while(iter.hasNext()) {
    			 myOrders anItem = iter.next();
    			 if(anItem.getId() > max) {
    			     max = anItem.getId();
    			 }
    		}
    		return(max);
    	}
    }
	//.
}
//.
