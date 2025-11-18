package com.riwi.microusers.domain.ports.in;

import com.riwi.microusers.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
}
