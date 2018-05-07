package gov.psm.primary.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.psm.primary.service.exception.CommonUtilException;
import gov.psm.primary.service.model.AccountHolder;
import gov.psm.primary.service.service.PrimaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
//@ApiResponses(value = { @ApiResponse(code = 404, message = "Resource not found"),
//		@ApiResponse(code = 500, message = "Internal server error") })
public class PrimaryServiceController {

	@Autowired
	PrimaryService primaryService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ApiOperation(value = "Get All Account Holders ", notes = "This API returns the list of account holders", response = AccountHolder.class, responseContainer = "List")
	@RequestMapping(path = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountHolder> getAccountHolders() throws CommonUtilException {
		LOGGER.info("ProposalManagementLookupController.getAccountHolders()");
		return primaryService.getAccountHolders();
	}
}
