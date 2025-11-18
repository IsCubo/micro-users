package com.riwi.microusers.domain.ports.in;


import com.riwi.microusers.domain.model.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Long id, User updatedUser);
}
