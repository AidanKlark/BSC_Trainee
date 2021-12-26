package com.example.todo.controllers;

import com.example.todo.dto.AccountDto;
import com.example.todo.models.AccountEntity;
import com.example.todo.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @DeleteMapping("/{username}")
    public void deleteAccount(@PathVariable String username) {
        log.info("Удаление пользователя: {}", username);

        accountService.deleteAccount(username);
    }

    @PostMapping
    public void addAccount(@RequestBody AccountDto userDto) {
        log.info("Создание пользователя: {}", userDto.getUsername());

        accountService.createAccount(userDto);
    }

    @GetMapping
    public List<AccountEntity> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
