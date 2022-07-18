package jbasoftwarechallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("C:\\Users\\lukea\\eclipse-workspace\\jbasoftwarechallenge\\src\\jbasoftwarechallenge\\data.txt");
		int startYear = -1;
		int endYear = -1;
		
		int currentX = -1;
		int currentY = -1;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {

	    		int startIndex;
	    		if((startIndex = line.indexOf("[Years")) == -1) continue;
	    		
	    		int endIndex = line.indexOf("]", startIndex);
	    		String toParse = line.substring(startIndex + "[Years".length(), endIndex);
	    		
	    		String[] years = toParse.split("-");
	    		startYear = Integer.parseInt(years[0].substring(1));
	    		endYear = Integer.parseInt(years[1]);
	    		break;
		    }
		    while((line = br.readLine()) != null) 
		    {
    			String str = line.substring("Grid-ref=".length()+1);
    			String[] xyValues = str.split(",");
    			xyValues[0] = xyValues[0].strip();
    			xyValues[1] = xyValues[1].strip();
    			currentX = Integer.parseInt(xyValues[0]);
    			currentY = Integer.parseInt(xyValues[1]);
    			
    			for(int currentYear = startYear; currentYear <= endYear; currentYear++) 
    			{
    				line = br.readLine();
	    			String[] numbers = line.split(" ");
	    			
	    			int month = 1;
	    			
	    			for(int i=0;i<numbers.length;i++) 
	    			{
	    				if(numbers[i].length() > 0) 
	    				{
	    					int value = Integer.parseInt(numbers[i]);
	    					storeData(new DataStore(currentX, currentY, month, currentYear, value));
	    					month++;
	    				}
	    			}
    			}
		    }
		}

	}
	
	private static void storeData(DataStore data) 
	{
		System.out.println(data.toString());
	}
	
	

	
	
	
}















