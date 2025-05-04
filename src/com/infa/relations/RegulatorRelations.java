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

public class RegulatorRelations implements DropdownData {
	
	private static final String regulatorxgeography_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulator-x-geography.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_regulatorxgeography(regulatorxgeography_PATH);  	
	}
	
	public static void Axon_SourcingTemplate_regulatorxgeography(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
       // String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_geography.csv";

		try { 

			System.out.print("regulator-X-geography File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulatorxgeography.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulator"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Geographies"));
			int glosxobj=Integer.parseInt(configProps.getProperty("regulatorxgeography"));
			
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

				trg_parent=obj.parentfetch(trg_parent_filepath,geo_tmpl+s,0,2);

				result= data.add(new String[] {Segment_name+"RelDesc"+i,regulator_tmpl+i,geo_tmpl+s,trg_parent});

			
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
