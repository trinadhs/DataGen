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

public class ExportAttributes implements DropdownData{


//	private static final String CSV_FILE_PATH = "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv"; 
//	
//
//	public static void main(String[] args) 
//	{ 
//		Axon_SourcingTemplate_attribute(CSV_FILE_PATH); 
//	} 


	public static void Axon_SourcingTemplate_attribute(String filePath) 
	{ 
		File file = new File(filePath); 

		try { 
			System.out.print("Attribute File generation........");

			int ds=1,sys=1,gloss=1,sys_set=1;


			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		


			int NumOfAttrforDS= Integer.parseInt(configProps.getProperty("NumOfAttrforDS"));
			//int NumOfAttrforSys= Integer.parseInt(configProps.getProperty("NumOfAttrforSys"));
			int NumOfAttrforGloss= Integer.parseInt(configProps.getProperty("NumOfAttrforGloss"));

			int CustNumOfAttrforDS= Integer.parseInt(configProps.getProperty("NumOfAttrforDS"));
			//int CustNumOfAttrforSys= Integer.parseInt(configProps.getProperty("NumOfAttrforDS"));
			int CustNumOfAttrforGloss= Integer.parseInt(configProps.getProperty("NumOfAttrforGloss"));

			int numofsys= Integer.parseInt(configProps.getProperty("No.Systems"));
			int numofgloss= Integer.parseInt(configProps.getProperty("No.Glossary"));
			int numofdset= Integer.parseInt(configProps.getProperty("No.Datasets"));

			int numofdsforsys= Integer.parseInt(configProps.getProperty("NumOfDSforSystem"));

			//int numoffiles= Integer.parseInt(configProps.getProperty("NumOfAttrFiles"));

			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 



			String[] header = moduleHeaderProps.getProperty("attribute.header").split(",");

			writer.writeNext(header); 


			int noOfRow = Integer.parseInt(configProps.getProperty("No.Attributes"));
			//int noOfpeoples= Integer.parseInt(configProps.getProperty("No.Peoples"));

			//for people creations
			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));
			int noOfpeoples = noOfOrgunits*NumOfPeoplesforOrg;

			sys_set=NumOfAttrforDS*numofdsforsys;


			boolean result=false; 

			List<String[]> data = new ArrayList<String[]>(); 
			int s=1;

			for (int i = 1; i <= noOfRow; i++) {

				if(i==(NumOfAttrforDS+1)) {
					NumOfAttrforDS= NumOfAttrforDS+CustNumOfAttrforDS;
					ds= ds+1;
				}

				//			 if(i==(NumOfAttrforSys+1)) {
				//					
				//				 NumOfAttrforSys= NumOfAttrforSys+CustNumOfAttrforSys;
				//					sys= sys+1;
				//									
				//				}
				//				
				//			 if(sys>numofsys) {
				//				 sys=1;
				//				 s=1;
				//			 }

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

				int randKey = (int) (Attribute_Key.length * Math.random());
				int randRequirement = (int) (Attribute_AttributeRequirement.length * Math.random());
				int randOrigin = (int) (Attribute_Origin.length * Math.random());
				int randEditability = (int) (Attribute_Editability.length * Math.random());
				int randEditabilityRole = (int) (Attribute_EditabilityRole.length * Math.random());
				int randGovernanceRole = (int) (Attribute_GovernanceRole.length * Math.random());



				result= data.add(new String[] { Ref_attrib_tmpl+i,attrib_tmpl+i,"This is a defination of "+Segment_name+" Attribute"+i,
						"DBFormat"+i,Attribute_Key[randKey],"BusinessLogic"+i,Attribute_AttributeRequirement[randRequirement],
						Ref_dset_tmpl+ds,dset_tmpl+ds,sys_tmpl+sys,Ref_gloss_tmpl+gloss,gloss_tmpl+gloss,"",Attribute_Origin[randOrigin],
						Attribute_Editability[randEditability],Attribute_EditabilityRole[randEditabilityRole],"DBFieldName"+i,
						people_tmpl+((i%noOfpeoples)+1)+"@informatica.com",fisrtname_tmpl+((i%noOfpeoples)+1),lastname_tmpl+((i%noOfpeoples)+1),lan_tmpl+i,Attribute_GovernanceRole[randGovernanceRole] });
				
				/*result= data.add(new String[] { Ref_attrib_tmpl+i,attrib_tmpl+i,"This is a defination of "+Segment_name+" Attribute"+i,
						"DBFormat"+i,Attribute_Key[randKey],"BusinessLogic"+i,Attribute_AttributeRequirement[randRequirement],
						Ref_dset_tmpl+ds,dset_tmpl+ds,sys_tmpl+sys,Ref_gloss_tmpl+gloss,gloss_tmpl+gloss,"",Attribute_Origin[randOrigin],
						Attribute_Editability[randEditability],Attribute_EditabilityRole[randEditabilityRole],"DBFieldName"+i,
						"financeadmin@informatica.com","Finance","Admin","",Attribute_GovernanceRole[randGovernanceRole] });*/
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


	public static void systemlogic(int sys) {
		sys=sys+1;
	}
}
