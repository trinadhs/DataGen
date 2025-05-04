package com.infa.relations;

import com.infa.axon.ExportAttributes;
import com.infa.axon.ExportBusinessArea;
import com.infa.axon.ExportCapability;
import com.infa.axon.ExportClient;
import com.infa.axon.ExportCommittee;
import com.infa.axon.ExportDataQualityReport;
import com.infa.axon.ExportDataQualityRule;
import com.infa.axon.ExportDataset;
import com.infa.axon.ExportGeography;
import com.infa.axon.ExportGlossary;
import com.infa.axon.ExportInterface;
import com.infa.axon.ExportLegalEntity;
import com.infa.axon.ExportOrgUnit;
import com.infa.axon.ExportPeople;
import com.infa.axon.ExportPolicy;
import com.infa.axon.ExportProcess;
import com.infa.axon.ExportProduct;
import com.infa.axon.ExportProject;
import com.infa.axon.ExportRegulation;
import com.infa.axon.ExportRegulator;
import com.infa.axon.ExportRegulatoryTheme;
import com.infa.axon.ExportSystem;
import com.infa.data.DropdownData;


public class ExportAllRelations implements DropdownData{

	 public static void main(String[] args) 
	    { 
		 
		 AttributeRelations.main(args);
		 BusinessRelations.main(args);
		 CapabilityRelations.main(args);
		 CommitteeRelations.main(args);
		 DatasetRelations.main(args);
		 GlossaryRelations.main(args);
		 InterfaceRelations.main(args);
		 LegalEntityRelations.main(args);
		 PeopleRelations.main(args);
		 PolicyRelations.main(args);
		 ProcessRelations.main(args);
		 ProductRelations.main(args);
		 ProjectRelations.main(args);
		 RegulationRelations.main(args);
		 RegulatorRelations.main(args);
		 SystemRelations.main(args);
		 
	    
		 }
	  
	
}
