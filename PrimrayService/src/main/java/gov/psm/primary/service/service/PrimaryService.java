package gov.psm.primary.service.service;

import java.util.List;

import gov.psm.primary.service.model.AccountHolder;

public interface PrimaryService {

	public List<AccountHolder> getAccountHolders() throws Exception;

}
