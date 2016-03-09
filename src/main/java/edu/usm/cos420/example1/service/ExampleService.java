package edu.usm.cos420.example1.service;

import java.sql.Date;

import edu.usm.cos420.example1.domain.Customers;
import edu.usm.cos420.example1.domain.Plants;
import edu.usm.cos420.example1.domain.Orders;
/**
 * 
 *  The Example1 Service Interface is based a design pattern
 *  which aims to organize the functionality of the application into logical units 
 *  that are typically layered on top of much of the low level functionality of the 
 *  application. This organization helps support service oriented architectures. 
 *
 */
public interface ExampleService
{
	/**
	 * Add a randomly generated CItem element to the repository
	 */
    public void addACItem();
    //.
    public void addmyPlants(String discription, Long itemNumber);
	public void updatemyPlants(Plants plantForUpdate, int nQuantForUpdate);
    public void addmyCustomers(Long idNumber,String name, String address);
    public void addmyOrders(Customers customers, Plants inventory, int quantity, Date date, double total);
    //.
    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */
	public Long maxCItemId();
	//.
}
//.
