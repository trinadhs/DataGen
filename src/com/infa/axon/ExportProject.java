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

public class ExportProject implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_project(CSV_FILE_PATH); 
//	} 


	public static void Axon_SourcingTemplate_project(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 

			System.out.print("Project File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		

			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = moduleHeaderProps.getProperty("project.header").split(",");

			writer.writeNext(header); 


			int noOfRow = Integer.parseInt(configProps.getProperty("No.Project"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			// parent level distribution

			int Parentdepth = Integer.parseInt(configProps.getProperty("Prj.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//			      result= data.add(new String[] {"Ref-Project"+i,"PerfProject"+i,"This is a description of PerfProject"+i,
			//        		   "09/09/2018","10/10/2019","PerfProject"+(i-1),"Ref-Project"+(i-1),"Public","Red","Mandatory","Active",
			//        		   "Initiation","Project","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),
			//        		   "0.0.0."+i,"Project Steward"}); 
			//           }
			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					int randAxonViewing = (int) (Project_AxonViewing.length * Math.random());
					//int randAxonStatus = (int) (Project_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Project_ProjectLifecycle.length * Math.random());
					int randGovernanceRole = (int) (Project_GovernanceRole.length * Math.random());
					int randClasification = (int) (Project_Classification.length * Math.random());
					int randType = (int) (Project_ProjectType.length * Math.random());
					int randRAG = (int) (Project_RAG.length * Math.random());

					result= data.add(new String[] {Ref_project_tmpl+i,project_tmpl+i,"This is a description of "+project_tmpl+i,
							projstartdate,projenddate,"","",Project_AxonViewing[randAxonViewing],Project_RAG[randRAG],Project_Classification[randClasification],
							"Active",Project_ProjectLifecycle[randLifecycle],Project_ProjectType[randType],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
							fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
							lan_tmpl+i,Project_GovernanceRole[randGovernanceRole],Segment_name});
					
					/*result= data.add(new String[] {"Ref-"+Segment_name+"Project"+i,Segment_name+"Project"+i,"This is a description of "+Segment_name+"Project"+i,
							"09/09/2018","10/10/2019","","",Project_AxonViewing[randAxonViewing],Project_RAG[randRAG],Project_Classification[randClasification],
							"Active",Project_ProjectLifecycle[randLifecycle],Project_ProjectType[randType],"financeadmin@informatica.com",
							"Finance","Admin",
							"",Project_GovernanceRole[randGovernanceRole],"Admin"});*/

				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								int randAxonViewing = (int) (Project_AxonViewing.length * Math.random());
								//int randAxonStatus = (int) (Project_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Project_ProjectLifecycle.length * Math.random());
								int randGovernanceRole = (int) (Project_GovernanceRole.length * Math.random());
								int randClasification = (int) (Project_Classification.length * Math.random());
								int randType = (int) (Project_ProjectType.length * Math.random());
								int randRAG = (int) (Project_RAG.length * Math.random());


								result= data.add(new String[] {Ref_project_tmpl+i,project_tmpl+i,"This is a description of "+project_tmpl+i,
										projstartdate,projenddate,project_tmpl+j,Ref_project_tmpl+j,Project_AxonViewing[randAxonViewing],Project_RAG[randRAG],Project_Classification[randClasification],
										"Active",Project_ProjectLifecycle[randLifecycle],Project_ProjectType[randType],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
										fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),
										lan_tmpl+i,Project_GovernanceRole[randGovernanceRole],Segment_name});
								
								/*result= data.add(new String[] {"Ref-"+Segment_name+"Project"+i,Segment_name+"Project"+i,"This is a description of "+Segment_name+"Project"+i,
										"09/09/2018","10/10/2019","","",Project_AxonViewing[randAxonViewing],Project_RAG[randRAG],Project_Classification[randClasification],
										"Active",Project_ProjectLifecycle[randLifecycle],Project_ProjectType[randType],"financeadmin@informatica.com",
										"Finance","Admin",
										"",Project_GovernanceRole[randGovernanceRole],"Admin"});*/
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
