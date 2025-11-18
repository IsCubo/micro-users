package com.riwi.microusers.application.usecases;

import com.riwi.microusers.domain.model.User;
import com.riwi.microusers.domain.ports.in.UpdateUserUseCase;
import com.riwi.microusers.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(Long id, User updatedUser) {
        return userRepositoryPort.update(updatedUser);
    }
}
