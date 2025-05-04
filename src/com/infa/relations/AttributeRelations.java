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
//import com.infa.relations.Trial;

import com.opencsv.CSVWriter;

import utility.Utility;

public class AttributeRelations implements DropdownData{
	
	private static final String attributexattribute_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute-x-attribute.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_attributexattribute(attributexattribute_PATH);
 				
	}
	
	public static void Axon_SourcingTemplate_attributexattribute(String filePath) 

	{ 
		File file = new File(filePath); 
		
		Dependantdata obj=new Dependantdata();
        String src_parent_key, trg_parent_key;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
		//String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
		
		try { 

			System.out.print("attribute-x-attribute File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("attributexattribute.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Attributes"));
			int noOfTargtrows=(int) (Integer.parseInt(configProps.getProperty("No.Attributes")) * 0.2);
			int glosxobj=Integer.parseInt(configProps.getProperty("attributexattribute"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			BufferedReader br = new BufferedReader(new FileReader(src_parent_filepath));
			String line =null ;
			HashMap<String,String> DS_hashmap = new HashMap<String,String>();
			HashMap<String,String> Sys_hashmap = new HashMap<String,String>();
			
			
			
			while((line=br.readLine())!=null){
				String str[] = line.split(",");
				DS_hashmap.put(str[0].replaceAll("\"", ""), str[8].replaceAll("\"", ""));
				Sys_hashmap.put(str[0].replaceAll("\"", ""), str[9].replaceAll("\"", ""));	
			}
			
			
			for (int i = noOfTargtrows+1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                          
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
					}                                                                                                                                                            
				}
				
				//System.out.println("***********"+i);
				//System.out.println(DS_hashmap.get(Ref_attrib_tmpl+s));
				//String[] details1=obj.indirect_dependency_data(src_parent_filepath,Ref_attrib_tmpl+i,0,8,9); 	
				//String[] details=obj.indirect_dependency_data(src_parent_filepath,Ref_attrib_tmpl+randtargetobjs,0,8,9); 
				//System.out.println(details1+"*****************\n");
				//System.out.println(details+"*****************\n");
	
				
				int randSourcingType = (int) (AttributexAttribute_SourcingType.length * Math.random());
				int randScopeOfData = (int) (AttributexAttribute_ScopeOfData.length * Math.random());
				
				src_parent_key= Ref_attrib_tmpl+s;
				trg_parent_key=Ref_attrib_tmpl+i;

				result= data.add(new String[] {Segment_name+"Logic"+i,AttributexAttribute_SourcingType[randSourcingType],Ref_attrib_tmpl+s,attrib_tmpl+s,DS_hashmap.get(src_parent_key),Sys_hashmap.get(src_parent_key),Ref_attrib_tmpl+i,attrib_tmpl+i,DS_hashmap.get(trg_parent_key),Sys_hashmap.get(trg_parent_key),AttributexAttribute_ScopeOfData[randScopeOfData],"","",""});
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 
			br.close();

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
