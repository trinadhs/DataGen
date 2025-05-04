package com.infa.relations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.infa.data.DropdownData;
//import com.infa.relations.Trial;

import com.opencsv.CSVWriter;

import utility.Utility;

public class CapabilityRelations implements DropdownData {
	
	private static final String capabilityxbusinessarea_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-business-area.csv";
	private static final String capabilityxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-client.csv";
	private static final String capabilityxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-glossary.csv";
	private static final String capabilityxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-legal-entity.csv";
	private static final String capabilityxprocess_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-process.csv";
	private static final String capabilityxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-product.csv";
	private static final String capabilityxsystem_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability-x-system.csv";

	
	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_capabilityxbusinessarea(capabilityxbusinessarea_PATH); 
		Axon_SourcingTemplate_capabilityxclient(capabilityxclient_PATH); 
		Axon_SourcingTemplate_capabilityxglossary(capabilityxglossary_PATH); 
		Axon_SourcingTemplate_capabilityxlegalentity(capabilityxlegalentity_PATH); 
		Axon_SourcingTemplate_capabilityxprocess(capabilityxprocess_PATH); 
		Axon_SourcingTemplate_capabilityxproduct(capabilityxproduct_PATH); 
		Axon_SourcingTemplate_capabilityxsystem(capabilityxsystem_PATH); 
		
	} 
	
	public static void Axon_SourcingTemplate_capabilityxbusinessarea(String filePath) 
	{ 
		File file = new File(filePath); 
		
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";

		try { 

			System.out.print("capability-X-business-area File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxbusinessarea.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.BUAreas"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxba"));
			
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

				//System.out.println("***********"+i);
				src_parent=obj.parentfetch(src_parent_filepath,Ref_capability_tmpl+i,0,3); 		// CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+s,0,2); // CAN BE REMOVED
				//System.out.println();
				
				
				result= data.add(new String[] {Ref_capability_tmpl+i,capability_tmpl+i,src_parent,businessarea_tmpl+s,trg_parent,"Capability is related to Business Area"});
			
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

	public static void Axon_SourcingTemplate_capabilityxclient(String filePath) 

	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";
		try { 

			
			System.out.print("capability-X-client File generation........"); 
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxclient"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,client_tmpl+s,0,3); // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+i,0,3); 	// CAN BE REMOVED	

				result= data.add(new String[] {client_tmpl+s,src_parent,Ref_capability_tmpl+i,capability_tmpl+i,trg_parent,"Is related to"});
		
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

	public static void Axon_SourcingTemplate_capabilityxglossary(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";

		try { 

			System.out.print("capability-X-glossary File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxglossary"));
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_gloss_tmpl+i,2,7); // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+s,0,3); // CAN BE REMOVED
				
				//result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,"",Ref_gloss_tmpl+randtargetobjs,gloss_tmpl+randtargetobjs,"","Capability is related to Business Area"}); 
				result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,src_parent,Ref_capability_tmpl+s,capability_tmpl+s,trg_parent,"Is related to"});

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

	public static void Axon_SourcingTemplate_capabilityxlegalentity(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";

		try { 

			System.out.print("capability-X-legal-entity File generation........"); 
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxlegalentity.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxlegalentity"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_capability_tmpl+i,0,3); 	// CAN BE REMOVED	
				trg_parent=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+s,0,3); // CAN BE REMOVED
				
				result= data.add(new String[] {Ref_capability_tmpl+i,capability_tmpl+i,src_parent,legalentity_tmpl+s,trg_parent,"Capability is related to Legal Entity"});

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
	
	public static void Axon_SourcingTemplate_capabilityxprocess(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";

		try { 

			System.out.print("capability-X-process File generation........"); 
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxprocess.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxprocess"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+i,1,12); // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+s,0,3); // CAN BE REMOVED
				result= data.add(new String[] {Ref_process_tmpl+i,process_tmpl+i,src_parent,Ref_capability_tmpl+s,capability_tmpl+s,trg_parent,"Is related to"});
			
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

	public static void Axon_SourcingTemplate_capabilityxproduct(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";

		try { 

			System.out.print("capability-X-product File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxproduct"));
			
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
 
				src_parent=obj.parentfetch(src_parent_filepath,Ref_product_tmpl+s,0,4); // CAN BE REMOVED
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+i,0,3); // CAN BE REMOVED
				result= data.add(new String[] {product_tmpl+s,src_parent,Ref_capability_tmpl+i,capability_tmpl+i,trg_parent,"Is related to"});

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
	
	public static void Axon_SourcingTemplate_capabilityxsystem(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";

		try { 

			System.out.print("capability-X-system File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capabilityxsystem.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int glosxobj=Integer.parseInt(configProps.getProperty("capabilityxsystem"));
			
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
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+s,0,3); // CAN BE REMOVED
 
				result= data.add(new String[] {sys_tmpl+i,src_parent,Ref_capability_tmpl+s,capability_tmpl+s,trg_parent,"Capability Is supported by System"});

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
