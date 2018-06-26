package gov.psm.secondary.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gov.psm.secondary.service.model.AccountHolder;
import gov.psm.secondary.service.model.Accounts;

@Component
public class SecondaryServiceImpl implements SecondaryService {

	public Accounts getAccountHolders() throws Exception {
		Accounts accounts = new Accounts();
		List<AccountHolder> accountHolders = new ArrayList<AccountHolder>();
		AccountHolder accountHolder = new AccountHolder();
		accountHolder.setId("id1");
		accountHolder.setName("Name1");
		accountHolder.setAddress("address1");
		accountHolders.add(accountHolder);
		accountHolder = new AccountHolder();
		accountHolder.setId("id2");
		accountHolder.setName("Name2");
		accountHolder.setAddress("address2");
		accountHolders.add(accountHolder);
		accounts.setAccounts(accountHolders);
		return accounts;
	}

}