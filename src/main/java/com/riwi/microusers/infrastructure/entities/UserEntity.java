package com.riwi.microusers.infrastructure.entities;

import com.riwi.microusers.domain.model.Role;
import com.riwi.microusers.domain.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime cratedAt;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String email, Role role, LocalDateTime cratedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.cratedAt = cratedAt;
    }

    public static UserEntity fromDomainModel(User user){
        return  new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getCreatedAt());
    }

    public User toDomainModel(){return  new User(id, name, email, role, cratedAt);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }
}
