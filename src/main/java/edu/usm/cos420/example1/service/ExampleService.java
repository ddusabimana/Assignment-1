package edu.usm.cos420.example1.service;

import java.sql.Date;

import edu.usm.cos420.example1.domain.myCustomers;
import edu.usm.cos420.example1.domain.myPlants;
import edu.usm.cos420.example1.domain.myOrders;
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
	public void updatemyPlants(myPlants plantForUpdate, int nQuantForUpdate);
    public void addmyCustomers(Long idNumber,String name, String address);
    public void addmyOrders(myCustomers customers, myPlants inventory, int quantity, Date date, double total);
    //.
    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */
	public Long maxCItemId();
	//.
}
//.
