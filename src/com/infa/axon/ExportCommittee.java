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

public class ExportCommittee implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_committee(CSV_FILE_PATH); 
//	} 

	public static void Axon_SourcingTemplate_committee(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			System.out.print("Committee File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			FileWriter outputfile = new FileWriter(file); 
			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("committee.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Committees"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			// parent level distribution

			int Parentdepth = Integer.parseInt(configProps.getProperty("Comm.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//            result= data.add(new String[] {"Ref-Committee"+i,"PerfCommittee"+i,"This is a description of PerfCommittee"+i,"PerfCommittee"+(i-1),"Ref-Committee"+(i-1),"Public","Core Governance Entity","Inactive","Obsolete","Working Group","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Committee Chair"}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					int randAxonViewing = (int) (Committee_AxonViewing.length * Math.random());
					// int randAxonStatus = (int) (Committee_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Committee_Lifecycle.length * Math.random());
					int randGovernanceRole = (int) (Committee_GovernanceRole.length * Math.random());
					int randClasification = (int) (Committee_Classification.length * Math.random());
					int randType = (int) (Committee_CommitteeType.length * Math.random());

					result= data.add(new String[] {Ref_committee_tmpl+i,committee_tmpl+i,
							"This is a description of "+committee_tmpl+i,"","",
							Committee_AxonViewing[randAxonViewing],Committee_Classification[randClasification],"Active",
							Committee_Lifecycle[randLifecycle],Committee_CommitteeType[randType],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
							fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Committee_GovernanceRole[randGovernanceRole],Segment_name});
					
					/*result= data.add(new String[] {"Ref-"+Segment_name+"Committee"+i,Segment_name+"Committee"+i,
							"This is a description of "+Segment_name+"Committee"+i,"","",
							Committee_AxonViewing[randAxonViewing],Committee_Classification[randClasification],"Active",
							Committee_Lifecycle[randLifecycle],Committee_CommitteeType[randType],"financeadmin@informatica.com",
							"Finance","Admin","",Committee_GovernanceRole[randGovernanceRole],"Finance"});*/


				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (Committee_AxonViewing.length * Math.random());
								// int randAxonStatus = (int) (Committee_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Committee_Lifecycle.length * Math.random());
								int randGovernanceRole = (int) (Committee_GovernanceRole.length * Math.random());
								int randClasification = (int) (Committee_Classification.length * Math.random());
								int randType = (int) (Committee_CommitteeType.length * Math.random());

								result= data.add(new String[] {Ref_committee_tmpl+i,committee_tmpl+i,
										"This is a description of "+committee_tmpl+i,committee_tmpl+j,Ref_committee_tmpl+j,
										Committee_AxonViewing[randAxonViewing],Committee_Classification[randClasification],"Active",
										Committee_Lifecycle[randLifecycle],Committee_CommitteeType[randType],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
										fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Committee_GovernanceRole[randGovernanceRole],Segment_name}); 
								
								/*result= data.add(new String[] {"Ref-"+Segment_name+"Committee"+i,Segment_name+"Committee"+i,
										"This is a description of "+Segment_name+"Committee"+i,"","",
										Committee_AxonViewing[randAxonViewing],Committee_Classification[randClasification],"Active",
										Committee_Lifecycle[randLifecycle],Committee_CommitteeType[randType],"financeadmin@informatica.com",
										"Finance","Admin","",Committee_GovernanceRole[randGovernanceRole],"Finance"});*/


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
