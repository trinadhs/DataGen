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

public class ExportPolicy implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_policy(CSV_FILE_PATH); 
//	} 

	public static void Axon_SourcingTemplate_policy(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			System.out.print("Policy File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = moduleHeaderProps.getProperty("policy.header").split(",");

			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Policies"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			//Policy parent level distribution

			int pol_Parentdepth = Integer.parseInt(configProps.getProperty("Pol.Parentdepth"));
			int Norootobjs=(noOfRow/pol_Parentdepth)/pol_Parentdepth;
			int objs_set= (noOfRow/pol_Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;
			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//			  result= data.add(new String[] {"PerfPolicy"+i,"Ref-Policy"+i,"FALSE","PolicyURL"+i,"This is a description of PerfPolicy"+i,
			//        		   "12/12/2018","12/12/2019","PerfPolicy"+(i-1),"Ref-Policy"+(i-1),"Public","Inactive",
			//        		   "Enforced","Data Standards","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Policy Steward"}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					int randAxonViewing = (int) (Policy_AxonViewing.length * Math.random());
					// int randAxonStatus = (int) (Policy_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Policy_PolicyLifecycle.length * Math.random());
					int randGovernanceRole = (int) (Policy_GovernanceRole.length * Math.random());
					int randInternal = (int) (Policy_Internal.length * Math.random());
					int randType = (int) (Policy_PolicyType.length * Math.random());

					result= data.add(new String[] {policy_tmpl+i,Ref_policy_tmpl+i,Policy_Internal[randInternal],
							policy_tmpl+"URL"+i,"This is a description of "+policy_tmpl+i,
							policyeffectivedate,policyenddate,"","",Policy_AxonViewing[randAxonViewing],"Active",
							Policy_PolicyLifecycle[randLifecycle],Policy_PolicyType[randType],
							people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),
							lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Policy_GovernanceRole[randGovernanceRole],Segment_name}); 
					
					/*result= data.add(new String[] {Segment_name+"Policy"+i,"Ref-"+Segment_name+"Policy"+i,Policy_Internal[randInternal],
							"Policy"+Segment_name+"URL"+i,"This is a description of "+Segment_name+"Policy"+i,
							"12/12/2018","12/12/2019","","",Policy_AxonViewing[randAxonViewing],"Active",
							Policy_PolicyLifecycle[randLifecycle],Policy_PolicyType[randType],
							"financeadmin@informatica.com","Finance",
							"Admin","",Policy_GovernanceRole[randGovernanceRole],"Finance"});*/
				
				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (Policy_AxonViewing.length * Math.random());
								// int randAxonStatus = (int) (Policy_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Policy_PolicyLifecycle.length * Math.random());
								int randGovernanceRole = (int) (Policy_GovernanceRole.length * Math.random());
								int randInternal = (int) (Policy_Internal.length * Math.random());
								int randType = (int) (Policy_PolicyType.length * Math.random());

								result= data.add(new String[] {policy_tmpl+i,Ref_policy_tmpl+i,Policy_Internal[randInternal],
										policy_tmpl+"URL"+i,"This is a description of "+policy_tmpl+i,
										policyeffectivedate,policyenddate,policy_tmpl+j,Ref_policy_tmpl+j,Policy_AxonViewing[randAxonViewing],"Active",
										Policy_PolicyLifecycle[randLifecycle],Policy_PolicyType[randType],
										people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),
										lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Policy_GovernanceRole[randGovernanceRole],Segment_name});
								
								/*result= data.add(new String[] {Segment_name+"Policy"+i,"Ref-"+Segment_name+"Policy"+i,Policy_Internal[randInternal],
										"Policy"+Segment_name+"URL"+i,"This is a description of "+Segment_name+"Policy"+i,
										"12/12/2018","12/12/2019","","",Policy_AxonViewing[randAxonViewing],"Active",
										Policy_PolicyLifecycle[randLifecycle],Policy_PolicyType[randType],
										"financeadmin@informatica.com","Finance",
										"Admin","",Policy_GovernanceRole[randGovernanceRole],"Finance"});*/

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
