package com.infa.axon;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;
import utility.Utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ExportSystem implements DropdownData {

	static String segmentname= DropdownData.Segment_name;

	private static final String CSV_FILE_PATH = "./Bulkuploads/"+segmentname+"/Axon_SourcingTemplate_system.csv"; 

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_system(CSV_FILE_PATH); 
	} 


	public static void Axon_SourcingTemplate_system(String filePath) 
	{ 

		File file = new File(filePath); 

		try { 
			System.out.print("System File generation........");
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		


			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("system.header").split(",");
			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Systems")); //systems
			int sys_Parentdepth = Integer.parseInt(configProps.getProperty("sys.Parentdepth"));
			int Norootsys =(noOfRow/sys_Parentdepth)/sys_Parentdepth;
			int sys_set= (noOfRow/sys_Parentdepth)-Norootsys;

			//	int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;



			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			for (int i = 1; i <= noOfRow; i++) {

				if(i<=Norootsys) {

					int randExternal = (int) (System_External.length * Math.random());
					int randAxonViewing = (int) (System_AxonViewing.length * Math.random());
					//int randAxonStatus = (int) (System_AxonStatus.length * Math.random());
					int randLifecycle = (int) (System_Lifecycle.length * Math.random());
					int randSystemType = (int) (System_SystemType.length * Math.random());
					int randClassification = (int) (System_SystemClassification.length * Math.random());
					int randGovernanceRole = (int) (System_GovernanceRole.length * Math.random());

					result= data.add(new String[] { sys_tmpl+i , "This is a long name of "+sys_tmpl+i, ""+i ,
							System_External[randExternal] , "This is a description of "+sys_tmpl+i ,
							"URL"+sys_tmpl+i ,"" , System_AxonViewing[randAxonViewing] , "Active", System_Lifecycle[randLifecycle] , System_SystemType[randSystemType] ,
							System_SystemClassification[randClassification] , "1", "2" , "3", people_tmpl+i+"@informatica.com" ,
							fisrtname_tmpl+i ,lastname_tmpl+i ,lan_tmpl+i, 
							System_GovernanceRole[randGovernanceRole],Segment_name});
					
					/*result= data.add(new String[] { segmentname+"System"+i , "This is a long name of "+segmentname+"System"+i, ""+i ,
							System_External[randExternal] , "This is a description of "+segmentname+"System"+i ,
							"URL"+segmentname+"System"+i ,"" , System_AxonViewing[randAxonViewing] , "Active", System_Lifecycle[randLifecycle] , System_SystemType[randSystemType] ,
							System_SystemClassification[randClassification] , "1", "2" , "3","financeadmin@informatica.com" ,
							"Finance","Admin","", 
							System_GovernanceRole[randGovernanceRole],"Finacne"});*/

				}

				else {
					int k=1;
					while(k<=Norootsys){
						for (int j=1;j<=sys_set;j++) {
							if(i <= noOfRow) {   
								int randExternal = (int) (System_External.length * Math.random());
								int randAxonViewing = (int) (System_AxonViewing.length * Math.random());
								//int randAxonStatus = (int) (System_AxonStatus.length * Math.random());
								int randLifecycle = (int) (System_Lifecycle.length * Math.random());
								int randSystemType = (int) (System_SystemType.length * Math.random());
								int randClassification = (int) (System_SystemClassification.length * Math.random());
								int randGovernanceRole = (int) (System_GovernanceRole.length * Math.random());

								result= data.add(new String[] { sys_tmpl+i , "This is a long name of "+sys_tmpl+i, ""+i ,
										System_External[randExternal] , "This is a description of "+sys_tmpl+i ,
										"URL"+sys_tmpl+i ,sys_tmpl+j , System_AxonViewing[randAxonViewing] , "Active", System_Lifecycle[randLifecycle] , System_SystemType[randSystemType] ,
										System_SystemClassification[randClassification] , "1", "2" , "3", people_tmpl+((i%noOfpeoples)+1)+"@informatica.com" ,
										fisrtname_tmpl+((i%noOfpeoples)+1) ,lastname_tmpl+((i%noOfpeoples)+1) ,lan_tmpl+i, 
										System_GovernanceRole[randGovernanceRole],Segment_name }); 
								//for bulk upload with segment
								
								/*result= data.add(new String[] { segmentname+"System"+i , "This is a long name of "+segmentname+"System"+i, ""+i ,
										System_External[randExternal] , "This is a description of "+segmentname+"System"+i ,
										"URL"+segmentname+"System"+i ,"" , System_AxonViewing[randAxonViewing] , "Active", System_Lifecycle[randLifecycle] , System_SystemType[randSystemType] ,
										System_SystemClassification[randClassification] , "1", "2" , "3","financeadmin@informatica.com" ,
										"Finance","Admin","", 
										System_GovernanceRole[randGovernanceRole],"Finacne"});*/
								
								
								
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