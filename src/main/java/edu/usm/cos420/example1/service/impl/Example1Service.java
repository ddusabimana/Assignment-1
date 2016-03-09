package edu.usm.cos420.example1.service.impl;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;


import edu.usm.cos420.example1.dao.domain.OrdersDao;
import edu.usm.cos420.example1.dao.domain.CustomersDao;
import edu.usm.cos420.example1.dao.domain.PlantsDao;
import edu.usm.cos420.example1.domain.Orders;
import edu.usm.cos420.example1.domain.Customers;
import edu.usm.cos420.example1.domain.Plants;
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
	OrdersDao dao;
	PlantsDao plantDatabase; 
	CustomersDao customersDatabase;
	OrdersDao ordersDatabase;
	/**
	 * Default Constructor creates a default CItemDao object 
	 */
	
    public Example1Service()
    {
        this.dao = new OrdersDao();	
        this.plantDatabase = new PlantsDao();
        this.customersDatabase= new CustomersDao();
        this.ordersDatabase = new OrdersDao();
        
    }

    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public Example1Service(OrdersDao dao, PlantsDao plantDatabase, CustomersDao customersDatabase)
    {
        this.dao = dao;	
    }
 
    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public Example1Service(PlantsDao plantDatabase)
    {
        this.plantDatabase = plantDatabase; // adding plant items
    }

    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public Example1Service(OrdersDao ordersDatabase)
    {
        this.ordersDatabase = ordersDatabase;// adding customers info
    }
 
    public Example1Service(CustomersDao customersDatabase)
    {
        this.customersDatabase = customersDatabase;// adding customers info
    }
    
	/**
	 * Add a randomly generated CItem element to the repository
	 */
    public void addACItem() 
    {
    	int randomNum = 1 + (int)(Math.random() * 100000); 
    	Orders anItem = new Orders(new Long(randomNum), randomNum, "String with random number " + randomNum);
        dao.add(anItem);
    }
    
    public void addmyPlants(String discription, Long itemNumber)
    {
    	Plants item = new Plants(discription, itemNumber);
    	plantDatabase.add(item);
    }

    public void updatemyPlants(Plants myPlantsObj, int nUpdate)
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
    	Customers customers = new Customers(idNumber, name, address);
    	customersDatabase.add(customers);
    }
 
	public void addmyOrders(Customers customers, Plants inventory, int quantity, Date date, double total)
	{
		Orders orders = new Orders(customers, inventory, quantity, date, total);
		ordersDatabase.add(orders);
	}

    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */
	public Long maxCItemId()
	{
    	List<Orders> list = dao.list();
    	Long max = 0L;
    	if(list.isEmpty()) {
    		 return max;
    	}
    	else {
    		Iterator<Orders> iter = list.iterator();
    		max = iter.next().getId();
    		while(iter.hasNext()) {
    			 Orders anItem = iter.next();
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
