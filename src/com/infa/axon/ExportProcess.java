package com.infa.axon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;

import utility.Utility;

public class ExportProcess implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_process(CSV_FILE_PATH); 
//	} 


	public static void Axon_SourcingTemplate_process(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			
			System.out.print("Process File generation........");
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 

			String[] header = moduleHeaderProps.getProperty("process.header").split(",");
			writer.writeNext(header); 

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Process"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
		
			// parent level distribution

			int Parentdepth = Integer.parseInt(configProps.getProperty("Pro.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;


			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//			 
			//		  result= data.add(new String[] {"PerfProcess"+i,"Ref-Process"+i,"This is a description of PerfProcess"+i,
			//        		   "This is an input description for PerfProcess"+i,"This is an output description of PerfProcess"+i,
			//        		   "End Step","FALSE","TRUE","TRUE","TRUE","TRUE","121","PerfProcess"+(i-1),"Ref-Process"+(i-1),
			//        		   "Public","Inactive","Step","Days","In Production","Execution Process","Fully Automated",
			//        		   "p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Process Steward"}); 
			//           }
			Random random = new Random();
			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					int randAxonViewing = (int) (Process_AxonViewing.length * Math.random());
					//int randAxonStatus = (int) (Process_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Process_Lifecycle.length * Math.random());
					int randGovernanceRole = (int) (Process_GovernanceRole.length * Math.random());
					int randClasification = (int) (Process_Classification.length * Math.random());
					int randStepType = (int) (Process_StepType.length * Math.random());
					int randPermission = (int) (Process_Permission.length * Math.random());
					int randAutomation = (int) (Process_Automation.length * Math.random());
					int randDurationType = (int) (Process_DurationType.length * Math.random());
					int randProcessType = (int) (Process_ProcessType.length * Math.random());

					int duration= random.nextInt(200) + 10;

					result= data.add(new String[] {process_tmpl+i,Ref_process_tmpl+i,
							"This is a description of "+process_tmpl+i,
							"This is an input description for "+process_tmpl+i,"This is an output description of "+process_tmpl+i,
							Process_StepType[randStepType],Process_Permission[randPermission],Process_Permission[randPermission],
							Process_Permission[randPermission],Process_Permission[randPermission],Process_Permission[randPermission],
							""+duration,"","",Process_AxonViewing[randAxonViewing],"Active",Process_ProcessType[randProcessType],
							Process_DurationType[randDurationType],Process_Lifecycle[randLifecycle],Process_Classification[randClasification],
							Process_Automation[randAutomation],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
							fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,
							Process_GovernanceRole[randGovernanceRole],Segment_name}); 
					
					
					/*result= data.add(new String[] {Segment_name+"Process"+i,"Ref-"+Segment_name+"Process"+i,
							"This is a description of "+Segment_name+"Process"+i,
							"This is an input description for "+Segment_name+"Process"+i,"This is an output description of "+Segment_name+"Process"+i,
							Process_StepType[randStepType],Process_Permission[randPermission],Process_Permission[randPermission],
							Process_Permission[randPermission],Process_Permission[randPermission],Process_Permission[randPermission],
							""+duration,"","",Process_AxonViewing[randAxonViewing],"Active",Process_ProcessType[randProcessType],
							Process_DurationType[randDurationType],Process_Lifecycle[randLifecycle],Process_Classification[randClasification],
							Process_Automation[randAutomation],"financeadmin@informatica.com",
							"Finance","Admin","",
							Process_GovernanceRole[randGovernanceRole],"Finance"});*/


				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (Process_AxonViewing.length * Math.random());
								//int randAxonStatus = (int) (Process_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Process_Lifecycle.length * Math.random());
								int randGovernanceRole = (int) (Process_GovernanceRole.length * Math.random());
								int randClasification = (int) (Process_Classification.length * Math.random());
								int randStepType = (int) (Process_StepType.length * Math.random());
								int randPermission = (int) (Process_Permission.length * Math.random());
								int randAutomation = (int) (Process_Automation.length * Math.random());
								int randDurationType = (int) (Process_DurationType.length * Math.random());
								int randProcessType = (int) (Process_ProcessType.length * Math.random());

								int duration= random.nextInt(200) + 10;

								result= data.add(new String[] {process_tmpl+i,Ref_process_tmpl+i,
										"This is a description of "+process_tmpl+i,
										"This is an input description for "+process_tmpl+i,"This is an output description of "+process_tmpl+i,
										Process_StepType[randStepType],Process_Permission[randPermission],Process_Permission[randPermission],
										Process_Permission[randPermission],Process_Permission[randPermission],Process_Permission[randPermission],
										""+duration,process_tmpl+j,Ref_process_tmpl+j,Process_AxonViewing[randAxonViewing],"Active",Process_ProcessType[randProcessType],
										Process_DurationType[randDurationType],Process_Lifecycle[randLifecycle],Process_Classification[randClasification],
										Process_Automation[randAutomation],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
										fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,
										Process_GovernanceRole[randGovernanceRole],Segment_name}); 
								
								

								/*result= data.add(new String[] {Segment_name+"Process"+i,"Ref-"+Segment_name+"Process"+i,
										"This is a description of "+Segment_name+"Process"+i,
										"This is an input description for "+Segment_name+"Process"+i,"This is an output description of "+Segment_name+"Process"+i,
										Process_StepType[randStepType],Process_Permission[randPermission],Process_Permission[randPermission],
										Process_Permission[randPermission],Process_Permission[randPermission],Process_Permission[randPermission],
										""+duration,"","",Process_AxonViewing[randAxonViewing],"Active",Process_ProcessType[randProcessType],
										Process_DurationType[randDurationType],Process_Lifecycle[randLifecycle],Process_Classification[randClasification],
										Process_Automation[randAutomation],"financeadmin@informatica.com",
										"Finance","Admin","",
										Process_GovernanceRole[randGovernanceRole],"Finance"});*/

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
