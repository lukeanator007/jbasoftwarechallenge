package jbasoftwarechallenge;

public class DataStore
{
	private int xRef, yRef, month, year, value;
	
	/**
	 * 
	 * @param xRef
	 * @param yRef
	 * @param month
	 * @param year
	 * @param value
	 */
	public DataStore(int xRef, int yRef, int month, int year, int value) 
	{
		this.xRef = xRef;
		this.yRef = yRef;
		this.month = month;
		this.year = year;
		this.value = value;
	}
	
	@Override
	public String toString() 
	{
		
		
		return "xref " + xRef + " yRef " + yRef + " date " + month + "/1/" + year + " value " + value;
	}
	
	
}
