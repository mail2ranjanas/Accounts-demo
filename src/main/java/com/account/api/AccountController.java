package com.account.api;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.exception.AccountNotFoundException;
import com.account.exception.TransactionNotFoundException;
import com.account.model.Account;
import com.account.model.Transactions;
import com.account.repo.AccountRepo;
import com.account.repo.TransactionRepo;
import com.account.response.AccountResponse;
import com.account.response.TransactionResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * REST Controller for Accounts Resource
 * @author ranjana
 *
 */
@Transactional
@RestController
@Api(tags = {"Accounts"})
public class AccountController {

	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	TransactionRepo transactionRepo;
	
	/**
	 * Returns list of available accounts
	 * @param userName - userId of the user
	 * @return
	 */
	@ApiOperation(value = "Returns List of Accounts", response = AccountResponse.class)
	@RequestMapping(value = "/accounts/{userName}", method = RequestMethod.GET)
	public AccountResponse getAccounts(@PathVariable String userName)  {
		
		//TODO - Instead of calling repo directly, it can be redirected via service class.
		List<Account> accountList = accountRepo.findByUserUserName(userName);
		
		if(accountList == null || accountList.size()==0) {
			throw new AccountNotFoundException("The Account Id is not available");
		}
		
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccountList(accountList);
		
		return accountResponse;
	}
	
	/**
	 * Returns transaction history for a account
	 * @param accountId
	 * @return
	 */
	@ApiOperation(value = "Returns history of selected account", response = TransactionResponse.class)
	@RequestMapping(value = "/accountHistory/{accountId}", method = RequestMethod.GET)
	public TransactionResponse getAccountHistory(@PathVariable String accountId) {

		TransactionResponse transactionResponse = new TransactionResponse();
		
		List<Transactions> transactionList = transactionRepo.findByAccountAccountid(accountId);
		
		if(transactionList == null || transactionList.size()==0) {
			throw new TransactionNotFoundException("Transactions are not available for account id "+accountId);
		}
		transactionResponse.setTranasactiosList(transactionList);
		
		return transactionResponse;
	}
}
