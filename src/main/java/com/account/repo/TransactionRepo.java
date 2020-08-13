package com.account.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Account;
import com.account.model.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions, Integer> {
    public List<Transactions> findAll();
    
    public List<Transactions> findByAccountAccountid(String accountid);

}


