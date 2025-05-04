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

public class InterfaceRelations implements DropdownData{
	
	private static final String interfacexglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_interface-x-glossary.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_interfacexglossary(interfacexglossary_PATH);
 				
	}
	
	public static void Axon_SourcingTemplate_interfacexglossary(String filePath) 

	{ 
		File file = new File(filePath); 
		
		Dependantdata obj=new Dependantdata();
        String trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_interface.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";
		
		try { 
			System.out.print("interface-X-glossary File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("interfacexglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Interface"));
			int glosxobj=Integer.parseInt(configProps.getProperty("interfacexglossary"));
			
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

				
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_gloss_tmpl+i,2,7);  // CAN BE REMOVED
				//String[] details1=obj.indirect_dependency_data(src_parent_filepath,Ref_attrib_tmpl+i,0,8,9); 	
				String[] details=obj.indirect_dependency_data(src_parent_filepath,Ref_interface_tmpl+s,1,10,11);
				//System.out.println();
				

				result= data.add(new String[] {"Expected Glossary Item Coverage",Ref_interface_tmpl+s,interface_tmpl+s,details[0],details[1],Ref_gloss_tmpl+i,gloss_tmpl+i,trg_parent});
			
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
