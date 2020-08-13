package com.account.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    public List<Account> findAll();
    
    public List<Account> findByUserUserName(String userName);

}


