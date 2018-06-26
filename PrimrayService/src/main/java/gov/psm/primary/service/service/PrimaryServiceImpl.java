package gov.psm.primary.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import gov.psm.primary.service.exception.CommonUtilException;
import gov.psm.primary.service.model.AccountHolder;

@Component
public class PrimaryServiceImpl implements PrimaryService {

	@Value("${secondaryService.serverUrl}")
	private String serverURL;
	@Value("${secondaryService.username}")
	private String username;
	@Value("${secondaryService.password}")
	private String password;
	@Value("${secondaryService.authenticationRequired}")
	private boolean authenticationRequired;
	@Value("${secondaryService.timeout}")
	private int requestTimeout;

	public List<AccountHolder> getAccountHolders() throws Exception {

		SecondaryServiceClient secondaryServiceClient = new SecondaryServiceClient();
		secondaryServiceClient.setAuthenticationRequired(authenticationRequired);
		secondaryServiceClient.setServerURL(serverURL);
		secondaryServiceClient.setRequestTimeout(requestTimeout);
		secondaryServiceClient.setUsername(username);
		secondaryServiceClient.setPassword(password);
		List<AccountHolder> accountHolders = secondaryServiceClient.getAccountHolders();
		return accountHolders;
	}

}