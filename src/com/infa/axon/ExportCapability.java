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

public class ExportCapability implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_capability(CSV_FILE_PATH); 
//	} 


	public static void Axon_SourcingTemplate_capability(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 

			System.out.print("Capability File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("capability.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Capabilitis"));
			//	int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			//Capability parent level destribution

			int cap_Parentdepth = Integer.parseInt(configProps.getProperty("Cap.Parentdepth"));
			int Norootobjs=(noOfRow/cap_Parentdepth)/cap_Parentdepth;
			int cap_set= (noOfRow/cap_Parentdepth)-Norootobjs;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//			for (int i = 1; i <= noOfRow; i++) {
			//			result= data.add(new String[] {"Ref-Capability"+i,"Capability"+i,"This is a defination of Capability"+i,"Capability"+(i-1),
			//						"Ref-Capability"+(i-1),"Public","Organisational Capability","Inactive","Obsolete","Responsibility",
			//						"p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0"+i,"Capability Owner"}); 
			//			}

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					int randAxonViewing = (int) (Capability_AxonViewing.length * Math.random());
					// int randAxonStatus = (int) (Capability_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Capability_Lifecycle.length * Math.random());
					int randGovernanceRole = (int) (Capability_GovernanceRole.length * Math.random());
					int randClasification = (int) (Capability_Classification.length * Math.random());
					int randType = (int) (Capability_CapabilityType.length * Math.random());

					result= data.add(new String[] {Ref_capability_tmpl+i,capability_tmpl+i,"This is a defination of"+capability_tmpl+i,"",
							"",Capability_AxonViewing[randAxonViewing],Capability_Classification[randClasification],"Active",Capability_Lifecycle[randLifecycle],
							Capability_CapabilityType[randType],
							people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Capability_GovernanceRole[randGovernanceRole],Segment_name}); 

					
					/*result= data.add(new String[] {"Ref-"+Segment_name+"Capability"+i,Segment_name+"Capability"+i,"This is a defination of"+Segment_name+" Capability"+i,"",
							"",Capability_AxonViewing[randAxonViewing],Capability_Classification[randClasification],"Active",Capability_Lifecycle[randLifecycle],
							Capability_CapabilityType[randType],"financeadmin@informatica.com","Finance","Admin","",Capability_GovernanceRole[randGovernanceRole],"Finance"});*/
				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=cap_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (Capability_AxonViewing.length * Math.random());
								// int randAxonStatus = (int) (Capability_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Capability_Lifecycle.length * Math.random());
								int randGovernanceRole = (int) (Capability_GovernanceRole.length * Math.random());
								int randClasification = (int) (Capability_Classification.length * Math.random());
								int randType = (int) (Capability_CapabilityType.length * Math.random());

								result= data.add(new String[] {Ref_capability_tmpl+i,capability_tmpl+i,"This is a defination of"+capability_tmpl+i,capability_tmpl+j,
										Ref_capability_tmpl+j,Capability_AxonViewing[randAxonViewing],Capability_Classification[randClasification],"Active",Capability_Lifecycle[randLifecycle],
										Capability_CapabilityType[randType],
										people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Capability_GovernanceRole[randGovernanceRole],Segment_name}); 

								/*result= data.add(new String[] {"Ref-"+Segment_name+"Capability"+i,Segment_name+"Capability"+i,"This is a defination of"+Segment_name+" Capability"+i,"",
										"",Capability_AxonViewing[randAxonViewing],Capability_Classification[randClasification],"Active",Capability_Lifecycle[randLifecycle],
										Capability_CapabilityType[randType],"financeadmin@informatica.com","Finance","Admin","",Capability_GovernanceRole[randGovernanceRole],"Finance"});*/
								
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
