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

public class ProcessRelations implements DropdownData{
	
	private static final String processxattribute_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-attribute.csv";
	private static final String processxclient_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-client.csv";
	private static final String processxdataset_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-data-set.csv";
	private static final String processxglossary_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-glossary.csv";
	private static final String processxlegalentity_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-legal-entity.csv";
	private static final String processxprocess_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-process.csv";
	private static final String processxproduct_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-product.csv";
	private static final String processxsystem_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-system.csv";
	private static final String processxsysteminterface_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-system-interface.csv";
	//private static final String processxsydataset_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process-x-data-set.csv";

	
	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_processxclient(processxclient_PATH); 
		Axon_SourcingTemplate_processxglossary(processxglossary_PATH); 
		Axon_SourcingTemplate_processxlegalentity(processxlegalentity_PATH); 
		Axon_SourcingTemplate_processxprocess(processxprocess_PATH); 
		Axon_SourcingTemplate_processxproduct(processxproduct_PATH);  
		Axon_SourcingTemplate_processxsystem(processxsystem_PATH);
		Axon_SourcingTemplate_processxsysteminterface(processxsysteminterface_PATH);
		Axon_SourcingTemplate_processxdataset(processxdataset_PATH);
		Axon_SourcingTemplate_processxattribute(processxattribute_PATH);

	} 
	
	
	public static void Axon_SourcingTemplate_processxattribute(String filePath) 
	{ 
		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
		String src_parent,polgloss,dssystem;
        String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
		
		String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";

		try { 
			
			System.out.print("process-X-attribute File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			FileWriter outputfile = new FileWriter(file); 

		 
			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("processxattribute.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
			int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Datasets"));
			int glosxobj=Integer.parseInt(configProps.getProperty("processxattribute"));	
		
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
 
				src_parent=obj.parentfetch(src_parent_filepath,process_tmpl+i,0,12); 
				String Attr_key = sys_tmpl+i;


				result= data.add(new String[] {Ref_process_tmpl+s,process_tmpl+s,src_parent,"Ref-"+Sys_Attr_hashmap.get(Attr_key),Sys_Attr_hashmap.get(Attr_key),Sys_Attr_DS_hashmap.get(Attr_key),sys_tmpl+i,"Is related to"});

			}
					
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
	
	public static void Axon_SourcingTemplate_processxclient(String filePath) 
{ 
	File file = new File(filePath); 
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent;
	String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
    String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";


	try { 

		System.out.print("process-X-client File generation........");
		
		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxclient.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Clients"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxclient"));
		
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
			trg_parent=obj.parentfetch(trg_parent_filepath,Ref_process_tmpl+i,1,12); 

			result= data.add(new String[] {client_tmpl+s,src_parent,Ref_process_tmpl+i,process_tmpl+i,trg_parent,"Is related to"});

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

	public static void Axon_SourcingTemplate_processxglossary(String filePath) 
{ 
	File file = new File(filePath); 
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent;
	String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
    String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";



	try { 
		System.out.print("process-X-glossary File generation........");

		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		
		int NumOfProforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));
		int ConstNumOfProforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));
		int NumofGloss = Integer.parseInt(configProps.getProperty("No.Glossary"));
		
		
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxglossary.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Glossary"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxglossary"));
		
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
			int randRelationshipType = (int) (ProcessxGlossary_RelationshipType.length * Math.random());
			
			trg_parent=obj.parentfetch(trg_parent_filepath,Ref_process_tmpl+s,1,12); 
			String gloss_key=  sys_tmpl+i;
			
			result= data.add(new String[] {Segment_name+"RelDesc"+i,"Ref-"+Sys_Gloss_hashmap.get(gloss_key),Sys_Gloss_hashmap.get(gloss_key),Sys_GlossPar_hashmap.get(gloss_key),Ref_process_tmpl+s,process_tmpl+s,trg_parent,ProcessxGlossary_RelationshipType[randRelationshipType]});
		}


		writer.writeAll(data); 

		// closing writer connection 
		writer.close(); 
		br.close();

		if(result) {
			System.out.println("COMPLETED");
		}


	} 
	catch (IOException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
	} 

}

	public static void Axon_SourcingTemplate_processxlegalentity(String filePath) 
{ 
	File file = new File(filePath); 
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent;
	String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
    String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";


	try { 

		System.out.print("process-X-legal-entity File generation........");

		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxlegalentity.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Legalentity"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxlegalentity"));
		
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

			int randRelationshipType = (int) (ProcessxLegalentity_RelationshipType.length * Math.random());

			src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+i,1,12); 
			trg_parent=obj.parentfetch(trg_parent_filepath,legalentity_tmpl+s,0,3);

			result= data.add(new String[] {Ref_process_tmpl+i,process_tmpl+i,src_parent,legalentity_tmpl+s,trg_parent,ProcessxLegalentity_RelationshipType[randRelationshipType]});
		
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

	public static void Axon_SourcingTemplate_processxprocess(String filePath) 
{ 

	File file = new File(filePath); 
	Dependantdata obj=new Dependantdata();
    String src_parent;
	String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
    String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";


	try { 

		
		System.out.print("process-X-process File generation........");
		
		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxprocess.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Process"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxprocess"));
		
		ProcessxProcess proobj = new ProcessxProcess();
		ArrayList<String> ConProc = proobj.procxproc();
		int processlen = ConProc.size();
		
		boolean result=false; 

		List<String[]> data = new ArrayList<String[]>(); 
		int s=0,x=1,tarpro=-1;
		
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
			
			if(tarpro<processlen) {
				tarpro++;
				if(tarpro>=processlen)
				{
					tarpro=0;
				}
			}else {
				tarpro=1;
			}
			
			//System.out.println(ConProc);
			//System.out.println("*****"+ConProc.get(tarpro));
			src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+i,1,12); 
			String trg_parent[]=obj.indirect_dependency_data(trg_parent_filepath,ConProc.get(tarpro),1,0,12); 

			result= data.add(new String[] {Segment_name+"Condition"+i,Ref_process_tmpl+i,process_tmpl+i,src_parent,ConProc.get(tarpro),trg_parent[0],trg_parent[1]});

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

	public static void Axon_SourcingTemplate_processxproduct(String filePath) 
{ 
	File file = new File(filePath); 
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent;
    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
    String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";

	try { 

		System.out.print("process-X-product File generation........");

		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxproduct.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Product"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxproduct"));
		
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
			trg_parent=obj.parentfetch(trg_parent_filepath,Ref_process_tmpl+i,1,12); 

			result= data.add(new String[] {product_tmpl+s,src_parent,Ref_process_tmpl+i,process_tmpl+i,trg_parent,"Is related to"});
		
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

	public static void Axon_SourcingTemplate_processxsystem(String filePath) 
{ 
	File file = new File(filePath); 
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent;
    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
    String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";


	try { 

		System.out.print("process-X-system File generation........");
		
		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		
		int NumOfProforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
		int ConstNumOfProforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
		int Numofsys = Integer.parseInt(configProps.getProperty("No.Systems"));
		
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxsystem.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Systems"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxsystem"));
		
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
			src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+s,1,12); 
			trg_parent=obj.parentfetch(trg_parent_filepath,sys_tmpl+i,0,6);

			result= data.add(new String[] {Ref_process_tmpl+s,process_tmpl+s,src_parent,sys_tmpl+i,trg_parent,"Process is applicable to System"});


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

	public static void Axon_SourcingTemplate_processxsysteminterface(String filePath) 
{ 
	File file = new File(filePath); 
	
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent;
    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
	String trg_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_interface.csv";

	try { 

		System.out.print("process-X-systemInterface File generation........");
		
		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxsysteminterface.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Interface"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxsysteminterface"));
		
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
			String[] details=obj.indirect_dependency_data(trg_parent_filepath,Ref_interface_tmpl+s,1,10,11); 
		
			result= data.add(new String[] {Ref_process_tmpl+i,process_tmpl+i,src_parent,Ref_interface_tmpl+s,interface_tmpl+s,details[0],details[1],"Process supports Interface"});
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

	public static void Axon_SourcingTemplate_processxdataset(String filePath) 
{ 
	File file = new File(filePath); 
	
	Dependantdata obj=new Dependantdata();
    String src_parent,trg_parent,dssystem;
    String src_parent_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
	String attr_filepath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";

	try { 

		System.out.print("process-X-dataset File generation........");
		
		Properties configProps=Utility.readPropertiesFile("config.properties");
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		// create FileWriter object with file as parameter 
		FileWriter outputfile = new FileWriter(file); 

		// create CSVWriter object filewriter object as parameter 

		CSVWriter writer = new CSVWriter(outputfile); 

		String[] header = moduleHeaderProps.getProperty("processxdataset.header").split(",");

		writer.writeNext(header); 

		int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
		int noOfTargtrows=Integer.parseInt(configProps.getProperty("No.Datasets"));
		int glosxobj=Integer.parseInt(configProps.getProperty("processxdataset"));
		
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

			src_parent=obj.parentfetch(src_parent_filepath,Ref_process_tmpl+i,1,12); 	
			String DS_key = sys_tmpl+i;

			
			result= data.add(new String[] {Ref_process_tmpl+s,process_tmpl+s,src_parent,"Ref-"+Sys_DS_hashmap.get(DS_key),Sys_DS_hashmap.get(DS_key),DS_key,"Is related to"});

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

}



