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

public class ExportRegulatoryTheme implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulatory-theme.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_regulatorytheme(CSV_FILE_PATH); 
//	} 




	public static void Axon_SourcingTemplate_regulatorytheme(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			
			System.out.print("RegulatoryTheme File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		
			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = moduleHeaderProps.getProperty("regulatorytheme.header").split(",");
			writer.writeNext(header); 
		
			int noOfRow = Integer.parseInt(configProps.getProperty("No.Regulatorytheme"));
			
			// parent level distribution

			int Parentdepth = Integer.parseInt(configProps.getProperty("Comm.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//			 result= data.add(new String[] {"Ref-RT"+i,"Short name of Regulatory Theme"+i,"PerfRT"+i,
			//        		   "Description of RegulatoryTheme"+i,"PerfRT"+(i-1),"Ref-RT"+(i-1),"Active"}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {

					String RegTheme_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
					// int randAxonStatus = (int) (Committee_AxonStatus.length * Math.random());
					
					result= data.add(new String[] {Ref_RT_tmpl+i,"Short name of "+RT_tmpl+i,RT_tmpl+i,
						       		   "Description of "+RT_tmpl+i,"","","Active",Segment_name}); 
					
					/*result= data.add(new String[] {"Ref-"+Segment_name+"RT"+i,"Short name of "+Segment_name+"Regulatory Theme"+i,Segment_name+"RT"+i,
				       		   "Description of "+Segment_name+"RegulatoryTheme"+i,"","","Active","Finance"}); */

				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 

								result= data.add(new String[] {Ref_RT_tmpl+i,"Short name of "+RT_tmpl+i,RT_tmpl+i,
							       		   "Description of "+RT_tmpl+i,RT_tmpl+j,Ref_RT_tmpl+j,"Active",Segment_name});
								
								/*result= data.add(new String[] {"Ref-"+Segment_name+"RT"+i,"Short name of "+Segment_name+"Regulatory Theme"+i,Segment_name+"RT"+i,
							       		   "Description of "+Segment_name+"RegulatoryTheme"+i,"","","Active","Finance"});*/
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
