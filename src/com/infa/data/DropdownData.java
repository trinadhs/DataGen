package com.infa.data;

//import java.io.IOException;
import java.util.Properties;

import utility.Utility;

public interface DropdownData {
	
	
		Properties configProps= Utility.readPropertiesFile("config.properties");
		
		String Segment_name =configProps.getProperty("Segmentname");
	
//	  Properties prop = 
			  
	   // String Segment_name ="MGNT";
		
		
	
	    String profile[] = { "WebUser","Admin","SuperAdmin"};
	    
	    
	    String Ref_org_tmpl  		 =  "Ref-"+Segment_name+"_"+"Org";
	    String Ref_gloss_tmpl  		 =  "Ref-"+Segment_name+"_"+"Glossary";
	    String Ref_dset_tmpl  		 =  "Ref-"+Segment_name+"_"+"DS";
	    String Ref_attrib_tmpl 		 =  "Ref-"+Segment_name+"_"+"Attribute";
	    String Ref_capability_tmpl   =  "Ref-"+Segment_name+"_"+"Capability";
	    String Ref_businessarea_tmpl =  "Ref-"+Segment_name+"_"+"BA";
	    String Ref_client_tmpl 		 =  "Ref-"+Segment_name+"_"+"Client";
	    String Ref_process_tmpl		 =  "Ref-"+Segment_name+"_"+"Process";
	    String Ref_product_tmpl		 =  "Ref-"+Segment_name+"_"+"Product";
	    String Ref_committee_tmpl	 =  "Ref-"+Segment_name+"_"+"Committee";
	    String Ref_policy_tmpl		 =  "Ref-"+Segment_name+"_"+"Policy";
	    String Ref_project_tmpl		 =  "Ref-"+Segment_name+"_"+"Project";
	    String Ref_regulation_tmpl	 =  "Ref-"+Segment_name+"_"+"Regulation";
	    String Ref_RT_tmpl		     =  "Ref-"+Segment_name+"_"+"RT";
	    String Ref_regulator_tmpl    =  "Ref-"+Segment_name+"_"+"regulator";
	    String Ref_interface_tmpl	 =  "REF-"+Segment_name+"_"+"Interface";
	    String Ref_dqrule_tmpl	     =  "REF-"+Segment_name+"_"+"Rule";


	    
	    String org_tmpl			  =	  Segment_name+" "+"Org";
	    String sys_tmpl			  =	  Segment_name+" "+"System";
	    String people_tmpl		  =	  Segment_name+"_";
	    String lan_tmpl		      =	  Segment_name+"_"+"0.0.0.";
	    String fisrtname_tmpl	  =   Segment_name+" First Name ";
	    String lastname_tmpl	  =   Segment_name+" Last Name ";
	    String gloss_tmpl         =   Segment_name+" "+"Glossary";
	    String dset_tmpl	      =   Segment_name+" "+"DS";
	    String attrib_tmpl 	      =   Segment_name+" "+"Attribute";
	    String capability_tmpl 	  =   Segment_name+" "+"Capability";
	    String businessarea_tmpl  =   Segment_name+" "+"BA";
	    String client_tmpl 	      =   Segment_name+" "+"Client";
	    String legalentity_tmpl   =   "Short Name "+Segment_name+" "+"Legal";
	    String lelong_tmpl  	  =   "Long Name "+Segment_name+" "+"Legal";
	    String process_tmpl 	  =   Segment_name+" "+"Process";
	    String product_tmpl       =   Segment_name+" "+"Product";
	    String committee_tmpl     =   Segment_name+" "+"Committee";
	    String geo_tmpl	  		  =	  Segment_name+" "+"Geo";
	    String policy_tmpl		  =	  Segment_name+" "+"Policy";
	    String project_tmpl		  =	  Segment_name+" "+"Project";
	    String regulation_tmpl	  =	  Segment_name+" "+"Regulation";
	    String RT_tmpl	          =	  Segment_name+" "+"RT";
	    String regulator_tmpl	  =	  Segment_name+" "+"Regulator";
	    String interface_tmpl	  =	  Segment_name+" "+"Interface";
	    String dqrule_tmpl	      =	  Segment_name+" "+"Rule";
	    String policyeffectivedate=   "12/12/2018";
	    String policyenddate 	  =   "12/12/2019";
	    String projstartdate 	  =   "09/09/2018";
	    String projenddate 	      =   "12/12/2019";
	    String dqstartdate		  =   "12/12/2019";



	    
	//#1 OrgUnit 
	    String  Org_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
	    
	//#2 People
		//String  People_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
	    String  People_AxonStatus[]= {"Active"};
		String  People_Profile[]   = { "WebUser","Admin","SuperAdmin"};
		String  People_Officelocation[]= {"India","US","UK","Japan","Europe"};
		String  People_EmploymentType[]= {"Internal","External"};
		String  People_Lifecycle[] = {"Working","Temporarily Inactive","Pending Deactivation","Left the Company"};
		
	
   //#3 System		
		String System_External[]= {"TRUE","FALSE"};
		String System_AxonViewing[]= {"Public","Non-Public"};
		String System_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String System_Lifecycle[]= {"In Production","Being Decommissioned","Decommissioned"};
		String System_SystemType[]= {"Software Application","EUC-XLS","EUC-Access","EUC-PowerPoint","EUC-Word","EUC-Other","Sharepoint","Paper Form","File System","PDF"};
		String System_SystemClassification[]= {"Data Warehouse"};
		String System_GovernanceRole[]= {"System Business Owner","System Steward"};

		
   //#4 Glossary
		String Glossary_AxonViewing[]= {"Public","Non-Public"};
		String Glossary_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Glossary_Lifecycle[]= {"Draft","Being validated","Approved","Obsolete"};
		String Glossary_FormatType[]= {"Text","Number","Decimal","Percentage","Fraction","Date","Time","Datetime"};
		String Glossary_KDE[]= {"True","False"};
		String Glossary_SecurityClassification[]= {"Public","Internal","Confidential","Restricted"};
	//	String Glossary_Type[]= {"Entity","Domain","Term"};
		String Glossary_Type[]= {"Domain","Term","Subdomain","Metric"};
		String Glossary_Confidentiality[]= {"1","2","3"};
		String Glossary_Integrity[]= {"1","2","3"};
		String Glossary_Availability[]= {"1","2","3"};
		String Glossary_GovernanceRole[]= {"Glossary Definition Owner","Glossary Steward"};
		
	//#5 Dataset
		
		String Dataset_AxonViewing[]= {"Public","Non-Public"};
		String Dataset_DataSetType[]= {"Value List","Data Set","Report"};
		String Dataset_Lifecycle[]= {"Draft","Approved","Obsolete"};
		String Dataset_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Dataset_GovernanceRole[]= {"Data Owner","Data Steward"};
		
	//#6 Attribute
		
		String Attribute_Key[]= {"TRUE","FALSE"};
		String Attribute_AttributeRequirement[]= {"Mandatory","Optional","Conditional"};
		String Attribute_Origin[]= {"Created/Set here","Sourced","Unknown","Enterprise Catalog"};
		String Attribute_Editability[]= {"Read Only","Editable","Unknown"};
		String Attribute_EditabilityRole[]= {"Admin Only","Restricted User Group(s)","Most Users"};
		String Attribute_GovernanceRole[]= {"Data Attribute Owner","Data Attribute Steward"};
		
	//#7 BusinessArea
		
		String BArea_AxonViewing[]= {"Public","Non-Public"};
		String BArea_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String BArea_Lifecycle[]= {"Operating","Obsolete"};
		String BArea_GovernanceRole[]= {"Business Area Head"};
		
		
	//#8 Capability
		
		String Capability_AxonViewing[]= {"Public","Non-Public"};
		String Capability_Classification[]= {"Organisational Capability"};
		String Capability_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Capability_Lifecycle[]= {"In Effect","Obsolete"};
		String Capability_CapabilityType[]= {"Capability","Responsibility"};
		String Capability_GovernanceRole[]= {"Capability Owner"};
		
	//#9 Client
		
		String Client_Lifecycle[]= {"In Production","Obsolete"};
		String Client_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Client_AxonViewing[]= {"Public","Non-Public"};
		String Client_GovernanceRole[]= {"Client Segmentation Owner"};
		
    //#10 Committee
		
		String Committee_AxonViewing[]= {"Public","Non-Public"};
		String Committee_Classification[]= {"Core Governance Entity"};
		String Committee_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Committee_Lifecycle[]= {"In Effect","Obsolete"};
		String Committee_CommitteeType[]= {"Committee","Working Group"};
		String Committee_GovernanceRole[]= {"Committee Chair",};
		
		
		
	//#11 DQReport
			
    //#12 DQRule
	
		String DQRule_Criticality[]= {"High","Medium","Low"};
		String DQRule_AxonViewing[]= {"Public","Non-Public"};
		String DQRule_RuleType[]={"Completeness","Accuracy","Consistency","Validity","Timeliness"};
		String DQRule_RuleTypeStr[]= {""};   //{"Standard","Local"}
		String DQRule_Frequency[]={"Daily","Weekly","Monthly","Quarterly","AdHoc","Bi-Weekly"};
		String DQRule_Lifecycle[]={"Active","Draft","Obsolete"};
		String DQRule_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String DQRule_MeasuringMethod[]={"System Function","Technical Script","Business Extract","Informatica Data Quality Automation"};
		String DQRule_AutomationLevel[]={"Manual","Partially Automated","Fully Automated","Unknown"};
		
		
		String DQRule_GovernanceRole[]={"DQ Steward"};
		
	//#13 Interface
		
		String Interface_TransferMethod[]= {"FTP","SFTP","SCP","HTTP","HTTPS","SOAP","MQSERIES","EMAIL"};
		String Interface_TransferFormat[]= {"XML","XBRL","JSON","DELIMITED","XLS"};
		String Interface_InterfaceClassification[] = {"BAU"};
		String Interface_Lifecycle[]= {"In Production","Being Decomissioned","Decomissioned"};
		String Interface_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Interface_AutomationLevel[]= {"Manual - File based","Manual - Re-keyed","Partially Automated","Fully Automated","Unknown"};
		String Interface_Frequency[]= {"Ad-Hoc","Monthly","Weekly","Daily","Realtime","Unknown"};
		String Interface_AxonViewing[]= {"Public","Non-Public"};
		String Interface_GovernanceRole[]= {"Interface Steward","Interface Owner"};
		
	//#14 Legalentity
		
		String LE_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String LE_AxonViewing[]= {"Public","Non-Public"};
		String LE_GovernanceRole[]= {"Legal Entity Owner"};
				
		
	//#15 Policy
		
		String Policy_Internal[]= {"TRUE","FALSE"};
		String Policy_AxonViewing[]= {"Public","Non-Public"};
		String Policy_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Policy_PolicyLifecycle[]= {"Draft","Enforced","Obsolete"};
		String Policy_PolicyType[]= {"Conduct Standards","Data Standards","Procedures"};
		String Policy_GovernanceRole[]= {"Policy Owner","Policy Steward"};
		
				
	//#16 Process
		String Process_StepType[]= {"Start Step","End Step","Common Step"};
		String Process_Permission[]= {"TRUE","FALSE"}; //create,update,read,delete,archieve
		String Process_AxonViewing[]= {"Public","Non-Public"};
		String Process_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Process_ProcessType[]= {"Process","Step","Control"};
		String Process_DurationType[]= {"Hours","Days"};
		String Process_Lifecycle[]={"In Production","Draft","Obsolete"};
		String Process_Classification[]={"Execution Process",};
		String Process_Automation[]={"Fully Automated","Partially Automated","Manual"};
		String Process_GovernanceRole[]={"Process Owner","Process Steward"};
		
		
	//#17 Project
		
		String Project_AxonViewing[]= {"Public","Non-Public"};
		String Project_RAG[]= {"Red","Amber","Green"};
		String Project_Classification[]= {"Mandatory","Discretionary"};
		String Project_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Project_ProjectLifecycle[]= {"Execution","Initiation","Closed"};
		String Project_ProjectType[]= {"Programme","Project"};
		String Project_GovernanceRole[]= {"Project Manager","Project Steward"};
		
		
	//#18 Product
		
		String Product_Lifecycle[]= {"In Production","Obsolete"};
		String Product_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
		String Product_AxonViewing[]= {"Public","Non-Public"};
		String Product_GovernanceRole[]= {"Product Owner","Product Steward"};
		
		
		
    //#19 Geography
		
	//#20 Regulation
		
	String  Regulation_RegulationMaturity[]= {"In Effect","Initial Draft","Obsolete"};
	String  Regulation_RegulationProbability[]= {"Confirmed"};
	String  Regulation_AxonStatus[]= {"Active","Obsolete","Deleted"};
	String  Regulation_LegalAdviceType[]= {"Comment","Guideline","Legal Requirement"};
	String  Regulation_RegulationStage[]= {"Completed","Interpretation","Impact Assessment"};
	String  Regulation_ComplianceLevel[]= {"Fully Compliant","Unknown","Compliant with exceptions","Materially Not Compliant"};
	String  Regulation_GovernanceRole[]= {"Regulation Owner","Regulation SME"};
	
		
	//#21 Regulator
		
	
	//#22 RegTheme
		
		String RegTheme_AxonStatus[]= {"Active","Inactive","Pending Review","Obsolete","Deleted"};
	
	
		
		//FOR RELATIONSHIPS
		
	//attribute-x-attribute
		String  AttributexAttribute_SourcingType[]= {"Enforced Lookup","Unenforced Lookup","Sourced From"};
		String AttributexAttribute_ScopeOfData[] = {"All","Subset"};

	//process-x-glossary
		String  ProcessxGlossary_RelationshipType[]= {"Is used for Process","Is KDE for Process"};
		
	//process-x-legalentity
		String  ProcessxLegalentity_RelationshipType[]= {"Legal Entity is Data Controller","Legal Entity is Data Processor"};

	//project-x-project
		String  ProjectxProject_RelationshipType[]= {"Is related to","Is predecessor to","Is dependent on"};
		
	//project-x-system
		String  ProjectxSystem_RelationshipType[]= {"Project is affecting System","Project is sourcing from System"};

	//system-x-legal-entity
		String  SystemxLegalentity_RelationshipType[]= {"Is Supported By","Is Used By","Is Supported By"};

	//system-x-glossary
		String  SystemxGlossary_RelationshipType[]= {"Strategic Master Source for","Expected glossary item coverage"};
		
	//system-x-product
		String  SystemxProduct_ProductLegalEntityType[]= {"Risk Owning Entity","Booking Entity"};

		
	//people-x-people
		String  PeoplexPeople_RelationshipType[]= {"Direct report","Dotted line"};

		
		

}

