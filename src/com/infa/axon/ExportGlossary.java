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

public class ExportGlossary implements DropdownData   {

	static String segmentname= DropdownData.Segment_name;

	private static final String CSV_FILE_PATH = "./Bulkuploads/"+segmentname+"/Axon_SourcingTemplate_glossary.csv"; 

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_glossary(CSV_FILE_PATH); 
	} 


	public static void Axon_SourcingTemplate_glossary(String filePath) 
	{ 
		
		File file = new File(filePath); 
		

		try { 
			System.out.print("Glossary File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 
			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = moduleHeaderProps.getProperty("glossary.header").split(",");
			writer.writeNext(header); 

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Glossary"));

			//Glossary parent level destribution
			int glos_Parentdepth = Integer.parseInt(configProps.getProperty("glos.Parentdepth"));
			int Norootglos=(noOfRow/glos_Parentdepth)/glos_Parentdepth;
			int glos_set= (noOfRow/glos_Parentdepth)-Norootglos;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//			 for (int i = 1; i <= noOfRow; i++) {
			//
			//			 	
			//	           result= data.add(new String[] { "PerfGlossary"+i ,"This is a defination of PerfGlossary"+i,"Ref-Glossary"+i,"This is an example of PerfGlossary"+i,
			//	        		   "BusinessLogic"+i,"This is a format description of PerfGlossary"+i,"LDM"+i,"PerfGlossary"+(i-1),"Ref-Glossary"+(i-1),"Public","Active","Being validated",
			//	        		   "Number","True","Public","Domain","2","1","3","AlisGLS"+i,"p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Glossary Steward" }); 
			//	          
			//			  }


			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootglos) {

					int randAxonViewing = (int) (Glossary_AxonViewing.length * Math.random());
					// int randAxonStatus = (int) (Glossary_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Glossary_Lifecycle.length * Math.random());
					int randFormatType = (int) (Glossary_FormatType.length * Math.random());
					int randKDE = (int) (Glossary_KDE.length * Math.random());
					int randSecurityClassification = (int) (Glossary_SecurityClassification.length * Math.random());
					int randType = (int) (Glossary_Type.length * Math.random());
					int randConfidentiality = (int) (Glossary_Confidentiality.length * Math.random());
					int randIntegrity = (int) (Glossary_Integrity.length * Math.random());
					int randAvailability = (int) (Glossary_Availability.length * Math.random());
					int randGovernanceRole = (int) (Glossary_GovernanceRole.length * Math.random());
		
					result= data.add(new String[] { gloss_tmpl+i ,"This is a defination of "+gloss_tmpl+i,
							Ref_gloss_tmpl+i,"This is an example of "+gloss_tmpl+i,
							"BusinessLogic"+i,"This is a format description of "+gloss_tmpl+i,"LDM"+i,"","",
							Glossary_AxonViewing[randAxonViewing],"Active",Glossary_Lifecycle[randLifecycle],
							Glossary_FormatType[randFormatType],Glossary_KDE[randKDE],Glossary_SecurityClassification[randSecurityClassification],
							Glossary_Type[randType],Glossary_Confidentiality[randConfidentiality],Glossary_Integrity[randIntegrity],
							Glossary_Availability[randAvailability],segmentname+" AlisGLS"+i,people_tmpl+i+"@informatica.com",fisrtname_tmpl+i,
							lastname_tmpl+i,lan_tmpl+i,Glossary_GovernanceRole[randGovernanceRole], Segment_name});
					
				/*	result= data.add(new String[] { segmentname+"Glossary"+i ,"This is a defination of "+segmentname+"Glossary"+i,
							"Ref-"+segmentname+"Glossary"+i,"This is an example of "+segmentname+"Glossary"+i,
							"BusinessLogic"+i,"This is a format description of "+segmentname+"Glossary"+i,"LDM"+i,"","",
							Glossary_AxonViewing[randAxonViewing],"Active",Glossary_Lifecycle[randLifecycle],
							Glossary_FormatType[randFormatType],Glossary_KDE[randKDE],Glossary_SecurityClassification[randSecurityClassification],
							Glossary_Type[randType],Glossary_Confidentiality[randConfidentiality],Glossary_Integrity[randIntegrity],
							Glossary_Availability[randAvailability],segmentname+" AlisGLS"+i,"financeadmin@informatica.com" ,"Finance","Admin","",Glossary_GovernanceRole[randGovernanceRole],"Finance" });*/
					
	

				}

				else {
					int k=1;
					while(k<=Norootglos){
						for (int j=1;j<=glos_set;j++) {
							if(i <= noOfRow) {   

								int randAxonViewing = (int) (Glossary_AxonViewing.length * Math.random());
								// int randAxonStatus = (int) (Glossary_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Glossary_Lifecycle.length * Math.random());
								int randFormatType = (int) (Glossary_FormatType.length * Math.random());
								int randKDE = (int) (Glossary_KDE.length * Math.random());
								int randSecurityClassification = (int) (Glossary_SecurityClassification.length * Math.random());
								int randType = (int) (Glossary_Type.length * Math.random());
								int randConfidentiality = (int) (Glossary_Confidentiality.length * Math.random());
								int randIntegrity = (int) (Glossary_Integrity.length * Math.random());
								int randAvailability = (int) (Glossary_Availability.length * Math.random());
								int randGovernanceRole = (int) (Glossary_GovernanceRole.length * Math.random());									   

								result= data.add(new String[] { gloss_tmpl+i ,"This is a defination of "+gloss_tmpl+i,
										Ref_gloss_tmpl+i,"This is an example of "+gloss_tmpl+i,
										"BusinessLogic"+i,"This is a format description of "+gloss_tmpl+i,"LDM"+i,gloss_tmpl+j,Ref_gloss_tmpl+j,
										Glossary_AxonViewing[randAxonViewing],"Active",Glossary_Lifecycle[randLifecycle],
										Glossary_FormatType[randFormatType],Glossary_KDE[randKDE],Glossary_SecurityClassification[randSecurityClassification],
										Glossary_Type[randType],Glossary_Confidentiality[randConfidentiality],Glossary_Integrity[randIntegrity],
										Glossary_Availability[randAvailability],segmentname+" AlisGLS"+i,people_tmpl+((i%noOfpeoples)+1)+"@informatica.com" ,
										fisrtname_tmpl+((i%noOfpeoples)+1) ,lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Glossary_GovernanceRole[randGovernanceRole],Segment_name});
								
								//segment
								
								/*result= data.add(new String[] { segmentname+"Glossary"+i ,"This is a defination of "+segmentname+"Glossary"+i,
										"Ref-"+segmentname+"Glossary"+i,"This is an example of "+segmentname+"Glossary"+i,
										"BusinessLogic"+i,"This is a format description of "+segmentname+"Glossary"+i,"LDM"+i,"","",
										Glossary_AxonViewing[randAxonViewing],"Active",Glossary_Lifecycle[randLifecycle],
										Glossary_FormatType[randFormatType],Glossary_KDE[randKDE],Glossary_SecurityClassification[randSecurityClassification],
										Glossary_Type[randType],Glossary_Confidentiality[randConfidentiality],Glossary_Integrity[randIntegrity],
										Glossary_Availability[randAvailability],segmentname+" AlisGLS"+i,"financeadmin@informatica.com" ,"Finance","Admin","",Glossary_GovernanceRole[randGovernanceRole],"Finance" });*/

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
