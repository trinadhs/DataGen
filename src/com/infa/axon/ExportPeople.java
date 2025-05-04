package com.infa.axon;

import com.infa.data.DropdownData;
import com.opencsv.CSVWriter;
import utility.Utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExportPeople implements DropdownData{

	static String segmentname= DropdownData.Segment_name;

	private static final String CSV_FILE_PATH = "./Bulkuploads/"+segmentname+"/Axon_SourcingTemplate_people.csv"; 

	public static void main(String[] args) 
	{ 
		Axon_SourcingTemplate_people(CSV_FILE_PATH); 
	} 


	public static void Axon_SourcingTemplate_people(String filePath) 
	{ 

		// first create file object for file placed at location 
		// specified by filepath 

		File file = new File(filePath); 
		
		try { 
			System.out.print("People File generation........");
			
			Properties configProps=Utility.readPropertiesFile("config.properties");
			Properties moduleHeaderProps=Utility.readPropertiesFile("header.properties");		


			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 

			CSVWriter writer = new CSVWriter(outputfile); 



			//String[] header = { "First Name","Last Name","Function","Function Description","Description","Email","Password","Axon Status","Org Unit Reference","Org Unit Name","Profile","Office Location","Internal Mail Code","Office Telephone","Mobile/Cell","LAN Id","Employment Type","Lifecycle"  }; 

			String[] header = moduleHeaderProps.getProperty("people.header").split(",");

			writer.writeNext(header); 

			// System.out.println("Enter no of rows"); 
			// int noOfRow = Integer.parseInt(sc.nextLine());

			int noOfOrgunits = Integer.parseInt(configProps.getProperty("No.Orgunits"));

			// System.out.println(noOfOrgunits);

			int NumOfPeoplesforOrg = Integer.parseInt(configProps.getProperty("NumOfPeoplesforOrg"));

			// System.out.println("noof peoples for org"+NumOfPeoplesforOrg);

			int noOfRow = NumOfPeoplesforOrg * noOfOrgunits;

			//System.out.println("No of rows"+noOfRow);

			boolean result=false;
			
			int k=1;

			List<String[]> data = new ArrayList<String[]>();

			while(k <= noOfOrgunits) {

				for (int i = 1; i <= noOfRow;) {

					for (int y=1; y<= NumOfPeoplesforOrg; y++) {

						// System.out.println("noOfRow"+noOfRow);

						int randAxonStatus = (int) (People_AxonStatus.length * Math.random());
						int randEmploymentType = (int) (People_EmploymentType.length * Math.random());
						int randLifecycle = (int) (People_Lifecycle.length * Math.random());
						int randOfficelocation = (int) (People_Officelocation.length * Math.random());
						int randProfile = (int) (People_Profile.length * Math.random());	   

						if(i <= noOfRow) {

							result = data.add(new String[] { fisrtname_tmpl+i , lastname_tmpl+i, "This is a function of "+segmentname+" Name"+i , 
									"This is a function Description of "+segmentname+" Name"+i, "This is a description of "+segmentname+" Name "+i ,
									people_tmpl+i+"@informatica.com" , "Infa@123" , People_AxonStatus[randAxonStatus], Ref_org_tmpl+k , org_tmpl+k ,
									People_Profile[randProfile] , People_Officelocation[randOfficelocation], "ItrMailCode"+i , "123456"+i, "9999999"+i ,
									lan_tmpl+i , People_EmploymentType[randEmploymentType] ,People_Lifecycle[randLifecycle] }); 

							i++;
						}
					}k++;
					
					//System.out.println("i value "+i+"	k value "+k);
					//code added 
					/*if(i>noOfRow) {
						System.out.println("INSIDE IF");
						break;
					} */
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