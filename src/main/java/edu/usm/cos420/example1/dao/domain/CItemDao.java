package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.myOrders;

/*
./Desktop/USM/Spring2016/COS_420_Object-Oriented_Design/Assignment/Example1
myCustomers.ser
myOrdersDao.ser
myPlants.ser
*/

/**
 * 
 *  A Data Access Object specifically for CItem entities 
 *     
 */
public class CItemDao
{
	private GenericDao<Long,myOrders> cItemDao;

	/**
	 * Default constructor creates an ObjectStream file called citem.ser
	 */
	public CItemDao()
	{
		cItemDao = new ObjectStreamDao<Long,myOrders>("citem.ser");;
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public CItemDao(String fileName)
	{
		cItemDao = new ObjectStreamDao<Long,myOrders>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,CItem> 
	 */
	public CItemDao(GenericDao<Long,myOrders> dao)
	{
		cItemDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,CItem> 
	 */
	public GenericDao<Long,myOrders> getCItemDao() {
		return cItemDao;
	}

	/**
	 * Add a CItem to the DAO repository
	 * @param entity any CItem object
	 */
	public void add(myOrders entity)
	{
		cItemDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a CItem in the DAO repository
	 * @param entity any CItem object
	 */
	public void update(myOrders entity) 
	{
		cItemDao.update(entity.getId(), entity);
	}
	
	/**
	 * Remove a CItem in the DAO repository
	 * @param id of the CItem object to remove
	 */

	public void remove(Long id)
	{
		cItemDao.remove(id);
	}
	
	/**
	 * Find a CItem in the DAO repository
	 * @param id of the CItem object to locate
	 * @return the CItem with id field equal to key
	 */
	public myOrders find(Long key)
	{
		return cItemDao.find(key);
	}
    
	/**
	 * Generate a list of CItems in the DAO repository
	 * @return List of CItems 
	 */

	public List<myOrders> list() {
		return cItemDao.list();
	}

}

