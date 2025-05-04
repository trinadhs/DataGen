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


public class PolicyRelations implements DropdownData {
	private static final String policyxbusinessarea_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-business-area.csv";
	private static final String policyxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-client.csv";
	private static final String policyxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-glossary.csv";
	private static final String policyxpolicy_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-policy.csv";
	private static final String policyxprocess_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-process.csv";
	private static final String policyxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-product.csv";
	private static final String policyxproject_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-project.csv";
	private static final String policyxsystem_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-system.csv";
	private static final String policyxattribute_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-attribute.csv";
	private static final String policyxdataset_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-data-set.csv";
	private static final String policyxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-legal-entity.csv";

	
	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_policyxbusinessarea(policyxbusinessarea_PATH); 
		Axon_SourcingTemplate_policyxclient(policyxclient_PATH); 
		Axon_SourcingTemplate_policyxglossary(policyxglossary_PATH); 
		Axon_SourcingTemplate_policyxpolicy(policyxpolicy_PATH); 
		Axon_SourcingTemplate_policyxprocess(policyxprocess_PATH); 
		Axon_SourcingTemplate_policyxproduct(policyxproduct_PATH); 
		Axon_SourcingTemplate_policyxproject(policyxproject_PATH); 
		Axon_SourcingTemplate_policyxsystem(policyxsystem_PATH); 
		Axon_SourcingTemplate_policyxlegalentity(policyxlegalentity_PATH); 
		
	    Axon_SourcingTemplate_policyxdataset(policyxdataset_PATH); 
		Axon_SourcingTemplate_policyxattribute(policyxattribute_PATH); 
		
	} 
	
	public static void Axon_SourcingTemplate_policyxbusinessarea(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";

		try { 

			System.out.print("policy-X-BA File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxbusinessarea.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.BUAreas"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxba"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+i,1,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+s,0,2);
				result= data.add(new String[] {Ref_policy_tmpl+i,policy_tmpl+i,src_parent,businessarea_tmpl+s,trg_parent,"Policy is owned by"});

			
			
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

	public static void Axon_SourcingTemplate_policyxclient(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";

		try { 


			System.out.print("policy-X-client File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxclient"));
			
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
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_policy_tmpl+i,1,7);
				
				result= data.add(new String[] {client_tmpl+s,src_parent,Ref_policy_tmpl+i,policy_tmpl+i,trg_parent,"Is related to"});
			
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

	public static void Axon_SourcingTemplate_policyxglossary(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";

		try { 

			System.out.print("policy-X-glossary File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");
			
			
			
			int NumOfPolforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));
			int ConstNumOfPolforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));
			int NumofGloss = Integer.parseInt(configProps.getProperty("No.Glossary"));
			
			
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Glossary"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxglossary"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			
			BufferedReader br = new BufferedReader(new FileReader(attr_filepath));
			String line =null ;
			
			HashMap<String,String> Sys_Gloss_hashmap = new HashMap<String,String>();
			HashMap<String,String> Sys_GlossPar_hashmap = new HashMap<String,String>();
			
			
			
			while((line=br.readLine())!=null){
				String str[] = line.split(",");
				if(Sys_Gloss_hashmap.containsKey(str[9].replaceAll("\"", ""))) {
					continue;
				}
				else {
				Sys_Gloss_hashmap.put(str[9].replaceAll("\"", ""), str[11].replaceAll("\"", ""));
				Sys_GlossPar_hashmap.put(str[9].replaceAll("\"", ""), str[12].replaceAll("\"", ""));
				}
			}
			
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+s,1,7);
				String gloss_key = sys_tmpl+i;

				result= data.add(new String[] {Segment_name+"RelDesc"+i,Ref_policy_tmpl+s,src_parent,policy_tmpl+s,"Ref-"+Sys_Gloss_hashmap.get(gloss_key),Sys_Gloss_hashmap.get(gloss_key),Sys_GlossPar_hashmap.get(gloss_key),"Policy is regulating Glossary Item"});
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

	public static void Axon_SourcingTemplate_policyxpolicy(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";

		try { 

			System.out.print("policy-X-policy File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxpolicy.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Policies"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxpolicy"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=1;
			
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						
					}                                                                                                                                                            
				} 
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+i,1,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_policy_tmpl+s,1,7);

				result= data.add(new String[] {Segment_name+"RelDesc"+i,Ref_policy_tmpl+i,policy_tmpl+i,src_parent,Ref_policy_tmpl+s,policy_tmpl+s,trg_parent,"Is related to"});
	
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

	public static void Axon_SourcingTemplate_policyxprocess(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";

		try { 

			System.out.print("policy-X-process File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxprocess.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Process"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxprocess"));
			
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

 
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+i,1,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_process_tmpl+s,1,12); 

				result= data.add(new String[] {Segment_name+"RelDesc"+i,Ref_policy_tmpl+i,policy_tmpl+i,src_parent,Ref_process_tmpl+s,process_tmpl+s,trg_parent,"Policy is regulating Process"});

			
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

	public static void Axon_SourcingTemplate_policyxproduct(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";

		try { 

			System.out.print("policy-X-product File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxproduct"));
			
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
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_policy_tmpl+i,1,7);

				result= data.add(new String[] {product_tmpl+s,src_parent,Ref_policy_tmpl+i,policy_tmpl+i,trg_parent,"Is related to"});
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

	public static void Axon_SourcingTemplate_policyxproject(String filePath) 

	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";

		try { 

			System.out.print("policy-X-project File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxproject.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxproject"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+i,1,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);

				result= data.add(new String[] {Segment_name+"RelDesc"+i,Ref_policy_tmpl+i,policy_tmpl+i,src_parent,Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Is related to"});
			
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

	public static void Axon_SourcingTemplate_policyxsystem(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";

		try { 

			System.out.print("policy-X-system File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			
			int NumOfPolforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
			int ConstNumOfPolforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
			int Numofsys = Integer.parseInt(configProps.getProperty("No.Systems"));

			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxsystem.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Systems"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxsystem"));
			
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

				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+s,1,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,sys_tmpl+i,0,6);

				result= data.add(new String[] { Ref_policy_tmpl+s,policy_tmpl+s,src_parent,sys_tmpl+i,trg_parent,"Policy is regulating System"}); 


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

	public static void Axon_SourcingTemplate_policyxdataset(String filePath) 
	{ 
		File file = new File(filePath); 
		

		Dependantdata obj=new Dependantdata();
		String src_parent,dssystem;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
		String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
		
		try { 

			System.out.print("policy-X-dataset File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxdataset.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Datasets"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxdataset"));
			
			boolean result=false; 
			
			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			
			BufferedReader br = new BufferedReader(new FileReader(attr_filepath));
			String line =null ;
			
			HashMap<String,String> Sys_DS_hashmap = new HashMap<String,String>();
			
			
			while((line=br.readLine())!=null){
				String str[] = line.split(",");
				if(Sys_DS_hashmap.containsKey(str[9].replaceAll("\"", ""))) {
					continue;
				}
				else {
					Sys_DS_hashmap.put(str[9].replaceAll("\"", ""), str[8].replaceAll("\"", ""));
				
				}
			}
			
			
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
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+s,1,7); 
				String DS_key = sys_tmpl+i;

				result= data.add(new String[] {Ref_policy_tmpl+s,policy_tmpl+s,src_parent,"Ref-"+Sys_DS_hashmap.get(DS_key),Sys_DS_hashmap.get(DS_key),DS_key,"Is related to"});

			}//x++;
			
	//	}


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

	public static void Axon_SourcingTemplate_policyxattribute(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
		String src_parent,polgloss,dssystem;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
		String ds_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy-x-data-set.csv";
		String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";

		try { 
			
			System.out.print("policy-X-attribute File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			FileWriter outputfile = new FileWriter(file); 

		 
			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxattribute.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Datasets"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxattribute"));
			
						
            boolean result=false; 
			
			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;
			
			
			BufferedReader br = new BufferedReader(new FileReader(attr_filepath));
			String line =null ;
			
			HashMap<String,String> Sys_Attr_hashmap = new HashMap<String,String>();
			HashMap<String,String> Sys_Attr_DS_hashmap = new HashMap<String,String>();
			
			
			while((line=br.readLine())!=null){
				String str[] = line.split(",");
				if(Sys_Attr_hashmap.containsKey(str[9].replaceAll("\"", ""))) {
					continue;
				}
				else {
					Sys_Attr_hashmap.put(str[9].replaceAll("\"", ""), str[1].replaceAll("\"", ""));
					Sys_Attr_DS_hashmap.put(str[9].replaceAll("\"", ""), str[8].replaceAll("\"", ""));
				
				}
			}
			
			
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
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+s,1,7); 
				String Attr_key = sys_tmpl+i;
				
				result= data.add(new String[] {Ref_policy_tmpl+s,policy_tmpl+s,src_parent,"Ref-"+Sys_Attr_hashmap.get(Attr_key),Sys_Attr_hashmap.get(Attr_key),Sys_Attr_DS_hashmap.get(Attr_key),sys_tmpl+i,"Is related to"});

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
	
	public static void Axon_SourcingTemplate_policyxlegalentity(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
		String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";

		try { 

			System.out.print("policy-X-legal-entity File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("policyxlegalentity.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
			int glosxobj=Integer.parseInt(configProps.getProperty("policyxlegalentity"));
			
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
				//int randRelationshipType = (int) (ProcessxLegalentity_RelationshipType.length * Math.random());
				src_parent=obj.parentfetch(src_parent_filepath,Ref_policy_tmpl+i,1,7);
				trg_parent=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+s,0,3);

				result= data.add(new String[] {Ref_policy_tmpl+i,policy_tmpl+i,src_parent,legalentity_tmpl+s,trg_parent,"Policy is related to Legal Entity"});

			
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
