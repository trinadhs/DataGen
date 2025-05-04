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
public class RegulationRelations implements DropdownData{
	
	private static final String regulationxpolicy_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation-x-policy.csv";
	private static final String regulationxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation-x-product.csv";
	private static final String regulationxproject_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation-x-project.csv";
	private static final String regulationxregulator_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation-x-regulator.csv";
	private static final String regulationxregulatorytheme_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation-x-regulatory-theme.csv";

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_regulationxpolicy(regulationxpolicy_PATH); 
		Axon_SourcingTemplate_regulationxproduct(regulationxproduct_PATH); 
		Axon_SourcingTemplate_regulationxproject(regulationxproject_PATH); 
		Axon_SourcingTemplate_regulationxregulator(regulationxregulator_PATH); 
		Axon_SourcingTemplate_regulationxregulatorytheme(regulationxregulatorytheme_PATH);  	
	}
	
	public static void Axon_SourcingTemplate_regulationxpolicy(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";

		try { 

			System.out.print("regulation-X-policy File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulationxpolicy.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulation"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Policies"));
			int glosxobj=Integer.parseInt(configProps.getProperty("regulationxpolicy"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_regulation_tmpl+i,0,10);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_policy_tmpl+s,1,7);

				result= data.add(new String[] {Ref_regulation_tmpl+i,regulation_tmpl+i,src_parent,Ref_policy_tmpl+s,policy_tmpl+s,trg_parent,"Regulation affects Policy"});	
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

	public static void Axon_SourcingTemplate_regulationxproduct(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
        
		try { 

			System.out.print("regulation-X-product File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulationxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulation"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
			int glosxobj=Integer.parseInt(configProps.getProperty("regulationxproduct"));
			
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
				
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_regulation_tmpl+i,0,10);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_product_tmpl+s,0,4);
 
				result= data.add(new String[] {Ref_regulation_tmpl+i,regulation_tmpl+i,src_parent,product_tmpl+s,trg_parent,"Is related to"});

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
	
	public static void Axon_SourcingTemplate_regulationxproject(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";

		try { 

			System.out.print("regulation-X-project File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulationxproject.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulation"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("regulationxproject"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_regulation_tmpl+i,0,10);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);
				
				result= data.add(new String[] {Ref_regulation_tmpl+i,regulation_tmpl+i,src_parent,Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Project is implementing Regulation"});

			
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
	
	public static void Axon_SourcingTemplate_regulationxregulator(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
        //String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulator.csv";

		try { 

			System.out.print("regulation-X-regulation File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulationxregulator.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulation"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Regulator"));
			int glosxobj=Integer.parseInt(configProps.getProperty("regulationxregulator"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_regulation_tmpl+i,0,10);
				//trg_parent=obj.parentfetch(trg_parent_filepath,Ref_product_tmpl+randtargetobjs,0,4);
				
				result= data.add(new String[] {Ref_regulator_tmpl+s,Ref_regulation_tmpl+i,regulation_tmpl+i,src_parent,regulator_tmpl+s});

			
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

	public static void Axon_SourcingTemplate_regulationxregulatorytheme(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulatory-theme.csv";

		try { 

			System.out.print("regulation-X-RT File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulationxregulatorytheme.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulation"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Regulatorytheme"));
			int glosxobj=Integer.parseInt(configProps.getProperty("regulationxregulatorytheme"));
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_regulation_tmpl+i,0,10);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_RT_tmpl+s,0,4);
				
				result= data.add(new String[] {Ref_regulation_tmpl+i,regulation_tmpl+i,src_parent,Ref_RT_tmpl+s,RT_tmpl+s,trg_parent,"Is related to"});

		
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
