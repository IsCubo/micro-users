package com.riwi.microusers.domain.ports.in;

import com.riwi.microusers.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
