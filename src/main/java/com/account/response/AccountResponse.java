package com.account.response;

import java.util.List;

import com.account.model.Account;

import lombok.Getter;
import lombok.Setter;

public class AccountResponse extends PageResponse{
	
	@Getter @Setter private List<Account> accountList;
	
}
