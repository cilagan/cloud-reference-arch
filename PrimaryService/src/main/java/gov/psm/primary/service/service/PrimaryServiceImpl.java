package gov.psm.primary.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gov.psm.primary.service.exception.CommonUtilException;
import gov.psm.primary.service.model.AccountHolder;

@Component
public class PrimaryServiceImpl implements PrimaryService {

	public List<AccountHolder> getAccountHolders() throws CommonUtilException {
		List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
		AccountHolder accountHolder = new AccountHolder();
		accountHolder.setId("id1");
		accountHolder.setName("Name1");
		accountHolder.setAddress("address1");
		accountHolders.add(accountHolder);
		accountHolder = new AccountHolder();
		accountHolder.setId("id2");
		accountHolder.setName("Carlo Ilagan");
		accountHolder.setAddress("address2");
		accountHolders.add(accountHolder);
		return accountHolders;
	}

}
