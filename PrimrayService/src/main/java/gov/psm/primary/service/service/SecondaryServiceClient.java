package gov.psm.primary.service.service;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import gov.psm.primary.service.model.AccountHolder;
import gov.psm.primary.service.model.Accounts;

public class SecondaryServiceClient {

	private String serverURL;
	private String username;
	private String password;
	private boolean authenticationRequired;
	private int requestTimeout;
	private String accountsURL = "/api/v1/accounts";

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public boolean isAuthenticationRequired() {
		return authenticationRequired;
	}

	public void setAuthenticationRequired(boolean authenticationRequired) {
		this.authenticationRequired = authenticationRequired;
	}

	public int getRequestTimeout() {
		return requestTimeout;
	}

	public void setRequestTimeout(int requestTimeout) {
		this.requestTimeout = requestTimeout;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountHolder> getAccountHolders() throws Exception {
		RestTemplate secondaryServiceClient = new RestTemplate();

		StringBuilder endpointUrl = new StringBuilder(serverURL);
		endpointUrl.append(accountsURL);

		ResponseEntity<Accounts> response = null;
		HttpEntity<String> httpEntity = getHttpEntity(authenticationRequired);

		response = secondaryServiceClient.exchange(endpointUrl.toString(), HttpMethod.GET, httpEntity, Accounts.class);
		return response.getBody().getAccounts();
	}

	public static HttpEntity<String> createHttpEntityWithAuthentication(String userName, String password) {
		String auth = userName + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", authHeader);
		return new HttpEntity<String>(headers);
	}

	public static HttpEntity<MultiValueMap<String, Object>> createHttpEntityWithAuthentication(String userName,
			String password, MultiValueMap<String, Object> requestParts) {
		String auth = userName + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", authHeader);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
				requestParts, headers);

		return requestEntity;
	}

	public static HttpHeaders createHeaderswithAuthentication(String userName, String password) {
		String auth = userName + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authHeader = "Basic " + new String(encodedAuth);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", authHeader);
		return headers;
	}

	private HttpEntity<String> getHttpEntity(boolean authRequired) {
		return authRequired ? createHttpEntityWithAuthentication(username, password) : null;
	}
}
