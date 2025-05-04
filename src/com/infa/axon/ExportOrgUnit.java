package com.infa.axon;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;
import utility.Utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExportOrgUnit implements DropdownData    {

	static String segmentname= DropdownData.Segment_name;
	static List<String[]> data = new ArrayList<String[]>();
	
	private static final String CSV_FILE_PATH = "./Bulkuploads/"+segmentname+"/Axon_SourcingTemplate_org-unit.csv";

	public static void main(String[] args) {
		Axon_SourcingTemplateOrgunit(CSV_FILE_PATH);
	}

	public static void Axon_SourcingTemplateOrgunit(String filePath) {

		// first create file object for file placed at location
		// specified by filepath

		File file = new File(filePath);

		try {
			
			System.out.print("OrgUnit File generation........");

			Properties configProps = Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps = Utility.readPropertiesFile("header.properties");

			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			CSVWriter writer = new CSVWriter(outputfile);

			// String[] header = { "Org Unit Name", "Description", "Reference" , "Parent Org
			// Unit Reference" , "Axon Status" };


			String[] header = moduleHeaderProps.getProperty("org.header").split(",");

			writer.writeNext(header);

			// System.out.println("Enter no of rows");
			// int noOfRow = Integer.parseInt(sc.nextLine());

			int noOfRow = Integer.parseInt(configProps.getProperty("No.Orgunits"));
			int org_parentdepth = Integer.parseInt(configProps.getProperty("org.Parentdepth"));

			//	int Norootorgs = Integer.parseInt(configProps.getProperty("No.rootorgs"));

			int Norootorgs = (noOfRow/org_parentdepth)/org_parentdepth;

			int org_set= (noOfRow/org_parentdepth)-Norootorgs;

			// create a List which contains String array

			boolean result = false;

			for (int i = 1; i <= noOfRow; i++) {
				//System.out.println("***********************" + i);

				if (i <= Norootorgs) {

					

					result = data.add(	
							/*	new String[] { segmentname+"Org" + i, "This Org Unit represents the description of "+segmentname+"Org" + i,
									"Ref-"+segmentname+"Org" + i, "", "Active" });*/

							new String[] { org_tmpl + i, "This Org Unit represents the description of "+org_tmpl + i,
									Ref_org_tmpl + i, "", "Active"});
					
				}

				//				else if (i > Norootorgs && i <= org_set) {
				//					for (int j=1;j<=org_set;j++) {
				//					result = data.add(
				//							new String[] { "PerfOrg" + i, "This Org Unit represents the description of PerfOrg" + i,
				//									"Ref-PerfOrg" + i, "Ref-PerfOrg" + j, "Active" });
				//					i++;
				//					}
				//				}

				else {
					//System.out.println("INSIDE ELSE"+Norootorgs);
					int k=1;
					//Norootorgs 4
					while(k<=Norootorgs){
						//16 times
						for (int j=1;j<=org_set;j++) {
							if(i <= noOfRow) {
								result = data.add(new String[] { org_tmpl + i, "This Org Unit represents the description of "+org_tmpl + i,
										Ref_org_tmpl + i, Ref_org_tmpl + j, "Active" });
							}i++;
						}
						k++;

					}i--;
					
				}

				if (!result) {
					System.out.println("Org unit Creating row failed");
					System.exit(0);
				}
			}

			writer.writeAll(data);

			// closing writer connection
			writer.close();
			if (result) {
				System.out.print("Completed.\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}