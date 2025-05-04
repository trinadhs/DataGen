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

public class LegalEntityRelations implements DropdownData{
	
	private static final String legalentityxgeography_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity-x-geography.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_legalentityxgeography(legalentityxgeography_PATH); 
		
	} 
	
	public static void Axon_SourcingTemplate_legalentityxgeography(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_geography.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";

		try { 

			System.out.print("legal-entity-X-geography File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("legalentityxgeography.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Geographies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
			int glosxobj=Integer.parseInt(configProps.getProperty("legalentityxgeography"));
			
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

				
				src_parent=obj.parentfetch(src_parent_filepath,geo_tmpl+i,0,2);
				trg_parent=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+s,0,3);
				result= data.add(new String[] {geo_tmpl+i,src_parent,legalentity_tmpl+s,trg_parent,"Is related to"});

			
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


}
