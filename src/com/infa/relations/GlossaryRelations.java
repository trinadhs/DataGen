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

public class GlossaryRelations implements DropdownData    {

	private static final String glossaryxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary-x-glossary.csv"; 
	private static final String glossaryxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary-x-client.csv"; 
	private static final String glossaryxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary-x-product.csv"; 

	

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_glossaryxclient(glossaryxclient_PATH);
		Axon_SourcingTemplate_glossaryxproduct(glossaryxproduct_PATH);
		Axon_SourcingTemplate_glossaryxglossary(glossaryxglossary_PATH); 

		
	} 

/*  Not working changed by kavya
	public static void Axon_SourcingTemplate_glossaryxglossary(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";

		try { 

			System.out.print("glossary-X-glossary File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("glossaryxglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Glossary"));
			int glosxobj=Integer.parseInt(configProps.getProperty("glosxglossrel"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			int s=1;
		
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
					//	System.out.println("valueof S="+s);
						
					}                                                                                                                                                            
				} 

				src_parent=obj.parentfetch(src_parent_filepath,Ref_gloss_tmpl+i,2,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_gloss_tmpl+s,2,7);
				
				result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,src_parent,Ref_gloss_tmpl+s,gloss_tmpl+s,trg_parent,"Is Related to"}); 
			
			
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

	*/
	
	public static void Axon_SourcingTemplate_glossaryxglossary(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 

			System.out.print("glossary-X-glossary File generation........");
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("glossaryxglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Glossary"));
			int glosxglossrel=Integer.parseInt(configProps.getProperty("glosxglossrel"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			int s=0,x=1;
			
			while(x<=glosxglossrel) {

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


				result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,"",Ref_gloss_tmpl+randtargetobjs,gloss_tmpl+randtargetobjs,"","Is Related to"}); 
			}x++;
			
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
	
		
	public static void Axon_SourcingTemplate_glossaryxclient(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";

		try { 

			System.out.print("glossary-X-client File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("glossaryxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			//System.out.println("value of noOFRow "+noOfRow);
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
			//System.out.println("value of noOfTargtrows "+noOfTargtrows);
			int glosxobj=Integer.parseInt(configProps.getProperty("glosxclient"));
			//System.out.println("value of glosxobj "+glosxobj);
			
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
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_gloss_tmpl+i,2,7); 
				
				result= data.add(new String[] {client_tmpl+s,src_parent,Ref_gloss_tmpl+i,gloss_tmpl+i,trg_parent,"Is related to"});
				
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
	
	public static void Axon_SourcingTemplate_glossaryxproduct(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";

		try { 

			System.out.print("glossary-X-product File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("glossaryxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
			int glosxobj=Integer.parseInt(configProps.getProperty("glosxproduct"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_product_tmpl+s,0,4);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_gloss_tmpl+i,2,7); 

				result= data.add(new String[] {product_tmpl+s,src_parent,Ref_gloss_tmpl+i,gloss_tmpl+i,trg_parent,"Is related to"});
			
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
