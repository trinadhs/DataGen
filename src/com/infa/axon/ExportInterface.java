package com.infa.axon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class ExportInterface implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_interface.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_interface(CSV_FILE_PATH); 
//	} 


	public static void Axon_SourcingTemplate_interface(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 

			System.out.print("Interface File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("interface.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Interface"));
			//	int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));
			int noOfsystems= Integer.parseInt(configProps.getProperty("No.Systems"));


			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			int s=0;

			for (int i = 1; i <= noOfRow; i++) {

				int randAxonViewing = (int) (Interface_AxonViewing.length * Math.random());
				// int randAxonStatus = (int) (Interface_AxonStatus.length * Math.random());
				int randLifecycle = (int) (Interface_Lifecycle.length * Math.random());
				int randGovernanceRole = (int) (Interface_GovernanceRole.length * Math.random());
				int randClasification = (int) (Interface_InterfaceClassification.length * Math.random());
				int randAutomationLevel = (int) (Interface_AutomationLevel.length * Math.random());
				int randTransferMethod = (int) (Interface_TransferMethod.length * Math.random());
				int randTransferFormat = (int) (Interface_TransferFormat.length * Math.random());
				int randFrequency = (int) (Interface_Frequency.length * Math.random());

				int randtargetsys = (int) (noOfsystems * Math.random())+1;
								
				if(s<=noOfsystems) {
					s++;
					if(s>noOfsystems)
					{
						s=1;
					}
				}
				else if(s>noOfsystems)
				{
					s=1;
				}

                  if(s==randtargetsys) {
                	    randtargetsys= (int) (noOfsystems * Math.random())+1; 
                  }

           
				result= data.add(new String[] {interface_tmpl+i,Ref_interface_tmpl+i,"Asset"+i,"SycControl"+i,
						"This is a description of "+interface_tmpl+i,Interface_TransferMethod[randTransferMethod],
						Interface_TransferFormat[randTransferFormat],Interface_InterfaceClassification[randClasification],
						Interface_Lifecycle[randLifecycle],"Active",sys_tmpl+s,sys_tmpl+randtargetsys,Interface_AutomationLevel[randAutomationLevel],
						Interface_Frequency[randFrequency],Interface_AxonViewing[randAxonViewing],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
						fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Interface_GovernanceRole[randGovernanceRole]});
                  
                 /* result= data.add(new String[] {Segment_name+"Interface"+i,"REF-"+Segment_name+"Interface"+i,"Asset"+i,"SycControl"+i,
  						"This is a description of "+Segment_name+"Interface"+i,Interface_TransferMethod[randTransferMethod],
  						Interface_TransferFormat[randTransferFormat],Interface_InterfaceClassification[randClasification],
  						Interface_Lifecycle[randLifecycle],"Active",Segment_name+"System"+s,Segment_name+"System"+randtargetsys,Interface_AutomationLevel[randAutomationLevel],
  						Interface_Frequency[randFrequency],Interface_AxonViewing[randAxonViewing],"financeadmin@informatica.com",
  						"Finance","Admin","",Interface_GovernanceRole[randGovernanceRole]}); */
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
