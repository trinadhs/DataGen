package com.infa.relations;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infa.data.DropdownData;

public class ProcessxProcess implements DropdownData{

	
	public static void main(String[] args) 
	{ 
		procxproc(); 
	} 
	
	public  static ArrayList<String> procxproc() {
		try {
	            
			 //Reader readerrel = Files.newBufferedReader(Paths.get("./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-businessarea.csv"));
	        // CSVParser csvParserrel = new CSVParser(readerrel, CSVFormat.DEFAULT);
			String filepath = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
			
			Reader readerobj = Files.newBufferedReader(Paths.get(filepath));
	        
			CSVParser csvParserobj = new CSVParser(readerobj, CSVFormat.DEFAULT);
	        
			String Ref = "Control";
	        int Refcolumn = 16;
	        int procolumn =0,refprocolumn=1,parentprocess=12; 
	        /*Map<String, List<String>> map = new HashMap<String, List<String>>();
	        
	        List<String> ConProc = new ArrayList();*/
	        
	        ArrayList<String> ConProc = new ArrayList<String>();
	        String ProcRef;
	           
	            for (CSVRecord csvRecord : csvParserobj) {
	               
	            	if(Ref.equals(csvRecord.get(Refcolumn))) {
	                
	            	ProcRef = csvRecord.get(refprocolumn);
	            	ConProc.add(ProcRef);
		            //result[1] = csvRecord.get(seconddata_column);     
	            	}
	            }
	            
            	/*System.out.println(ConProc);
            	System.out.println(ConProc.size());*/
		     return ConProc;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
}
}