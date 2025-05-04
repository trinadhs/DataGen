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

public class ExportRegulation implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_regulation(CSV_FILE_PATH); 
//	} 

	public static void Axon_SourcingTemplate_regulation(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			
			System.out.print("Regulation File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("regulation.header").split(",");

			writer.writeNext(header); 


			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulation"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			// parent level distribution

			int Parentdepth = Integer.parseInt(configProps.getProperty("Reg.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;


			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//			 result= data.add(new String[] {"Ref-Regulation"+i,"Short Name of Regulation"+i,"PerfRegulation"+i,"This is a description of PerfRegulation"+i,
			//        		   "No Additional Info","12/12/2018","12/12/2018","12/12/2019","12/12/2019","Advice"+i,
			//        		   "PerfRegulation"+(i-1),"Ref-Regulation"+(i-1),"In Effect","Confirmed","Active","Guideline","Completed",
			//        		   "Fully Compliant","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Regulation SME"}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					//int randAxonStatus = (int) (Regulation_AxonStatus.length * Math.random());
					int randGovernanceRole = (int) (Regulation_GovernanceRole.length * Math.random());
					int randMaturity = (int) (Regulation_RegulationMaturity.length * Math.random());
					int randType = (int) (Regulation_LegalAdviceType.length * Math.random());
					int randStage = (int) (Regulation_RegulationStage.length * Math.random());
					int randLevel = (int) (Regulation_ComplianceLevel.length * Math.random());
					int randProbability = (int) (Regulation_RegulationProbability.length * Math.random());

					result= data.add(new String[] {Ref_regulation_tmpl+i,"Short Name of "+regulation_tmpl+i,
							regulation_tmpl+i,"This is a description of "+regulation_tmpl+i,
							"No Additional Info","12/12/2018","12/12/2018","12/12/2019","12/12/2019","Advice"+i,
							"","",Regulation_RegulationMaturity[randMaturity],Regulation_RegulationProbability[randProbability],"Active",
							Regulation_LegalAdviceType[randType],Regulation_RegulationStage[randStage],
							Regulation_ComplianceLevel[randLevel],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
							fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
							lan_tmpl+i,Regulation_GovernanceRole[randGovernanceRole],Segment_name});
					
					
					/*result= data.add(new String[] {"Ref-"+Segment_name+"Regulation"+i,"Short Name of "+Segment_name+"Regulation"+i,
							Segment_name+"Regulation"+i,"This is a description of "+Segment_name+"Regulation"+i,
							"No Additional Info","12/12/2018","12/12/2018","12/12/2019","12/12/2019","Advice"+i,
							"","",Regulation_RegulationMaturity[randMaturity],Regulation_RegulationProbability[randProbability],"Active",
							Regulation_LegalAdviceType[randType],Regulation_RegulationStage[randStage],
							Regulation_ComplianceLevel[randLevel],"financeadmin@informatica.com",
							"Finance","Admin",
							"",Regulation_GovernanceRole[randGovernanceRole],"Finance"});*/


				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								//int randAxonStatus = (int) (Regulation_AxonStatus.length * Math.random());
								int randGovernanceRole = (int) (Regulation_GovernanceRole.length * Math.random());
								int randMaturity = (int) (Regulation_RegulationMaturity.length * Math.random());
								int randType = (int) (Regulation_LegalAdviceType.length * Math.random());
								int randStage = (int) (Regulation_RegulationStage.length * Math.random());
								int randLevel = (int) (Regulation_ComplianceLevel.length * Math.random());
								int randProbability = (int) (Regulation_RegulationProbability.length * Math.random());

								result= data.add(new String[] {Ref_regulation_tmpl+i,"Short Name of "+regulation_tmpl+i,
										regulation_tmpl+i,"This is a description of "+regulation_tmpl+i,
										"No Additional Info","12/12/2018","12/12/2018","12/12/2019","12/12/2019","Advice"+i,
										regulation_tmpl+j,Ref_regulation_tmpl+j,Regulation_RegulationMaturity[randMaturity],
										Regulation_RegulationProbability[randProbability],"Active",
										Regulation_LegalAdviceType[randType],Regulation_RegulationStage[randStage],
										Regulation_ComplianceLevel[randLevel],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
										fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
										lan_tmpl+i,Regulation_GovernanceRole[randGovernanceRole],Segment_name}); 
								
								/*result= data.add(new String[] {"Ref-"+Segment_name+"Regulation"+i,"Short Name of "+Segment_name+"Regulation"+i,
										Segment_name+"Regulation"+i,"This is a description of "+Segment_name+"Regulation"+i,
										"No Additional Info","12/12/2018","12/12/2018","12/12/2019","12/12/2019","Advice"+i,
										"","",Regulation_RegulationMaturity[randMaturity],Regulation_RegulationProbability[randProbability],"Active",
										Regulation_LegalAdviceType[randType],Regulation_RegulationStage[randStage],
										Regulation_ComplianceLevel[randLevel],"financeadmin@informatica.com",
										"Finance","Admin",
										"",Regulation_GovernanceRole[randGovernanceRole],"Finance"});*/

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
