package com.infa.axon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.Properties;
import com.infa.data.DropdownData;

import utility.Utility;
import com.opencsv.CSVWriter;



public class SplitAttributes  implements DropdownData{
	

	public static void myFunction(int lines, int files) throws FileNotFoundException, IOException{

	    String inputfile = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
	    BufferedReader br = new BufferedReader(new FileReader(inputfile)); //reader for input file intitialized only once
	    String strLine = null; 
	    for (int i=1;i<=files;i++) {
	    	
	        FileWriter fstream1 = new FileWriter("./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute_"+i+".csv"); //creating a new file writer.       
	        BufferedWriter out = new BufferedWriter(fstream1);  
	        if (i==1) {
	        for(int j=0;j<=lines;j++){   //iterating the reader to read only the first few lines of the csv as defined earlier
	             strLine = br.readLine();   
	            if (strLine!= null) { 
	               String strar[] = strLine.split(";");
	               out.write(strar[0]);   //acquring the first column
	               out.newLine();   
	            	} 
	        	}
	        }
	        else {
	          
	        	Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");
            	String[] header = moduleHeaderProps.getProperty("attribute.header").split(";");
    		   	out.write(header[0]);
    		   	out.newLine();
            	
	        	for(int j=0;j<=lines;j++){   //iterating the reader to read only the first few lines of the csv as defined earlier
		             strLine = br.readLine(); 
		           
		             
		            if (strLine!= null) { 

		               String strar[] = strLine.split(";");
		               out.write(strar[0]);   //acquring the first column
		               out.newLine();   
		            	} 
		        	}
	        }
	        out.close(); 
	        }  
	   }

	public static void main(String args[])  
	{  
	 try{  
		 
		 System.out.print("Attribute File splits.......");
		 
		 Properties configProps=Utility.readPropertiesFile("config.properties");
		 int lines= Integer.parseInt(configProps.getProperty("File_MaxLines"));
	     //int lines = 50000;  //set this to whatever number of lines you need in each file
	     int count = 0;
	     String inputfile = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
	     File file = new File(inputfile);  
	     Scanner scanner = new Scanner(file);  
	     while (scanner.hasNextLine()) {  //counting the lines in the input file
	        scanner.nextLine();  
	        count++;  
	      }  
	    // System.out.println(count);
	     int files=0;  
	     if((count%lines)==0){  
	        files= (count/lines);  
	      }  
	      else{  
	         files=(count/lines)+1;  
	      }   
	     
	     //System.out.println(files); //number of files that shall eb created
    
	      myFunction(lines,files);
	      
	      System.out.print("Completed.\n");
	 }

	 catch (FileNotFoundException e) {
	       e.printStackTrace();
	 }
	 catch (IOException e) {
	  e.printStackTrace();
	 }
	}  
	
	
	
}



