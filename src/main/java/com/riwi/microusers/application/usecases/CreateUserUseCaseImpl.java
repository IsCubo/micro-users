package com.riwi.microusers.application.usecases;


import com.riwi.microusers.domain.model.User;
import com.riwi.microusers.domain.ports.in.CreateUserUseCase;
import com.riwi.microusers.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
