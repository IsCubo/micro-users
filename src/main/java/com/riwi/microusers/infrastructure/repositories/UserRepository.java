package com.riwi.microusers.infrastructure.repositories;

import com.riwi.microusers.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
