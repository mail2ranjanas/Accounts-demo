package com.account.response;

import java.util.List;

import com.account.model.Account;
import com.account.model.Transactions;

import lombok.Getter;
import lombok.Setter;

public class TransactionResponse extends PageResponse{
	
	@Getter @Setter private List<Transactions> TranasactiosList;
	
}
