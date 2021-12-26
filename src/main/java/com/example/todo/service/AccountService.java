package com.example.todo.service;

import com.example.todo.dto.AccountDto;
import com.example.todo.models.AccountEntity;

import java.util.List;

public interface AccountService {

    void createAccount(AccountDto userDto);

    void deleteAccount(String username);

    AccountEntity getAccountByUsername(String username);

    List<AccountEntity> getAllAccounts();
}
