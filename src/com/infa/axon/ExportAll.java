package com.infa.axon;


import java.io.File;
import com.infa.data.DropdownData;
import com.infa.relations.AttributeRelations;
import com.infa.relations.BusinessRelations;
import com.infa.relations.CapabilityRelations;
import com.infa.relations.CommitteeRelations;
import com.infa.relations.DatasetRelations;
import com.infa.relations.GlossaryRelations;
import com.infa.relations.InterfaceRelations;
import com.infa.relations.LegalEntityRelations;
import com.infa.relations.PeopleRelations;
import com.infa.relations.PolicyRelations;
import com.infa.relations.ProcessRelations;
import com.infa.relations.ProductRelations;
import com.infa.relations.ProjectRelations;
import com.infa.relations.RegulationRelations;
import com.infa.relations.RegulatorRelations;
import com.infa.relations.SystemRelations;




public class ExportAll implements DropdownData{

	
	static String OrgfilePath= "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_org-unit.csv";
	static String PeoplefilePath= "./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_people.csv"; 
	static String SystemfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_system.csv";
	static String GlossaryfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_glossary.csv";
	static String DatasetfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-set.csv";
	static String AttributesfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_attribute.csv";
	static String BusinessAreafilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_business-area.csv";
	static String CapabilityfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_capability.csv";
	static String ClientfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_client.csv";
	static String CommitteefilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_committee.csv";
	static String DataQualityReportfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-quality-report.csv";
	static String DataQualityRulefilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_data-quality-rule.csv";
	static String GeographyfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_geography.csv";
	static String InterfacefilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_interface.csv";
	static String LegalEntityfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_legal-entity.csv";
	static String PolicyfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_policy.csv";
	static String ProcessfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_process.csv";
	static String ProductfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_product.csv";
	static String ProjectfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_project.csv";
	static String RegulationfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulation.csv";
	static String RegulatorfilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulator.csv";
	static String RegulatoryThemefilePath="./Bulkuploads/"+Segment_name+"/Axon_SourcingTemplate_regulatory-theme.csv";
	
	
	
	
	
	 public static void main(String[] args) 
	    { 
		 
		 String PATH = "./Bulkuploads/"+Segment_name+"/";
		 
		 File directory = new File(PATH);
		    if (! directory.exists()){
		        directory.mkdir();
		    }
		   
		    //Objects
		    
		    ExportOrgUnit.Axon_SourcingTemplateOrgunit(OrgfilePath);
     	    ExportPeople.Axon_SourcingTemplate_people(PeoplefilePath); 
     	    ExportSystem.Axon_SourcingTemplate_system(SystemfilePath);
     	    ExportGlossary.Axon_SourcingTemplate_glossary(GlossaryfilePath);
    	    ExportDataset.Axon_SourcingTemplate_dataset(DatasetfilePath);
     	    ExportAttributes.Axon_SourcingTemplate_attribute(AttributesfilePath);
            SplitAttributes.main(args);
            ExportBusinessArea.Axon_SourcingTemplate_businessArea(BusinessAreafilePath);
            ExportCapability.Axon_SourcingTemplate_capability(CapabilityfilePath);
            ExportClient.Axon_SourcingTemplate_client(ClientfilePath);
    		ExportCommittee.Axon_SourcingTemplate_committee(CommitteefilePath);	
			ExportDataQualityRule.Axon_SourcingTemplate_dataqualityrule(DataQualityRulefilePath);	
 			ExportDataQualityReport.Axon_SourcingTemplate_dataqualityreport(DataQualityReportfilePath);
 	    	ExportInterface.Axon_SourcingTemplate_interface(InterfacefilePath);
    	    ExportLegalEntity.Axon_SourcingTemplate_legalentity(LegalEntityfilePath);			 
			ExportPolicy.Axon_SourcingTemplate_policy(PolicyfilePath);
			ExportProcess.Axon_SourcingTemplate_process(ProcessfilePath);
			ExportProduct.Axon_SourcingTemplate_product(ProductfilePath);
			ExportProject.Axon_SourcingTemplate_project(ProjectfilePath);			 
			ExportRegulation.Axon_SourcingTemplate_regulation(RegulationfilePath);
			ExportRegulator.Axon_SourcingTemplate_regulator(RegulatorfilePath);
			ExportRegulatoryTheme.Axon_SourcingTemplate_regulatorytheme(RegulatoryThemefilePath);
			ExportGeography.Axon_SourcingTemplate_geography(GeographyfilePath);
			 
			 
			 //Relations
	    
//     	    BusinessRelations.main(args);
//		    CapabilityRelations.main(args);
//		    CommitteeRelations.main(args);
//		    InterfaceRelations.main(args);
//		    LegalEntityRelations.main(args);
//		    SystemRelations.main(args);
//		    ProductRelations.main(args);
//		    PeopleRelations.main(args);
//		    RegulationRelations.main(args);
//		    RegulatorRelations.main(args);
//		    GlossaryRelations.main(args);
//		    DatasetRelations.main(args);
//		    ProjectRelations.main(args);
//		    PolicyRelations.main(args);
//     	    ProcessRelations.main(args);
//		    AttributeRelations.main(args); 
		 
		 System.out.println("Data Generation Completed");
		 	 
	    } 

	 
}
