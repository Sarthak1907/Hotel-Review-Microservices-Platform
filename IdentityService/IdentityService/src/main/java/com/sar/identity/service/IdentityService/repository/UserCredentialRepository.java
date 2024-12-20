package com.sar.identity.service.IdentityService.repository;

import com.sar.identity.service.IdentityService.entities.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredentials, Integer> {
    Optional<UserCredentials> findByName(String username);
}
