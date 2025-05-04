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

public class ExportBusinessArea implements DropdownData {
	
private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv"; 
	
    public static void main(String[] args) 
    { 
    	Axon_SourcingTemplate_businessArea(CSV_FILE_PATH); 
    } 


public static void Axon_SourcingTemplate_businessArea(String filePath) 
{ 
File file = new File(filePath); 
   	
    try { 
    	
    	System.out.print("BusinessArea File generation........");   
    	    	 
    	Properties configProps=Utility.readPropertiesFile("config.properties");
    	
		Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
		
        FileWriter outputfile = new FileWriter(file); 
  
        CSVWriter writer = new CSVWriter(outputfile); 
			
		String[] header = moduleHeaderProps.getProperty("businessarea.header").split(",");
       
        writer.writeNext(header); 
					
		int noOfRow = Integer.parseInt(configProps.getProperty("No.BUAreas"));
		//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));
		
		//for people creations
		int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
		int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
		int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;
		
		//BisunessArea unit parent level destribution
		int Bu_Parentdepth = Integer.parseInt(configProps.getProperty("Bu.Parentdepth"));
		int Norootglos=(noOfRow/Bu_Parentdepth)/Bu_Parentdepth;
		int Bu_set= (noOfRow/Bu_Parentdepth)-Norootglos;
		
		boolean result=false; 
	    			
        List<String[]> data = new ArrayList<String[]>(); 
		
//		 for (int i = 1; i <= noOfRow; i++) {
//				 	
//           result= data.add(new String[] {Segment_name+"BA"+i,"This is a descriptipon of "+Segment_name+"BA"+i,"PerfBA"+(i-1),"Public","Active",
//        		   "Operating","p"+((i%noOfpeoples)+1)+"@informatica.com","Perf First Name "+((i%noOfpeoples)+1),"Perf Last Name "+((i%noOfpeoples)+1),"0.0.0."+i,"Business Area Head"}); 
//           }
          

		for (int i = 1; i <= noOfRow; i++) {

			if(i<= Norootglos) {
				
			
				int randAxonViewing = (int) (BArea_AxonViewing.length * Math.random());
				// int randAxonStatus = (int) (BArea_AxonStatus.length * Math.random());
				int randLifecycle = (int) (BArea_Lifecycle.length * Math.random());
				int randGovernanceRole = (int) (BArea_GovernanceRole.length * Math.random());
				
				result= data.add(new String[] {businessarea_tmpl+i,"This is a descriptipon of "+businessarea_tmpl+i,
						"",BArea_AxonViewing[randAxonViewing],"Active", BArea_Lifecycle[randLifecycle],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
						fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,BArea_GovernanceRole[randGovernanceRole],Segment_name}); 
				
				/*result= data.add(new String[] {Segment_name+"BA"+i,"This is a descriptipon of "+Segment_name+"BA"+i,
						"",BArea_AxonViewing[randAxonViewing],"Active", BArea_Lifecycle[randLifecycle],"financeadmin@informatica.com","Finance","Admin","",BArea_GovernanceRole[randGovernanceRole],"Finance"});*/
	        	}

			else {
				int k=1;
				while(k<=Norootglos){
					for (int j=1;j<=Bu_set;j++) {
						if(i <= noOfRow) {
							
							int randAxonViewing = (int) (BArea_AxonViewing.length * Math.random());
							// int randAxonStatus = (int) (BArea_AxonStatus.length * Math.random());
							int randLifecycle = (int) (BArea_Lifecycle.length * Math.random());
							int randGovernanceRole = (int) (BArea_GovernanceRole.length * Math.random());
												
							result= data.add(new String[] {businessarea_tmpl+i,"This is a descriptipon of "+businessarea_tmpl+i,
									businessarea_tmpl+j,BArea_AxonViewing[randAxonViewing],"Active", BArea_Lifecycle[randLifecycle],people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",
									fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,BArea_GovernanceRole[randGovernanceRole],Segment_name});
							
							/*result= data.add(new String[] {Segment_name+"BA"+i,"This is a descriptipon of "+Segment_name+"BA"+i,
									"",BArea_AxonViewing[randAxonViewing],"Active", BArea_Lifecycle[randLifecycle],"financeadmin@informatica.com",
									" Finance","Admin","",BArea_GovernanceRole[randGovernanceRole],"Finance"});*/
							
							
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
