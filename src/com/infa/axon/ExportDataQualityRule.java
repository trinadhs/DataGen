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

public class ExportDataQualityRule implements DropdownData {

	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-quality-rule.csv"; 

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_dataqualityrule(CSV_FILE_PATH); 
	} 


	public static void Axon_SourcingTemplate_dataqualityrule(String filePath) 
	{ 
		File file = new File(filePath); 

		try {   
			
			System.out.print("DataQuality Rule File generation........");
			
			int ds=1,sys=1,gloss=1,sys_set=1,s=1;
			
			
			// Attribute Values starts From
			
		    int NumOfAttrforDS= Integer.parseInt(configProps.getProperty("NumOfAttrforDS"));
			
			int NumOfAttrforGloss= Integer.parseInt(configProps.getProperty("NumOfAttrforGloss"));

			int CustNumOfAttrforDS= Integer.parseInt(configProps.getProperty("NumOfAttrforDS"));
			
			int CustNumOfAttrforGloss= Integer.parseInt(configProps.getProperty("NumOfAttrforGloss"));

			int numofsys= Integer.parseInt(configProps.getProperty("No.Systems"));
			int numofgloss= Integer.parseInt(configProps.getProperty("No.Glossary"));
			int numofdset= Integer.parseInt(configProps.getProperty("No.Datasets"));

			int numofdsforsys= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));

			
			//Attributes Values  END
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("dqrule.header").split(",");

			writer.writeNext(header); 


			int noOfRow = Integer.parseInt(configProps.getProperty("No.Dqrules"));
			
			
			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
			sys_set=NumOfAttrforDS*numofdsforsys;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			for (int i = 1; i <= noOfRow; i++) {
				
				int randDQRule_Criticality = (int) (DQRule_Criticality.length * Math.random());
				int randDQRule_AxonViewing = (int) (DQRule_AxonViewing.length * Math.random());
				int randDQRule_RuleType = (int) (DQRule_RuleType.length * Math.random());
				int randDQRule_RuleTypestr = (int) (DQRule_RuleTypeStr.length * Math.random());
				int randDQRule_Frequency = (int) (DQRule_Frequency.length * Math.random());
				int randDQRule_Lifecycle = (int) (DQRule_Lifecycle.length * Math.random());
				int randDQRule_AxonStatus = (int) (DQRule_AxonStatus.length * Math.random());
				int randDQRule_MeasuringMethod = (int) (DQRule_MeasuringMethod.length * Math.random());
				int randDQRule_AutomationLevel = (int) (DQRule_AutomationLevel.length * Math.random());
				int randDQRule_GovernanceRole = (int) (DQRule_GovernanceRole.length * Math.random());
				
				String hour = String.valueOf(Math.round(22 * Math.random())+1);
				String day = String.valueOf(Math.round(6 * Math.random())+1);
				String month = String.valueOf(Math.round(11 * Math.random())+1);
				String date = String.valueOf(Math.round(29 * Math.random())+1);
				
				
				if(i==(NumOfAttrforDS+1)) {
					NumOfAttrforDS= NumOfAttrforDS+CustNumOfAttrforDS;
					ds= ds+1;
				}	
				
				if(s==(sys_set*sys)+1) {			

					sys= sys+1;
					if(sys>numofsys) {
						sys=1;
						s=1;
					}

				}

				s++;

				if(i==(NumOfAttrforGloss+1)) {

					NumOfAttrforGloss= NumOfAttrforGloss+CustNumOfAttrforGloss;
					gloss= gloss+1;

				}

				if(gloss>numofgloss) {
					gloss=1;
				}				
				
				if(ds>numofdset) { 
					ds=1;
					sys=1;s=2;

				}
								
				/*result= data.add(new String[] {Segment_name+"Rule"+i,"This is a description of "+Segment_name+"Rule"+i,
						"Ref-"+Segment_name+"Rule"+i,"High",
						"This is a technical description of Rule"+i,"This is a population description of Rule"+i,
						"This is a measuring method description of Rule"+i,"70","90","Public","PerfSystem1",
						"Completeness","Daily","Active","Active","System Function","Fully Automated","",
						"Ref-Attribute1","Attribute1","PerfDS1","PerfSystem2",Segment_name+((i%noOfpeoples)+1)+"@informatica.com",
						Segment_name+" First Name "+((i%noOfpeoples)+1),Segment_name+" Last Name "+((i%noOfpeoples)+1),
						"0.0.0."+i,"DQ Steward"});*/
				
				result= data.add(new String[] {dqrule_tmpl+i,"This is a description of "+dqrule_tmpl+i,Ref_dqrule_tmpl+i,"This is a technical description of "+dqrule_tmpl+i,"This is a population description of"+dqrule_tmpl+i,
						"This is a measuring method description of "+dqrule_tmpl+i,"70","90","Public","",
						DQRule_RuleType[randDQRule_RuleType],DQRule_Lifecycle[randDQRule_Lifecycle],DQRule_AxonStatus[randDQRule_AxonStatus],DQRule_MeasuringMethod[randDQRule_MeasuringMethod],
						DQRule_Criticality[randDQRule_Criticality],DQRule_AutomationLevel[randDQRule_AutomationLevel],"",DQRule_RuleTypeStr[randDQRule_RuleTypestr],
						DQRule_Frequency[randDQRule_Frequency],hour,day,month,date,dqstartdate,"TRUE",
						Ref_attrib_tmpl+i,attrib_tmpl+i,dset_tmpl+ds,sys_tmpl+sys,Ref_gloss_tmpl+gloss,gloss_tmpl+gloss,"",
						people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
						lan_tmpl+i,DQRule_GovernanceRole[randDQRule_GovernanceRole]}); 
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
