package com.account;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.account.api.AccountController;
import com.account.model.Account;
import com.account.model.Transactions;
import com.account.model.User;
import com.account.repo.AccountRepo;
import com.account.repo.TransactionRepo;
import com.account.response.AccountResponse;
import com.account.response.TransactionResponse;

@ExtendWith(MockitoExtension.class)
public class AccountsControllerUnitTests 
{ 
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountRepo accountRepo;
	
	@Mock
	TransactionRepo transactionRepo;
	
	@Test
	public void testGetAccounts() 
	{

		Account testAccount = new Account();
		testAccount.setAccontName("Savings Account");
		testAccount.setAccountid("000210021");
		testAccount.setBalanceDate(LocalDate.now());
		
		User testUser = new User();
		testUser.setUserId(1);
		testUser.setUserName("test-user");
		testAccount.setUser(testUser);
		
		
		List<Account> testAccountList = new ArrayList<Account>();
		testAccountList.addAll(Arrays.asList(testAccount));
		
		when(accountRepo.findByUserUserName(any(String.class))).thenReturn(testAccountList);
		
		AccountResponse accountResponse = accountController.getAccounts("user");
		
		assertNotNull(accountResponse);
		assertTrue(accountResponse.getAccountList().size() > 0);

	}
	
	@Test
	public void testGetTransactions() 
	{
		Account testAccount = new Account();
		testAccount.setAccontName("Savings Account");
		testAccount.setAccountid("000210021");
		testAccount.setBalanceDate(LocalDate.now());
		
		Transactions testTransaction = new Transactions();
		testTransaction.setAccount(testAccount);
		testAccount.setBalanceDate(LocalDate.now());
		testAccount.setCurrency("AUD");
		
		
		List<Transactions> testTransactionList = new ArrayList<Transactions>();
		testTransactionList.addAll(Arrays.asList(testTransaction));
		
		when(transactionRepo.findByAccountAccountid(any(String.class))).thenReturn(testTransactionList);
		
		TransactionResponse transactionResponse = accountController.getAccountHistory("000210021");
		
		assertNotNull(transactionResponse);
		assertTrue(transactionResponse.getTranasactiosList().size() > 0);

	}
}
