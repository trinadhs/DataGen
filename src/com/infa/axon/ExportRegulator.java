package com.infa.axon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class ExportRegulator implements DropdownData {

//private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulator.csv"; 
//	
//    public static void main(String[] args) 
//    { 
//    	Axon_SourcingTemplate_regulator(CSV_FILE_PATH); 
//    } 

    
    

public static void Axon_SourcingTemplate_regulator(String filePath) 
{ 
File file = new File(filePath); 
   	
    try { 
	          
    	System.out.print("Regulator File generation........");
    	
    	Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		
     	// create FileWriter object with file as parameter 
        FileWriter outputfile = new FileWriter(file); 
  
        CSVWriter writer = new CSVWriter(outputfile); 
		String[] header = moduleHeaderProps.getProperty("regulator.header").split(",");
       
        writer.writeNext(header); 
		int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulator"));

		boolean result=false; 
	    			
        List<String[]> data = new ArrayList<String[]>(); 
		
		 for (int i = 1; i <= noOfRow; i++) {
									 	
           result= data.add(new String[] {regulator_tmpl+i,"Short name of "+regulator_tmpl+i,"Description of "+regulator_tmpl+i,Segment_name}); 
	     //      result= data.add(new String[] {Segment_name+"Regulator"+i,"Short name of "+Segment_name+"Regulator"+i,"Description of "+Segment_name+"Regulator"+i,"Finance"}); 

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
