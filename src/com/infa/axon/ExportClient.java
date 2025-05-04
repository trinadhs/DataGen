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

public class ExportClient implements DropdownData {
	

	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv"; 

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_client(CSV_FILE_PATH); 
	} 


	public static void Axon_SourcingTemplate_client(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 	  
			System.out.print("Client File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("client.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Clients"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
			
			//Client parent level destribution
			
			int Cl_Parentdepth = Integer.parseInt(configProps.getProperty("Cl.Parentdepth"));
			int Norootclient=(noOfRow/Cl_Parentdepth)/Cl_Parentdepth;
			int client_set= (noOfRow/Cl_Parentdepth)-Norootclient;
			
			/*System.out.println(noOfRow);
			System.out.println(Cl_Parentdepth);
			System.out.println(Norootclient);*/
			
			

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

//			for (int i = 1; i <= noOfRow; i++) {
//				result= data.add(new String[] {"PerfClient"+i,"This is a long name of PerfClient"+i,"This is a description of PerfClient"+i,
//						"PerfClient"+i,"Obsolete","Inactive","Public","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),
//						"0.0.0."+i,"Client Segmentation Owner"}); 
//			}

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootclient) {
					
					int randAxonViewing = (int) (Client_AxonViewing.length * Math.random());
					// int randAxonStatus = (int) (Client_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Client_Lifecycle.length * Math.random());
					int randGovernanceRole = (int) (Client_GovernanceRole.length * Math.random());
					
					result= data.add(new String[] {client_tmpl+i,"This is a long name of "+client_tmpl+i,"This is a description of "+client_tmpl+i,
							"",Client_Lifecycle[randLifecycle],"Active",Client_AxonViewing[randAxonViewing],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
							lan_tmpl+i,Client_GovernanceRole[randGovernanceRole],Segment_name});
					
					/*result= data.add(new String[] {Segment_name+"Client"+i,"This is a long name of "+Segment_name+"Client"+i,"This is a description of "+Segment_name+"Client"+i,
							"",Client_Lifecycle[randLifecycle],"Active",Client_AxonViewing[randAxonViewing],"financeadmin@informatica.com","Finance","Admin",
							"",Client_GovernanceRole[randGovernanceRole],"Finance"});*/
										
				}

				else {
					int k=1;
					while(k<=Norootclient){
						for (int j=1;j<=client_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (Client_AxonViewing.length * Math.random());
								// int randAxonStatus = (int) (Client_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Client_Lifecycle.length * Math.random());
								int randGovernanceRole = (int) (Client_GovernanceRole.length * Math.random());
								
								result= data.add(new String[] {client_tmpl+i,"This is a long name of "+client_tmpl+i,"This is a description of "+client_tmpl+i,
										client_tmpl+j,Client_Lifecycle[randLifecycle],"Active",Client_AxonViewing[randAxonViewing],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
										lan_tmpl+i,Client_GovernanceRole[randGovernanceRole],Segment_name});
								
								/*result= data.add(new String[] {Segment_name+"Client"+i,"This is a long name of "+Segment_name+"Client"+i,"This is a description of "+Segment_name+"Client"+i,
										"",Client_Lifecycle[randLifecycle],"Active",Client_AxonViewing[randAxonViewing],"financeadmin@informatica.com","Finance","Admin",
										"",Client_GovernanceRole[randGovernanceRole],"Finance"});*/
								i++;
							}
						}k++;
					}i--;
				}		

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
