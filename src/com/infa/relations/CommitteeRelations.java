package com.infa.relations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class CommitteeRelations implements DropdownData{

	private static final String committeexcapability_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee-x-capability.csv";
	private static final String committeexcommittee_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee-x-committee.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_committeexcapability(committeexcapability_PATH); 
		Axon_SourcingTemplate_committeexcommittee(committeexcommittee_PATH);  
		
	}
	public static void Axon_SourcingTemplate_committeexcapability(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";

		try { 

			System.out.print("committee-X-capability File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("committeexcapability.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Committees"));
			int glosxobj=Integer.parseInt(configProps.getProperty("committeexcapability"));
			//System.out.println(noOfRow);
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			

			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>glosxobj) {
							break;
						}
					}                                                                                                                                                            
				} 

				src_parent=obj.parentfetch(src_parent_filepath,Ref_committee_tmpl+s,0,3);  // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+i,0,3); // CAN BE REMOVED
				
				result= data.add(new String[] {Ref_committee_tmpl+s,committee_tmpl+s,src_parent,Ref_capability_tmpl+i,capability_tmpl+i,trg_parent,"Is related to"});
	
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("COMPLETED\n");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}

	public static void Axon_SourcingTemplate_committeexcommittee(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee.csv";


		try { 

			System.out.print("committee-X-committee File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("committeexcommittee.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Committees"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Committees"));
			int glosxobj=Integer.parseInt(configProps.getProperty("committeexcommittee"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=1;
			
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						
					}                                                                                                                                                            
				} 
				src_parent=obj.parentfetch(src_parent_filepath,Ref_committee_tmpl+i,0,3); // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_committee_tmpl+s,0,3); // CAN BE REMOVED
				result= data.add(new String[] {Ref_committee_tmpl+i,committee_tmpl+i,src_parent,Ref_committee_tmpl+s,committee_tmpl+s,trg_parent,"Rolls up Into"});

		}
			
		writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("COMPLETED");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}

}
