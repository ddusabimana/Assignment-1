package edu.usm.cos420.example1.domain;

import java.io.Serializable;

public class myPlants implements Serializable
{
	private static final long serialVersionUID = 7526472295622776147L;
    private Long id;
    private String discription;
    private static Long COUNTER = 0L;
	private Integer myInteger;
    private String myString;
	/** 
	 * Default Constructor : 
	 * Creates new CItem with an auto-generated sequence ID 
	 */
	public myPlants(String discrpt, Long ID)
	{
		id = ID;
		setDiscription(discrpt);
        myInteger = new Integer(0);
        myString = new String("");
	}

	public myPlants()
	{
    	id = generateId();
		myInteger = new Integer(0);
        myString = new String("");
    }

	/** 
	 * Two field Constructor : 
	 * Creates new CItem with an auto-generated sequence ID 
	 */
    public myPlants(int n, String str)
    {
    	id = generateId();
    	myInteger = new Integer(n);
        myString = str;
    }

    /** 
     * Three field constructor 
     */
    public myPlants(Long id, int n, String str)
	{
        myInteger = new Integer(n);
        myString = str;
    	this.id = id;
    }
    /**
     * get the ID of the CItem 
     * @return ID 
     */
     public Long getId()
     {
 		return(id);
 	}

     /**
      * Set the ID of the CItem
      * @param id new id 
      */
 	public void setId(Long id)
 	{
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
        return(String.format("CItem [id=%d,myString=%s,myInteger=%s]", getId(), myString, myInteger));
	}

    //.For auto-generation of IDs
    private Long generateId()
    {
    	return(COUNTER++);
    }

	public String getDiscription()
	{
		return(discription);
	}

	public void setDiscription(String discription)
	{
		this.discription = discription;
	}
	//.
}
//.
