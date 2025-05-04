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

public class ProjectRelations implements DropdownData{
	
	private static final String projectxbusinessarea_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-business-area.csv";
	private static final String projectxcapability_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-capability.csv";
	private static final String projectxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-client.csv";
	private static final String projectxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-glossary.csv";
	private static final String projectxprocess_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-process.csv";
	private static final String projectxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-product.csv";
	private static final String projectxproject_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-project.csv";
	private static final String projectxsystem_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-system.csv";
	private static final String projectxdataset_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-data-set.csv";
	private static final String projectxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-legal-entity.csv";
	private static final String projectxattribute_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-attribute.csv";

	
	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_projectxbusinessarea(projectxbusinessarea_PATH); 
		Axon_SourcingTemplate_projectxcapability(projectxcapability_PATH); 
		Axon_SourcingTemplate_projectxclient(projectxclient_PATH); 
		Axon_SourcingTemplate_projectxglossary(projectxglossary_PATH); 
		Axon_SourcingTemplate_projectxprocess(projectxprocess_PATH); 
		Axon_SourcingTemplate_projectxproduct(projectxproduct_PATH); 
		Axon_SourcingTemplate_projectxproject(projectxproject_PATH); 
		Axon_SourcingTemplate_projectxsystem(projectxsystem_PATH); 	
		Axon_SourcingTemplate_projectxdataset(projectxdataset_PATH);
		Axon_SourcingTemplate_projectxattribute(projectxattribute_PATH);
		
	} 
	

	public static void Axon_SourcingTemplate_projectxbusinessarea(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";


		try { 

			System.out.print("project-X-BA File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxbusinessarea.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.BUAreas"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxba"));
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5);
				trg_parent=obj.parentfetch(trg_parent_filepath,businessarea_tmpl+i,0,2);
				
				result= data.add(new String[] {Ref_project_tmpl+s,project_tmpl+s,src_parent,businessarea_tmpl+i,trg_parent,"Project is related to Business Area"});
			
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

	public static void Axon_SourcingTemplate_projectxcapability(String filePath) 

	{ 
		File file = new File(filePath); 
	
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";

		try { 

			System.out.print("project-X-capability File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxcapability.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxcapability"));
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_capability_tmpl+i,0,3);


				//result= data.add(new String[] {Ref_gloss_tmpl+i,gloss_tmpl+i,"",Ref_gloss_tmpl+randtargetobjs,gloss_tmpl+randtargetobjs,"","Capability is related to Business Area"}); 
				result= data.add(new String[] {Ref_project_tmpl+s,project_tmpl+s,src_parent,Ref_capability_tmpl+i,capability_tmpl+i,trg_parent,"Is related to"});
			
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("projectxcapability file Upload pass");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}

	public static void Axon_SourcingTemplate_projectxclient(String filePath) 

	{ 
		File file = new File(filePath); 
	 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";

		try { 

			System.out.print("project-X-client File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Clients"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxclient"));
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5);
				trg_parent=obj.parentfetch(trg_parent_filepath,client_tmpl+i,0,3);
 
				result= data.add(new String[] {client_tmpl+i,trg_parent,Ref_project_tmpl+s,project_tmpl+s,src_parent,"Is related to"});
			
		}


			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.println("projectxclient file Upload pass");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 

	}

	public static void Axon_SourcingTemplate_projectxglossary(String filePath) 
	{ 
		File file = new File(filePath); 
		 
		Dependantdata obj=new Dependantdata();
        String gloss_parent,trg_parent;
        
        String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
        String ds_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
        String gloss_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";

		try { 

			System.out.print("project-X-glossary File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			
			int NumOfProjforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));
			int ConstNumOfProjforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));
			int NumofGloss = Integer.parseInt(configProps.getProperty("No.Glossary"));
			
			
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxglossary.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxglossary"));
			
			boolean result=false; 
			
			

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1,count=1;
			
	//To map glossaries according to DS
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>glosxobj) {
							s=0;
							x=1;
							break;
						}
					}                                                                                                                                                            
				} 

				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);
				String[] gloss_val=obj.indirect_dependency_data(ds_filepath,Ref_dset_tmpl+i,0,10,11,12); 
				
				result= data.add(new String[] {Segment_name+"RelDesc"+count,gloss_val[0],gloss_val[1],gloss_val[2],Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Glossary is used by Project"});			
		        count++;
			}

			
	//To map glossaries accroding to attribute
			
       for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>glosxobj) {
							s=0;
							x=1;
							break;
						}
					}                                                                                                                                                            
				} 

				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);
				String[] gloss_val=obj.indirect_dependency_data(attr_filepath,Ref_attrib_tmpl+i,0,10,11,12); 
				
				result= data.add(new String[] {Segment_name+"RelDesc"+count,gloss_val[0],gloss_val[1],gloss_val[2],Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Glossary is used by Project"});			
		        count++;
			}

//To map each project to any glossary 5 times(as in low volume)
       
       for (int i = 1; i <= noOfRow; i++) {
			
			if(s<=noOfTargtrows) {                                                                                                                                           
				s++;                                                                                                                                                         
				if(s>noOfTargtrows)                                                                                                                                          
				{                                                                                                                                                            
					s=1;  
					x++; 
					if(x>glosxobj) {
						s=0;
						x=1;
						break;
					}
				}                                                                                                                                                            
			} 

			trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);
			gloss_parent=obj.parentfetch(gloss_filepath,Ref_gloss_tmpl+s,2,7);
			
			result= data.add(new String[] {Segment_name+"RelDesc"+count,Ref_gloss_tmpl+s,gloss_tmpl+s,gloss_parent,Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Glossary is used by Project"});			
	        count++;
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
	
	public static void Axon_SourcingTemplate_projectxprocess(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";

		try { 

			System.out.print("project-X-process File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxprocess.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxxprocess"));
			
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
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+i,1,12); 
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);

				result= data.add(new String[] {Segment_name+"RelDesc"+i,Ref_process_tmpl+i,process_tmpl+i,src_parent,Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Project is affecting Process"});

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

	public static void Axon_SourcingTemplate_projectxproduct(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";

		try { 

			System.out.print("project-X-product File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Product"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxproduct"));
			//System.out.println("Values "+glosxobj);
			
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

				src_parent=obj.parentfetch(src_parent_filepath,Ref_product_tmpl+i,0,4);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);

				result= data.add(new String[] {Segment_name+"Description"+i,product_tmpl+i,src_parent,Ref_project_tmpl+s,project_tmpl+s,trg_parent,"Is related to"});
	
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
	
	public static void Axon_SourcingTemplate_projectxproject(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent,trg_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
        String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";

		try { 

			System.out.print("project-X-project File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxproject.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Project"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxproject"));
			
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
 
				int randRelationshipType = (int) (ProjectxProject_RelationshipType.length * Math.random());
				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+i,0,5);
				trg_parent=obj.parentfetch(trg_parent_filepath,Ref_project_tmpl+s,0,5);

				result= data.add(new String[] {Segment_name+"RelDesc"+i,Ref_project_tmpl+i,project_tmpl+i,src_parent,Ref_project_tmpl+s,project_tmpl+s,trg_parent,ProjectxProject_RelationshipType[randRelationshipType]});
			
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
	
	public static void Axon_SourcingTemplate_projectxsystem(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
        String src_parent, sys_val;
      
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
        String sys_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";
        String ds_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
        String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
        

		try { 

			System.out.print("project-X-system File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 
			
			
			int NumOfProjforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
			int ConstNumOfProjforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
			int Numofsys = Integer.parseInt(configProps.getProperty("No.Systems"));

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxsystem.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxsystem"));
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1,count=1;
			
			// assign 5 systems to each project(as in low volume)
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>glosxobj) {
							s=0;  
							x=1; 
							break;
						}
					}                                                                                                                                                            
				} 
				
				int randRelationshipType = (int) (ProjectxSystem_RelationshipType.length * Math.random());
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5);
				//trg_parent=obj.parentfetch(trg_parent_filepath,sys_tmpl+sys,0,6);

				result= data.add(new String[] {Segment_name+"RelDesc"+count,Ref_project_tmpl+s,project_tmpl+s,src_parent,sys_tmpl+i,ProjectxSystem_RelationshipType[randRelationshipType]});
                count++;
			}

			
			
			//To map systems according to DS
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>glosxobj) {
							s=0;
							x=1;
							break;
						}
					}                                                                                                                                                            
				} 

				
				int randRelationshipType = (int) (ProjectxSystem_RelationshipType.length * Math.random());
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5);
				sys_val=obj.parentfetch(ds_filepath,Ref_dset_tmpl+i,0,6); 
						
				result= data.add(new String[] {Segment_name+"RelDesc"+count,Ref_project_tmpl+s,project_tmpl+s,src_parent,sys_val,ProjectxSystem_RelationshipType[randRelationshipType]});
                count++;
			}

			
			
			
			//To map systems according to Attribute
			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>glosxobj) {
							s=0;
							x=1;
							break;
						}
					}                                                                                                                                                            
				} 

				
				int randRelationshipType = (int) (ProjectxSystem_RelationshipType.length * Math.random());
				
				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5);
				sys_val=obj.parentfetch(attr_filepath,Ref_attrib_tmpl+i,0,9); 
						
				result= data.add(new String[] {Segment_name+"RelDesc"+count,Ref_project_tmpl+s,project_tmpl+s,src_parent,sys_val,ProjectxSystem_RelationshipType[randRelationshipType]});
                count++;
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

	public static void Axon_SourcingTemplate_projectxdataset(String filePath) 
	{ 
		File file = new File(filePath); 

		Dependantdata obj=new Dependantdata();
		String src_parent,dssystem;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
		//String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
		
		try { 

			System.out.print("project-X-dataset File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxdataset.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Datasets"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxds")); 
			
			boolean result=false; 
			//System.out.println(noOfRow);

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
 
				src_parent=obj.parentfetch(src_parent_filepath,Ref_project_tmpl+s,0,5); 
				dssystem=obj.parentfetch(trg_parent_filepath,Ref_dset_tmpl+i,0,6); 
				//String[] attr_val=obj.indirect_dependency_data(attr_filepath,Ref_attrib_tmpl+i,0,7,8,9); 

				result= data.add(new String[] {Ref_project_tmpl+s,project_tmpl+s,src_parent,Ref_dset_tmpl+i,dset_tmpl+i,dssystem,"Is related to"});

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
	
	public static void Axon_SourcingTemplate_projectxattribute(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
		String src_parent,polgloss,dssystem;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
		//String ds_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project-x-data-set.csv";
		String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";

		try { 

			System.out.print("project-X-attribute File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			FileWriter outputfile = new FileWriter(file); 

		 
			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("projectxattribute.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Attributes"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Project"));
			int glosxobj=Integer.parseInt(configProps.getProperty("projectxattribute")); 
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1,a=0;
			
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
 
				src_parent=obj.parentfetch(src_parent_filepath,project_tmpl+s,1,5); 
				String[] attr_val=obj.indirect_dependency_data(attr_filepath,Ref_attrib_tmpl+i,0,8,9); 


				result= data.add(new String[] {Ref_project_tmpl+s,project_tmpl+s,src_parent, Ref_attrib_tmpl+i,attrib_tmpl+i,attr_val[0],attr_val[1],"Is related to"});

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
