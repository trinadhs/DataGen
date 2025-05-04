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

public class ExportGeography implements DropdownData {

//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_geography.csv"; 
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_geography(CSV_FILE_PATH); 
//	} 

	public static void Axon_SourcingTemplate_geography(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 

			System.out.print("Geography File generation........");

			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		


			FileWriter outputfile = new FileWriter(file); 

			CSVWriter writer = new CSVWriter(outputfile); 
			String[] header = moduleHeaderProps.getProperty("geography.header").split(",");

			writer.writeNext(header); 
			int noOfRow = Integer.parseInt(configProps.getProperty("No.Geographies"));

			//Geography parent level destribution
			int Parentdepth = Integer.parseInt(configProps.getProperty("Geo.Parentdepth"));
			int Norootobjs=(noOfRow/Parentdepth)/Parentdepth;
			int objs_set= (noOfRow/Parentdepth)-Norootobjs;
			if(Norootobjs<1)Norootobjs=1;

			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 

			//		 for (int i = 1; i <= noOfRow; i++) {
			//          result= data.add(new String[] {"PerfGeo"+i,"This is a defination of PerfGeo"+i,"PerfGeo"+(i-1)}); 
			//           }

			for (int i = 1; i <= noOfRow; i++) {

				if(i<= Norootobjs) {
                      result= data.add(new String[] {geo_tmpl+i,"This is a defination of "+geo_tmpl+i,"",Segment_name}); 
                  

				}

				else {
					int k=1;
					while(k<=Norootobjs){
						for (int j=1;j<=objs_set;j++) {
							if(i <= noOfRow) { 
		                     result= data.add(new String[] {geo_tmpl+i,"This is a defination of "+geo_tmpl+i,geo_tmpl+j,Segment_name}); 
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
