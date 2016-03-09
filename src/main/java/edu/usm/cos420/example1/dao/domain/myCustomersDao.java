package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.myCustomers;

/**
 * 
 *  A Data Access Object specifically for myCustomers entities 
 *     
 */
public class myCustomersDao
{
	private GenericDao<Long,myCustomers> myCustomersDao;

	/**
	 * Default constructor creates an ObjectStream file called myCustomers.ser
	 */
	public myCustomersDao()
	{
		myCustomersDao = new ObjectStreamDao<Long,myCustomers>("myCustomers.ser");;
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public myCustomersDao(String fileName)
	{
		myCustomersDao = new ObjectStreamDao<Long,myCustomers>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,myCustomers> 
	 */
	public myCustomersDao(GenericDao<Long,myCustomers> dao)
	{
		myCustomersDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,myCustomers> 
	 */
	public GenericDao<Long,myCustomers> getmyCustomersDao() {
		return myCustomersDao;
	}

	/**
	 * Add a myCustomers to the DAO repository
	 * @param entity any myCustomers object
	 */
	public void add(myCustomers entity)
	{
		myCustomersDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a myCustomers in the DAO repository
	 * @param entity any myCustomers object
	 */
	public void update(myCustomers entity) 
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
	public myCustomers find(Long key)
	{
		return myCustomersDao.find(key);
	}
    
	/**
	 * Generate a list of myCustomerss in the DAO repository
	 * @return List of myCustomerss 
	 */

	public List<myCustomers> list() {
		return myCustomersDao.list();
	}

}

