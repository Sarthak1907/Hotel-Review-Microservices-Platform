package com.sar.user.service.UserService.repository;

import com.sar.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
