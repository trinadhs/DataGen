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

public class DatasetRelations implements DropdownData {
	
	private static final String datasetxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set-x-client.csv";
	private static final String datasetxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set-x-legal-entity.csv";
	private static final String datasetxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set-x-product.csv";


	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_datasetxclient(datasetxclient_PATH);
		Axon_SourcingTemplate_datasetxlegalentity(datasetxlegalentity_PATH); 
		Axon_SourcingTemplate_datasetxproduct(datasetxproduct_PATH); 
				
	} 

	
	public static void Axon_SourcingTemplate_datasetxclient(String filePath) 

	{ 
		File file = new File(filePath); 
		
		Dependantdata obj=new Dependantdata();
        String src_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
		
		try { 

			System.out.print("data-set-X-client File generation........"); 
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("datasetxclient.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Datasets"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
			int datasetxclient=Integer.parseInt(configProps.getProperty("datasetxclient"));
			boolean result=false; 

			//System.out.println("value "+glosxobj);
			List<String[]> data = new ArrayList<String[]>(); 
			int s=0,x=1;

			for (int i = 1; i <= noOfRow; i++) {
				
				if(s<=noOfTargtrows) {                                                                                                                                           
					s++;                                                                                                                                                         
					if(s>noOfTargtrows)                                                                                                                                          
					{                                                                                                                                                            
						s=1;  
						x++; 
						if(x>datasetxclient) {
							break;
						}
					}                                                                                                                                                            
				} 

				//System.out.println("***********"+i);
				src_parent=obj.parentfetch(src_parent_filepath,client_tmpl+s,0,3); 
				
				//List<Object> details = obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+randtargetobjs,0,6,7);
				//System.out.println("cap	"+parent);		
				String[] details=obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+i,0,6,7); 
				//System.out.println();
				
				result= data.add(new String[] {client_tmpl+s,src_parent,Ref_dset_tmpl+i,dset_tmpl+i,details[0],details[1],"Is related to"});

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

	public static void Axon_SourcingTemplate_datasetxlegalentity(String filePath) 

	{ 
		File file = new File(filePath); 
		
		Dependantdata obj=new Dependantdata();
        String src_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
		
		try { 
			
			System.out.print("data-set-X-legal-entity File generation........"); 

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("datasetxlegalentity.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Datasets"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
			int glosxobj=Integer.parseInt(configProps.getProperty("datasetxlegalentity"));
			
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
				src_parent=obj.parentfetch(src_parent_filepath,legalentity_tmpl+s,0,3); 
				
				//List<Object> details = obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+randtargetobjs,0,6,7);
				//System.out.println("cap	"+parent);		
				String[] details=obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+i,0,6,7); 
				//System.out.println();
				
				result= data.add(new String[] {legalentity_tmpl+s,src_parent,Ref_dset_tmpl+i,dset_tmpl+i,details[0],details[1],"Is related to"});

			
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

	public static void Axon_SourcingTemplate_datasetxproduct(String filePath) 

	{ 
		File file = new File(filePath); 
		
		Dependantdata obj=new Dependantdata();
        String src_parent;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
		String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
		
		try { 

			System.out.print("data-set-X-product File generation........"); 
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("datasetxproduct.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Datasets"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
			int glosxobj=Integer.parseInt(configProps.getProperty("datasetxproduct"));
			
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
				src_parent=obj.parentfetch(src_parent_filepath,product_tmpl+s,1,4); 
				
				//List<Object> details = obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+randtargetobjs,0,6,7);
				//System.out.println("cap	"+parent);		
				String[] details=obj.indirect_dependency_data(trg_parent_filepath,Ref_dset_tmpl+i,0,6,7); 
				//System.out.println(details);
				
				result= data.add(new String[] {product_tmpl+s,src_parent,Ref_dset_tmpl+i,dset_tmpl+i,details[0],details[1],"Is related to"});

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

