package com.example.todo.service;

import com.example.todo.dto.AccountDto;
import com.example.todo.models.AccountEntity;
import com.example.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createAccount(AccountDto userDto) {

        if (userRepository.findUserByUsername(userDto.getUsername()).isPresent()) {
            throw new NoSuchElementException("Пользователь с именем: " + userDto.getUsername() + " уже существует");
        }

        userRepository.save(AccountEntity.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(userDto.getRole())
                .build());
    }

    @Override
    public void deleteAccount(String username) {

        AccountEntity accountEntity = getAccountByUsername(username);
        userRepository.delete(accountEntity);
    }

    @Override
    public AccountEntity getAccountByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("Пользователь с именем: " + username + " не существует"));
    }

    @Override
    public List<AccountEntity> getAllAccounts() {

        return new ArrayList<>((Collection<? extends AccountEntity>) userRepository.findAll());
    }
}
