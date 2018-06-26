package org.openmrs.module.mergepatientdata.api;

import java.io.File;
import java.util.List;

import org.openmrs.module.mergepatientdata.api.model.audit.AuditMessage;
import org.openmrs.module.mergepatientdata.resource.MergeAbleResource;
import org.openmrs.module.mergepatientdata.sync.MergeAbleBatchRepo;

public interface MergePatientDataExportService {
	
	/*
	 * This method uploads the {@Link MergeAbleResource} data
	 */
	public File exportMergeAblePatientData(List<Class> resourceClassesToExport);
	
}
