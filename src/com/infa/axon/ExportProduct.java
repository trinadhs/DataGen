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

public class ExportProduct implements DropdownData {
	
//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_product(CSV_FILE_PATH); 
//	} 



	public static void Axon_SourcingTemplate_product(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			System.out.print("Product File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		


			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 



			String[] header = moduleHeaderProps.getProperty("product.header").split(",");

			writer.writeNext(header); 


			int noOfRow = Integer.parseInt(configProps.getProperty("No.Product"));
			//	int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
			
			// parent level distribution

			int Parentdepth = Integer.parseInt(configProps.getProperty("Prod.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			
			if(Norootobjs<1)Norootobjs=1;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//			   result= data.add(new String[] {"Ref-Product"+i,"PerfProduct"+i,"Long Name of Product"+i,
			//        		   "This is a description of PerfProduct"+i,"PerfProduct"+(i-1),"Obsolete","Active","Public",
			//        		   "p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Product Steward"}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {


					int randAxonViewing = (int) (Product_AxonViewing.length * Math.random());
					//int randAxonStatus = (int) (Product_AxonStatus.length * Math.random());
					int randLifecycle = (int) (Product_Lifecycle.length * Math.random());
					int randGovernanceRole = (int) (Product_GovernanceRole.length * Math.random());

					result= data.add(new String[] {Ref_product_tmpl+i,product_tmpl+i,"Long Name of "+product_tmpl+i,
							"This is a description of "+product_tmpl+i,"",Product_Lifecycle[randLifecycle],"Active",Product_AxonViewing[randAxonViewing],
							people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),
							lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Product_GovernanceRole[randGovernanceRole],Segment_name}); 
					
					/*result= data.add(new String[] {"Ref-"+Segment_name+"Product"+i,Segment_name+"Product"+i,"Long Name of "+Segment_name+"Product"+i,
							"This is a description of "+Segment_name+"Product"+i,"",Product_Lifecycle[randLifecycle],"Active",Product_AxonViewing[randAxonViewing],
							"financeadmin@informatica.com","Finance",
							"Admin","",Product_GovernanceRole[randGovernanceRole],"Finacne"});*/


				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 
								
								int randAxonViewing = (int) (Product_AxonViewing.length * Math.random());
								//int randAxonStatus = (int) (Product_AxonStatus.length * Math.random());
								int randLifecycle = (int) (Product_Lifecycle.length * Math.random());
								int randGovernanceRole = (int) (Product_GovernanceRole.length * Math.random());


								result= data.add(new String[] {Ref_product_tmpl+i,product_tmpl+i,"Long Name of "+product_tmpl+i,
										"This is a description of "+product_tmpl+i,product_tmpl+j,Product_Lifecycle[randLifecycle],"Active",Product_AxonViewing[randAxonViewing],
										people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),
										lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Product_GovernanceRole[randGovernanceRole],Segment_name}); 
								
								/*result= data.add(new String[] {"Ref-"+Segment_name+"Product"+i,Segment_name+"Product"+i,"Long Name of "+Segment_name+"Product"+i,
										"This is a description of "+Segment_name+"Product"+i,"",Product_Lifecycle[randLifecycle],"Active",Product_AxonViewing[randAxonViewing],
										"financeadmin@informatica.com","Finance",
										"Admin","",Product_GovernanceRole[randGovernanceRole],"Finacne"});*/

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
