package gov.psm.primary.service.utility;

import java.util.Random;

import org.apache.commons.io.FilenameUtils;

public class ProposalFileUtility {

	private String proposalFileNamingTemplate;
    
    public ProposalFileUtility(String proposalFileNamingTemplate) {
    	this.proposalFileNamingTemplate = proposalFileNamingTemplate;
    }
    
    private String formatPSMFileKey(String propPrepId, String revnId, String section) {
    	Random random = new Random();
		return String.format(proposalFileNamingTemplate, propPrepId, revnId, random.nextInt(Integer.MAX_VALUE-1), propPrepId, revnId,
				section);
    }
    
    /**
     * Formats file key for proposal section documents
     * @param propPrepId
     * @param revnId
     * @param section
     * @param fileExt
     * @return
     */
    public String constructPSMFileKeyForSectionDocument(String propPrepId, String revnId, String section, String origFileNameWithExt) {
        return formatPSMFileKey(propPrepId, revnId, section) + getFileExtension(origFileNameWithExt);
    }

    /**
     * Formats file key for proposal personnel documents
     * @param propPrepId
     * @param revnId
     * @param section
     * @param fileExt
     * @return
     */
    public String constructPSMFileKeyForPersonnelDocument(String propPrepId, String revnId, String section, String persId,
            String origFileNameWithExt) {
        String filePathName = formatPSMFileKey(propPrepId, revnId, section);

        if (persId != null) {
            filePathName += "-" + persId;
        }

        return filePathName + getFileExtension(origFileNameWithExt);
    }
    
    /**
     * Formats file key for proposal personnel documents
     * @param propPrepId
     * @param revnId
     * @param section
     * @param fileExt
     * @return
     */
    public String constructPSMPersonnelFileKeyWithExt(String propPrepId, String revnId, String section, String persId,
            String fileExt) {
        String filePathName = formatPSMFileKey(propPrepId, revnId, section);

        if (persId != null) {
            filePathName += "-" + persId;
        }

        return filePathName + fileExt;
    }
    
    private String getFileExtension(String filenameWithExt) {
    	return "." + FilenameUtils.getExtension(filenameWithExt);
    }
  
}
