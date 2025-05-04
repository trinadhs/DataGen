package com.infa.relations;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.awt.List;
import java.io.File;
import java.io.FileReader;  
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;


import com.opencsv.CSVReader;  
import com.infa.data.DropdownData;

public class Dependantdata implements DropdownData{

	
	public String parentfetch(String filepath,String Ref,int Refcolumn,int parentcolumn) {
		try {
	            
			 //Reader readerrel = Files.newBufferedReader(Paths.get("./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-businessarea.csv"));
	        // CSVParser csvParserrel = new CSVParser(readerrel, CSVFormat.DEFAULT);
			
			Reader readerobj = Files.newBufferedReader(Paths.get(filepath));
	            CSVParser csvParserobj = new CSVParser(readerobj, CSVFormat.DEFAULT);
	           
	            for (CSVRecord csvRecord : csvParserobj) {
	                // Accessing Values by Column Index
	            	//String ref="Ref-HRCapability3";
	            	if(Ref.equals(csvRecord.get(Refcolumn))) {
	                String parent = csvRecord.get(parentcolumn);
	                //System.out.println(Ref+"		"+parent);
	                return parent;
	            	}
	            }
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		}
	
	public static String[] indirect_dependency_data(String filepath,String Ref, int Refcolumn,int firstdata_column,int seconddata_column) throws IOException {
		Reader readerobj = Files.newBufferedReader(Paths.get(filepath));
		try {
            
			String result[]= new String[2];

	            CSVParser csvParserobj = new CSVParser(readerobj, CSVFormat.DEFAULT);
	           
	            for (CSVRecord csvRecord : csvParserobj) {
	            
	            	if(Ref.equals(csvRecord.get(Refcolumn))) {
	                
	            	//String firstdata = csvRecord.get(firstdata_column);
	                //String seconddata = csvRecord.get(seconddata_column);
	                result[0] = csvRecord.get(firstdata_column);
	                result[1] = csvRecord.get(seconddata_column);
	                //System.out.println(Ref+"		"+result[0]+"		"+result[1]);
	                
	                //return Arrays.asList(firstdata,seconddata);
	                return result;
	            	}
	            }
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(readerobj!=null) {
				readerobj.close();
			}
			
		}
		return null;
		
	}
	
	
	public static String[] indirect_dependency_data(String filepath,String Ref, int Refcolumn,int firstdata_column,int seconddata_column, int thirddata_column) throws IOException {
		Reader readerobj = Files.newBufferedReader(Paths.get(filepath));
		try {
            
			String result[]= new String[3];

	            CSVParser csvParserobj = new CSVParser(readerobj, CSVFormat.DEFAULT);
	           
	            for (CSVRecord csvRecord : csvParserobj) {
	            
	            	if(Ref.equals(csvRecord.get(Refcolumn))) {
	                
	            	//String firstdata = csvRecord.get(firstdata_column);
	                //String seconddata = csvRecord.get(seconddata_column);
	                result[0] = csvRecord.get(firstdata_column);
	                result[1] = csvRecord.get(seconddata_column);
	                result[2] = csvRecord.get(thirddata_column);
	                //System.out.println(Ref+"		"+result[0]+"		"+result[1]);
	                
	                //return Arrays.asList(firstdata,seconddata);
	                return result;
	            	}
	            }
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(readerobj!=null) {
				readerobj.close();
			}
			
		}
		return null;
		
	}
}
