package edu.usm.cos420.example1.dao.domain;

import java.util.List;

import edu.usm.cos420.example1.dao.GenericDao;
import edu.usm.cos420.example1.dao.ObjectStreamDao;
import edu.usm.cos420.example1.domain.Plants;

/**
 * 
 *  A Data Access Object specifically for myPlants entities 
 *     
 */
public class PlantsDao
{
	private GenericDao<Long,Plants> myPlantsDao;

	/**
	 * Default constructor creates an ObjectStream file called myPlants.ser
	 */
	public PlantsDao()
	{
		myPlantsDao = new ObjectStreamDao<Long,Plants>("myPlants.ser");;
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public PlantsDao(String fileName)
	{
		myPlantsDao = new ObjectStreamDao<Long,Plants>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,myPlants> 
	 */
	public PlantsDao(GenericDao<Long,Plants> dao)
	{
		myPlantsDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,myPlants> 
	 */
	public GenericDao<Long,Plants> getmyPlantsDao() {
		return myPlantsDao;
	}

	/**
	 * Add a myPlants to the DAO repository
	 * @param entity any myPlants object
	 */
	public void add(Plants entity)
	{
		myPlantsDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a myPlants in the DAO repository
	 * @param entity any myPlants object
	 */
	public void update(Plants entity) 
	{
		myPlantsDao.update(entity.getId(), entity);
	}
	
	/**
	 * Remove a myPlants in the DAO repository
	 * @param id of the myPlants object to remove
	 */

	public void remove(Long id)
	{
		myPlantsDao.remove(id);
	}
	
	/**
	 * Find a myPlants in the DAO repository
	 * @param id of the myPlants object to locate
	 * @return the myPlants with id field equal to key
	 */
	public Plants find(Long key)
	{
		return myPlantsDao.find(key);
	}
    
	/**
	 * Generate a list of myPlants in the DAO repository
	 * @return List of myPlants
	 */

	public List<Plants> list()
	{
		return myPlantsDao.list();
	}

}

