package com.riwi.microusers.infrastructure.config;

import com.riwi.microusers.application.services.UserService;
import com.riwi.microusers.application.usecases.CreateUserUseCaseImpl;
import com.riwi.microusers.application.usecases.DeleteUserUseCaseImpl;
import com.riwi.microusers.application.usecases.RetrieveUserUseCaseImpl;
import com.riwi.microusers.application.usecases.UpdateUserUseCaseImpl;
import com.riwi.microusers.domain.ports.out.UserRepositoryPort;
import com.riwi.microusers.infrastructure.repositories.UserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new RetrieveUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(UserRepositoryAdapter userRepositoryAdapter) {
        return userRepositoryAdapter;
    }
}
