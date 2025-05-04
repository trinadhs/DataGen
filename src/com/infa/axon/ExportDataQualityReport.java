package com.infa.axon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class ExportDataQualityReport implements DropdownData {
	
//private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-quality-report.csv"; 
//	
//    public static void main(String[] args) 
//    { 
//    	Axon_SourcingTemplate_dataqualityreport(CSV_FILE_PATH); 
//    } 


public static void Axon_SourcingTemplate_dataqualityreport(String filePath) 
{ 
File file = new File(filePath); 
   	
    try { 
    	System.out.print("DataQuality Report File generation........");
	       
    	    	 
    	Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		
		// create FileWriter object with file as parameter 
        FileWriter outputfile = new FileWriter(file); 
  
        // create CSVWriter object filewriter object as parameter 
       
        CSVWriter writer = new CSVWriter(outputfile); 
		
		
		
		String[] header = moduleHeaderProps.getProperty("dqreport.header").split(",");
       
        writer.writeNext(header); 
		
					
		int noOfRow = Integer.parseInt(configProps.getProperty("No.Dqreport"));
		
		boolean result=false; 
	    			
        List<String[]> data = new ArrayList<String[]>(); 
		
		 for (int i = 1; i <= noOfRow; i++) {
			 
			 Random r = new Random();
			 int low = 50;
			 int high = 100;
			 int randno = r.nextInt(high-low) + low;
			 
					 	
           result= data.add(new String[] {"28/08/2019",""+randno,"ReportURL"+i,"13","1000","Ref-"+Segment_name+"Rule"+i}); 
           }
          
		  	
		writer.writeAll(data); 
  
        // closing writer connection 
        writer.close(); 
        
        if(result) {
        	System.out.print("Completed.\n");
		}
        
        
    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
    } 
    
} 
	

}
