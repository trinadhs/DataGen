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

public class ExportLegalEntity implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_legalentity(CSV_FILE_PATH); 
//	} 


	public static void Axon_SourcingTemplate_legalentity(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 

			System.out.print("LegalEntity File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			FileWriter outputfile = new FileWriter(file); 
			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = moduleHeaderProps.getProperty("legalentity.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Legalentity"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			//LegalEntity parent level distribution

			int legl_Parentdepth = Integer.parseInt(configProps.getProperty("Legl.Parentdepth"));
			int Norootobjs=(noOfRow/legl_Parentdepth)/legl_Parentdepth;
			int objs_set= (noOfRow/legl_Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;
			
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//          result= data.add(new String[] {"Short Name Legal"+i,"Long Name Legal"+i,"This is a description of Legal Name "+i,
			//        		   "Short Name Legal"+(i-1),"Active","Public","p"+((i%noOfpeoples)+1)+"@informatica.com",
			//        		   "Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Legal Entity Owner"}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {
					
					int randAxonViewing = (int) (LE_AxonViewing.length * Math.random());
					// int randAxonStatus = (int) (LE_AxonStatus.length * Math.random());
					int randGovernanceRole = (int) (LE_GovernanceRole.length * Math.random());
					
					result= data.add(new String[] {legalentity_tmpl+i,lelong_tmpl+i,
							"This is a description of "+Segment_name+"Legal Name "+i,
							"","Active",LE_AxonViewing[randAxonViewing],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
							fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
							lan_tmpl+i,LE_GovernanceRole[randGovernanceRole],Segment_name}); 
					
					/*result= data.add(new String[] {"Short Name "+Segment_name+"Legal"+i,"Long Name "+Segment_name+"Legal"+i,
							"This is a description of "+Segment_name+"Legal Name "+i,
							"","Active",LE_AxonViewing[randAxonViewing],"financeadmin@informatica.com",
							"Finance","Admin",
							"",LE_GovernanceRole[randGovernanceRole],"Finance"});*/

				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (LE_AxonViewing.length * Math.random());
								// int randAxonStatus = (int) (LE_AxonStatus.length * Math.random());
								int randGovernanceRole = (int) (LE_GovernanceRole.length * Math.random());
								
								result= data.add(new String[] {legalentity_tmpl+i,lelong_tmpl+i,
										"This is a description of "+Segment_name+"Legal Name "+i,
										legalentity_tmpl+j,"Active",LE_AxonViewing[randAxonViewing],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
										fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
										lan_tmpl+i,LE_GovernanceRole[randGovernanceRole],Segment_name}); 
								
								/*result= data.add(new String[] {"Short Name "+Segment_name+"Legal"+i,"Long Name "+Segment_name+"Legal"+i,
										"This is a description of "+Segment_name+"Legal Name "+i,
										"","Active",LE_AxonViewing[randAxonViewing],"financeadmin@informatica.com",
										"Finance","Admin",
										"",LE_GovernanceRole[randGovernanceRole],"Finance"});*/

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
