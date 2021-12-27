package com.example.todo.repository;

import com.example.todo.models.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<AccountEntity, Long> {

    Optional<AccountEntity> findUserByUsername(String username);
}
