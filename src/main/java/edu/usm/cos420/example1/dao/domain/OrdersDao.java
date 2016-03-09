package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.Orders;

/**
 * 
 *  A Data Access Object specifically for myOrders entities 
 *     
 */
public class OrdersDao
{
	private GenericDao<Long,Orders> myOrdersDao;

	/**
	 * Default constructor creates an ObjectStream file called myOrders.ser
	 */
	public OrdersDao()
	{
		myOrdersDao = new ObjectStreamDao<Long,Orders>("myOrders.ser");
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public OrdersDao(String fileName)
	{
		myOrdersDao = new ObjectStreamDao<Long,Orders>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,myOrders> 
	 */
	public OrdersDao(GenericDao<Long,Orders> dao)
	{
		myOrdersDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,myOrders> 
	 */
	public GenericDao<Long,Orders> getmyOrdersDao() {
		return myOrdersDao;
	}

	/**
	 * Add a myOrders to the DAO repository
	 * @param entity any myOrders object
	 */
	public void add(Orders entity)
	{
		myOrdersDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a myOrders in the DAO repository
	 * @param entity any myOrders object
	 */
	public void update(Orders entity) 
	{
		myOrdersDao.update(entity.getId(), entity);
	}
	
	/**
	 * Remove a myOrders in the DAO repository
	 * @param id of the myOrders object to remove
	 */

	public void remove(Long id)
	{
		myOrdersDao.remove(id);
	}
	
	/**
	 * Find a myOrders in the DAO repository
	 * @param id of the myOrders object to locate
	 * @return the myOrders with id field equal to key
	 */
	public Orders find(Long key)
	{
		return myOrdersDao.find(key);
	}
    
	/**
	 * Generate a list of myOrderss in the DAO repository
	 * @return List of myOrderss 
	 */

	public List<Orders> list() {
		return myOrdersDao.list();
	}

}

