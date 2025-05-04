package com.infa.relations;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class PeopleRelations implements DropdownData{
	
	private static final String peoplexpeople_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_people-x-people.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_peoplexpeople(peoplexpeople_PATH); 
		 	
	} 
	
	public static void Axon_SourcingTemplate_peoplexpeople(String filePath) 

	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
		String src_parent_key,trg_parent_key;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_people.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_people.csv";

		try { 

			System.out.print("people-X-people File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("peoplexpeople.header").split(",");

			writer.writeNext(header); 
			
			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
			

			int noOfRow = noOfpeoples;
			int noOfTargtrows=(int) (noOfpeoples*0.1);
			int glosxobj=Integer.parseInt(configProps.getProperty("peoplexpeople"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			BufferedReader br = new BufferedReader(new FileReader(src_parent_filepath));
			String line =null ;
			HashMap<String,String> hashmap = new HashMap<String,String>();
			
			while((line=br.readLine())!=null){
				String str[] = line.split(",");
				hashmap.put(str[0].replaceAll("\"", ""), str[15].replaceAll("\"", ""));
			}
			
			for (int i = noOfTargtrows+1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                          
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
					}                                                                                                                                                            
				}
               
				int randRelationshipType = (int) (PeoplexPeople_RelationshipType.length * Math.random());
				
				
                 src_parent_key=fisrtname_tmpl+s;
                 trg_parent_key=fisrtname_tmpl+i;
                 
				result= data.add(new String[] {people_tmpl+s+"@informatica.com",fisrtname_tmpl+s,lastname_tmpl+s,hashmap.get(src_parent_key),people_tmpl+i+"@informatica.com",fisrtname_tmpl+i,lastname_tmpl+i,hashmap.get(trg_parent_key),PeoplexPeople_RelationshipType[randRelationshipType]});
					}


			writer.writeAll(data); 

			// closing writer connection 
			br.close();
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
