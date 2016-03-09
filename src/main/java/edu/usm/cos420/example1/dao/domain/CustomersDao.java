package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.Customers;

/**
 * 
 *  A Data Access Object specifically for myCustomers entities 
 *     
 */
public class CustomersDao
{
	private GenericDao<Long,Customers> myCustomersDao;

	/**
	 * Default constructor creates an ObjectStream file called myCustomers.ser
	 */
	public CustomersDao()
	{
		myCustomersDao = new ObjectStreamDao<Long,Customers>("myCustomers.ser");;
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public CustomersDao(String fileName)
	{
		myCustomersDao = new ObjectStreamDao<Long,Customers>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,myCustomers> 
	 */
	public CustomersDao(GenericDao<Long,Customers> dao)
	{
		myCustomersDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,myCustomers> 
	 */
	public GenericDao<Long,Customers> getmyCustomersDao() {
		return myCustomersDao;
	}

	/**
	 * Add a myCustomers to the DAO repository
	 * @param entity any myCustomers object
	 */
	public void add(Customers entity)
	{
		myCustomersDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a myCustomers in the DAO repository
	 * @param entity any myCustomers object
	 */
	public void update(Customers entity) 
	{
		myCustomersDao.update(entity.getId(), entity);
	}
	
	/**
	 * Remove a myCustomers in the DAO repository
	 * @param id of the myCustomers object to remove
	 */

	public void remove(Long id)
	{
		myCustomersDao.remove(id);
	}
	
	/**
	 * Find a myCustomers in the DAO repository
	 * @param id of the myCustomers object to locate
	 * @return the myCustomers with id field equal to key
	 */
	public Customers find(Long key)
	{
		return myCustomersDao.find(key);
	}
    
	/**
	 * Generate a list of myCustomerss in the DAO repository
	 * @return List of myCustomerss 
	 */

	public List<Customers> list() {
		return myCustomersDao.list();
	}

}

