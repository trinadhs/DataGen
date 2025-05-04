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

public class ProductRelations implements DropdownData{

	private static final String productxbusinessarea_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product-x-business-area.csv";
	private static final String productxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product-x-client.csv";
	private static final String productxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product-x-legal-entity.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_productxbusinessarea(productxbusinessarea_PATH); 
		Axon_SourcingTemplate_productxclient(productxclient_PATH); 
		Axon_SourcingTemplate_productxlegalentity(productxlegalentity_PATH); 	
	} 
		
	public static void Axon_SourcingTemplate_productxbusinessarea(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
	    String src_parent,trg_parent;
	    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";

		try { 


			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("productxbusinessarea.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Product"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.BUAreas"));
			int glosxobj=Integer.parseInt(configProps.getProperty("productxba"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			while(x<=glosxobj) {

			for (int i = 1; i <= noOfRow; i++) {
				
				int randtargetobjs = (int) (noOfTargtrows * Math.random())+1;
				
				if(s<=noOfTargtrows) {
					s++;
					if(s>noOfTargtrows)
					{
						s=1;
					}
				}
				else if(s>noOfTargtrows)
				{
					s=1;
				}

				if(s==randtargetobjs) {
					randtargetobjs= (int) (noOfTargtrows * Math.random())+1; 
				}
				src_parent=obj.parentfetch(src_parent_filepath,Ref_product_tmpl+i,0,4); 	
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+randtargetobjs,0,2); 	
				result= data.add(new String[] {Ref_product_tmpl+i,product_tmpl+i,src_parent,businessarea_tmpl+randtargetobjs,trg_parent,"Is related to"});

			}x++;
			
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("productxbusinessarea file Upload pass");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}

	public static void Axon_SourcingTemplate_productxclient(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
	    String src_parent,trg_parent;
	    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";

		try { 


			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("productxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Product"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
			int glosxobj=Integer.parseInt(configProps.getProperty("productxclient"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			while(x<=glosxobj) {

			for (int i = 1; i <= noOfRow; i++) {
				
				int randtargetobjs = (int) (noOfTargtrows * Math.random())+1;
				
				if(s<=noOfTargtrows) {
					s++;
					if(s>noOfTargtrows)
					{
						s=1;
					}
				}
				else if(s>noOfTargtrows)
				{
					s=1;
				}

				if(s==randtargetobjs) {
					randtargetobjs= (int) (noOfTargtrows * Math.random())+1; 
				}
 
				src_parent=obj.parentfetch(src_parent_filepath,Ref_product_tmpl+i,0,4); 	
				trg_parent=obj.parentfetch(trg_parent_filepath,client_tmpl+randtargetobjs,0,3); 	
				result= data.add(new String[] {Ref_product_tmpl+i,product_tmpl+i,src_parent,client_tmpl+randtargetobjs,trg_parent,"Is related to"});

			}x++;
			
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("productxclient file Upload pass");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}
	
	public static void Axon_SourcingTemplate_productxlegalentity(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
	    String src_parent,trg_parent;
	    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";

		try { 


			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("productxlegalentity.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Product"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
			int glosxobj=Integer.parseInt(configProps.getProperty("productxlegalentity"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			while(x<=glosxobj) {

			for (int i = 1; i <= noOfRow; i++) {
				
				int randtargetobjs = (int) (noOfTargtrows * Math.random())+1;
				
				if(s<=noOfTargtrows) {
					s++;
					if(s>noOfTargtrows)
					{
						s=1;
					}
				}
				else if(s>noOfTargtrows)
				{
					s=1;
				}

				if(s==randtargetobjs) {
					randtargetobjs= (int) (noOfTargtrows * Math.random())+1; 
				}

				//int randRelationshipType = (int) (ProcessxLegalentity_RelationshipType.length * Math.random());
				src_parent=obj.parentfetch(src_parent_filepath,Ref_product_tmpl+i,0,4); 	
				trg_parent=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+randtargetobjs,0,3); 	
				result= data.add(new String[] {Ref_product_tmpl+i,product_tmpl+i,src_parent,legalentity_tmpl+randtargetobjs,trg_parent,"Is related to"});

			}x++;
			
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("productxlegalentity file Upload pass");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}
}
