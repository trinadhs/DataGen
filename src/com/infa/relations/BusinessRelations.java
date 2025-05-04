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
                                                                                                                                                                                 
public class BusinessRelations implements DropdownData {                                                                                                                     
	                                                                                                                                                                             
	private static final String businessareaxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area-x-glossary.csv";                                
	private static final String businessareaxprocess_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area-x-process.csv";                                  
	private static final String businessareaxsystem_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area-x-system.csv";                                    
	                                                                                                                                                                             
//3files 
	
	public static void main(String[] args)                                                                                                                                       
	{                                                                                                                                                                            
		  Axon_SourcingTemplate_businessareaxglossary(businessareaxglossary_PATH);                                                                                                 
		  Axon_SourcingTemplate_businessareaxprocess(businessareaxprocess_PATH);                                                                                                   
		  Axon_SourcingTemplate_businessareaxsystem(businessareaxsystem_PATH);                                                                                                     
		                                                                                                                                                                        
	}                                                                                                                                                                            
	                                                                                                                                                                             
	public static void Axon_SourcingTemplate_businessareaxglossary(String filePath)                                                                                              
	{                                                                                                                                                                            
		File file = new File(filePath);     
		Dependantdata obj=new Dependantdata();
		String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";
                                                                                                                                                                                 
		try {                                                                                                                                                                    
                                                                                                                                                                                 
			System.out.print("businsess-area-X-glossary File generation........");                                                                                                                                                                   
			Properties configProps=Utility.readPropertiesFile("config.properties");                                                                                              
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		                                                                                 
			// create FileWriter object with file as parameter                                                                                                                   
			FileWriter outputfile = new FileWriter(file);                                                                                                                        
                                                                                                                                                                                 
			// create CSVWriter object filewriter object as parameter                                                                                                            
                                                                                                                                                                                 
			CSVWriter writer = new CSVWriter(outputfile);                                                                                                                        
			                                                                                                                                                                     
			String[] header = moduleHeaderProps.getProperty("businessareaxglossary.header").split(",");                                                                          
                                                                                                                                                                                 
			writer.writeNext(header);                                                                                                                                            
                                                                                                                                                                                 
			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));                                                                                              
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.BUAreas"));                                                                                           
			int glosxobj=Integer.parseInt(configProps.getProperty("baxglossary"));                                                                                               
			                                                                                                                                                                     
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
				                                                                                                                                                                                                                                                                                                                     
				src_parent=obj.parentfetch(src_parent_filepath,Ref_gloss_tmpl+i,2,7);   //CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+s,0,2); //CAN BE REMOVED
				
				
				result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,src_parent,businessarea_tmpl+s,trg_parent,"Is related to"});  
				                                                                                                                                                             
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
                                                                                                                                                                                 
	public static void Axon_SourcingTemplate_businessareaxprocess(String filePath)                                                                                               
	{                                                                                                                                                                            
		File file = new File(filePath);   
		Dependantdata obj=new Dependantdata();
		String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";
                                                                                                                                                                                 
		try {                                                                                                                                                                    
                                                                                                                                                                                 
			System.out.print("businsess-area-X-process File generation........");                                                                                                                                                                     
			Properties configProps=Utility.readPropertiesFile("config.properties");                                                                                              
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		                                                                                 
			// create FileWriter object with file as parameter                                                                                                                   
			FileWriter outputfile = new FileWriter(file);                                                                                                                        
                                                                                                                                                                                 
			// create CSVWriter object filewriter object as parameter                                                                                                            
                                                                                                                                                                                 
			CSVWriter writer = new CSVWriter(outputfile);                                                                                                                        
                                                                                                                                                                                 
			String[] header = moduleHeaderProps.getProperty("businessareaxprocess.header").split(",");                                                                           
                                                                                                                                                                                 
			writer.writeNext(header);                                                                                                                                            
                                                                                                                                                                                 
			int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));                                                                                               
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.BUAreas"));                                                                                           
			int glosxobj=Integer.parseInt(configProps.getProperty("baxprocess"));                                                                                                
			                                                                                                                                                                     
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
                                                                                                                                                                                 
				src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+i,1,12);   //CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+s,0,2);  //CAN BE REMOVED
				
				result= data.add(new String[] {Segment_name+"This is relationship "+i,Ref_process_tmpl+i,process_tmpl+i,src_parent,businessarea_tmpl+s,trg_parent,"Is related to"});
                                                                                                                                                                                 
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
                                                                                                                                                                                 
	public static void Axon_SourcingTemplate_businessareaxsystem(String filePath)                                                                                                
	{                                                                                                                                                                            
		File file = new File(filePath);     
		Dependantdata obj=new Dependantdata();
		String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";
                                                                                                                                                                                 
		try {                                                                                                                                                                    
                                                                                                                                                                                 
			System.out.print("businsess-area-X-system File generation........");                                                                                                                                                             
			Properties configProps=Utility.readPropertiesFile("config.properties");                                                                                              
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		                                                                                 
			// create FileWriter object with file as parameter                                                                                                                   
			FileWriter outputfile = new FileWriter(file);                                                                                                                        
                                                                                                                                                                                 
			// create CSVWriter object filewriter object as parameter                                                                                                            
                                                                                                                                                                                 
			CSVWriter writer = new CSVWriter(outputfile);                                                                                                                        
                                                                                                                                                                                 
			String[] header = moduleHeaderProps.getProperty("businessareaxsystem.header").split(",");                                                                            
                                                                                                                                                                                 
			writer.writeNext(header);                                                                                                                                            
                                                                                                                                                                                 
			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems"));                                                                                               
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.BUAreas"));                                                                                           
			int glosxobj=Integer.parseInt(configProps.getProperty("baxsystem"));                                                                                                 
			                                                                                                                                                                     
			boolean result=false;                                                                                                                                                
                                                                                                                                                                                 
			List<String[]> data = new ArrayList<String[]>();                                                                                                                     
			int s=1,rel=0;                                                                                                                                                         
			                                                                                                                                                                     
			                                                                                                                                               
                                                                                                                                                                                 
			for (int i = 1; i <= noOfRow; i++) {                                                                                                                                 
				                                                                                                                                                                 
				if(s<=noOfTargtrows) {                                                                                                                                           
					  rel++;
					  if(rel>glosxobj) {
						  s++;
						  rel=1;
					  }
					                                                                                                                                                        
				}                                                                                                                                                          
                         
				src_parent=obj.parentfetch(src_parent_filepath,sys_tmpl+i,0,6); // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+s,0,2);      // CAN BE REMOVED                                                                                                                                                          
				result= data.add(new String[] {sys_tmpl+i,src_parent,businessarea_tmpl+s,trg_parent,"Is related to"});                                                              
                                                                                                                                                                                 
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
                                                                                                                                                                                 