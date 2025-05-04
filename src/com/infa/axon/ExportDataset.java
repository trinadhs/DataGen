package com.infa.axon;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.infa.relations.Dependantdata;
import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class ExportDataset implements DropdownData  {


	static String segmentname= DropdownData.Segment_name;
	
	private static final String CSV_FILE_PATH = "./Bulkuploads/"+segmentname+"/Axon_SourcingTemplate_data-set.csv"; 

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_dataset(CSV_FILE_PATH); 
	} 


	public static void Axon_SourcingTemplate_dataset(String filePath) 
	{ 

		File file = new File(filePath); 
		Dependantdata obj=new Dependantdata();
		String parent_glossary;
        String parent_filepath_glossary="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";
        
        String parent_system;
        String parent_filepath_system="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";
		int gloss=1, sys=1;


		try { 

			System.out.print("Dataset File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			int NumOfDSforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
			int NumOfDSforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));

			int ConstNumOfDSforSystem= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));
			int ConstNumOfDSforGloss= Integer.parseInt(configProps.getProperty("NumOfDSforGloss"));

			int Numofsys = Integer.parseInt(configProps.getProperty("No.Systems"));
			int NumofGloss=Integer.parseInt(configProps.getProperty("No.Glossary"));

			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 



			String[] header = moduleHeaderProps.getProperty("dataset.header").split(",");

			writer.writeNext(header); 


			int noOfRow = Integer.parseInt(configProps.getProperty("No.Datasets"));
			//	int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
			int MaxParents=Integer.parseInt(configProps.getProperty("Max_parents"));
			


			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			for (int i = 1; i <= noOfRow; i++) {


				if(i==(NumOfDSforSystem+1)) {				
					NumOfDSforSystem= NumOfDSforSystem+ConstNumOfDSforSystem;
					sys= sys+1;								

				}						
				if(i==(NumOfDSforGloss+1)) {			   
					NumOfDSforGloss= NumOfDSforGloss+ConstNumOfDSforGloss;
					gloss= gloss+1;								
				}

				if (sys>Numofsys)
				{
					sys=1;
				}

				if (gloss>NumofGloss)
				{
					gloss=1;
				}

				int randAxonViewing = (int) (Dataset_AxonViewing.length * Math.random());
				int randDataSetType = (int) (Dataset_DataSetType.length * Math.random());
				int randLifecycle = (int) (Dataset_Lifecycle.length * Math.random());
		//		int randAxonStatus = (int) (Dataset_AxonStatus.length * Math.random());
				int randGovernanceRole = (int) (Dataset_GovernanceRole.length * Math.random());



				//           result= data.add(new String[] { "Ref-DS"+i,"PerfDS"+i,"This is a defination of PerfDS"+i,"This is Usage Description of PerfDS"+i,
				//        		                           "Public","Data Set","PerfSystem"+sys,"PerfSystem2",Dataset_Lifecycle[randLifecycle],"Active","Ref-Glossary"+gloss,
				//        		                           "PerfGlossary"+gloss,"PerfGlossary1","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),
				//        		                           "Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,Dataset_GovernanceRole[randGovernanceRole] }); 


				//parent_glossary=obj.parentfetch(parent_filepath_glossary,Ref_gloss_tmpl+gloss,2,7); 
				//parent_system=obj.parentfetch(parent_filepath_system,segmentname+"System"+sys,0,6); 	
				
				if(i<= MaxParents){
					
					parent_glossary=obj.parentfetch(parent_filepath_glossary,Ref_gloss_tmpl+gloss,2,7); 
					parent_system=obj.parentfetch(parent_filepath_system,sys_tmpl+sys,0,6); 
					
					result= data.add(new String[] { Ref_dset_tmpl+i,dset_tmpl+i,"This is a defination of "+dset_tmpl+i,"This is Usage Description of "+dset_tmpl+i,
							Dataset_AxonViewing[randAxonViewing],Dataset_DataSetType[randDataSetType],sys_tmpl+sys,parent_system,Dataset_Lifecycle[randLifecycle],"Active",Ref_gloss_tmpl+gloss,
							gloss_tmpl+gloss,parent_glossary,people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Dataset_GovernanceRole[randGovernanceRole],Segment_name }); 
		
				}
				
				else {

				result= data.add(new String[] { Ref_dset_tmpl+i,dset_tmpl+i,"This is a defination of "+dset_tmpl+i,"This is Usage Description of "+dset_tmpl+i,
						Dataset_AxonViewing[randAxonViewing],Dataset_DataSetType[randDataSetType],sys_tmpl+sys,"",Dataset_Lifecycle[randLifecycle],"Active",Ref_gloss_tmpl+gloss,
						gloss_tmpl+gloss,"",Segment_name+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Dataset_GovernanceRole[randGovernanceRole],Segment_name }); 
				}
              // System.out.println("i="+i);
			}





			writer.writeAll(data); 

			// closing writer connection 
			writer.close(); 

			if(result) {
				System.out.print("Completed.\n");
			}


		} 
		catch (IOException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	} 


}
