package com.riwi.microusers.domain.ports.out;

import com.riwi.microusers.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    Optional<User> update(User user);
    boolean deleteById(Long id);
}
