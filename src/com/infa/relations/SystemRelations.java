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

public class SystemRelations implements DropdownData {
	
	private static final String systemxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system-x-glossary.csv";
	private static final String systemxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system-x-client.csv";
	private static final String systemxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system-x-legal-entity.csv";
	private static final String systemxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system-x-product.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_systemxglossary(systemxglossary_PATH); 
		Axon_SourcingTemplate_systemxclient(systemxclient_PATH); 
		Axon_SourcingTemplate_systemxlegalentity(systemxlegalentity_PATH); 
		Axon_SourcingTemplate_systemxproduct(systemxproduct_PATH); 

	}
	
	public static void Axon_SourcingTemplate_systemxglossary(String filePath) 

	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";

		try { 

			System.out.print("system-X-glossary File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("systemxglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Systems"));
			int glosxobj=Integer.parseInt(configProps.getProperty("systemxglossary"));
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_gloss_tmpl+i,2,7);
				//String[] details=obj.indirect_dependency_data(src_parent_filepath,Ref_gloss_tmpl+randtargetobjs,0,2,3); 

				int randRelationshipType = (int) (SystemxGlossary_RelationshipType.length * Math.random()); 

				result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,src_parent,sys_tmpl+s,"","",SystemxGlossary_RelationshipType[randRelationshipType]});

			
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

	
	public static void Axon_SourcingTemplate_systemxclient(String filePath) 

	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";

		try { 

			System.out.print("system-X-client File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("systemxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
			int glosxobj=Integer.parseInt(configProps.getProperty("systemxclient"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,client_tmpl+s,0,3); 
				trg_parent=obj.parentfetch(trg_parent_filepath,sys_tmpl+i,0,6);

				result= data.add(new String[] {client_tmpl+s,src_parent,sys_tmpl+i,trg_parent,"Is related to"});
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
	
	public static void Axon_SourcingTemplate_systemxlegalentity(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";

		try { 

			System.out.print("system-X-legal-entity File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("systemxlegalentity.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
			int glosxobj=Integer.parseInt(configProps.getProperty("systemxlegalentity"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,sys_tmpl+i,0,6);
				trg_parent=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+s,0,3); 
				
				
				int randRelationshipType = (int) (SystemxLegalentity_RelationshipType.length * Math.random()); 
				result= data.add(new String[] {sys_tmpl+i,src_parent,legalentity_tmpl+s,trg_parent,SystemxLegalentity_RelationshipType[randRelationshipType]});
			
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

	public static void Axon_SourcingTemplate_systemxproduct(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,targetLE;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";

		try { 

			System.out.print("system-X-product File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("systemxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
			int glosxobj=Integer.parseInt(configProps.getProperty("systemxproduct"));
			int noOfLE = Integer.parseInt(configProps.getProperty("No.Legalentity"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1,LE=0;
			
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
				
				if(LE <= noOfLE) {
					LE++;
					if(LE > noOfLE) {
						LE=1;
					}
				}
				
				
				src_parent=obj.parentfetch(src_parent_filepath,product_tmpl+s,1,4); 
				
				//List<Object> details = obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+randtargetobjs,0,6,7);
				//System.out.println("cap	"+parent);		
				targetLE=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+LE,0,3); 
				
				
				int randRelationshipType = (int) (SystemxProduct_ProductLegalEntityType.length * Math.random()); 
				result= data.add(new String[] {product_tmpl+s,src_parent,sys_tmpl+i,"Is related to",SystemxProduct_ProductLegalEntityType[randRelationshipType],legalentity_tmpl+LE,targetLE});

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
