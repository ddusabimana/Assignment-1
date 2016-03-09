package edu.usm.cos420.example1.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 *  For the purposes of this example, myOrders holds three 
 *  piece of data. The class implements the interface 
 *  Serializable so that we can store and retrieve the 
 *  information in this class 
 * 
 */
public class myOrders implements Serializable
{
	private static final long serialVersionUID = 7526472295622776147L;
	private myCustomers customers;
	private myPlants inventory;
	private int quantity;
	private Date date;
	private double total;

    public myOrders(myCustomers customers, myPlants inventory, int quantity, Date date, double total)
	{
		super();
		this.customers = customers;
		this.inventory = inventory;
		this.setQuantity(quantity);
		this.date = date;
		this.setTotal(total);
	}

	private Long id;
    private static Long COUNTER = 0L;
	private Integer myInteger;
    private String myString;

   /**
    * get the ID of the myOrders 
    * @return ID 
    */
    public Long getId()
	{
		return(id);
	}

    /**
     * Set the ID of the myOrders
     * @param id new id 
     */
	public void setId(Long id)
	{
		this.id = id;
	}
    
	/** 
	 * Default Constructor : 
	 * Creates new myOrders with an auto-generated sequence ID 
	 */
	public myOrders()
	{
        myInteger = new Integer(0);
        myString = new String("");
    	id = generateId();
    }

	/** 
	 * Two field Constructor : 
	 * Creates new myOrders with an autogenenerated sequence ID 
	 */
    public myOrders(int n, String str)
	{
        myInteger = new Integer(n);
        myString = str;
    	id = generateId();
    }

    /** 
     * Three field constructor 
     */
    public myOrders(Long id, int n, String str)
	{
        myInteger = new Integer(n);
        myString = str;
    	this.id = id;
    }

	/**
	 * @return Returns the Integer.
	 */
	public Integer getMyInteger()
	{
		return(myInteger);
	}
	/**
	 * @param i The integer to set.
	 */
	public void setMyInteger(int i)
	{
		this.myInteger = new Integer(i);
	}
	/**
	 * @return Returns  myString.
	 */
	public String getMyString()
	{
		return(myString);
	}
	/**
	 * @param myString The string to set.
	 */
	public void setMyString(String myString)
	{
		this.myString = myString;
	}

    /**
     * Returns the String representation of this User. Not required, it just pleases reading logs.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
    	return(String.format("myOrders [id=%d,myString=%s,myInteger=%s]", getId(), myString, myInteger));
    }

    // for autogeneration of ids
    private Long generateId()
    {
    	return COUNTER++;
    }

	public int getQuantity()
	{
		return(quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public myCustomers getCustomers()
	{
		return(this.customers);
	}

	public myPlants getPlants()
	{
		return(this.inventory);
	}

	public Date getDate()
	{
		return(this.date);
	}
	//.
}
