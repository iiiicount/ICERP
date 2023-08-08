package com.count.icount.auth.repository;

import com.count.icount.auth.model.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface AuthRepository extends JpaRepository<Auth, Long> {
    public Optional<Auth> findByComCodeAndUserName(String comCode, String userName);
    public Optional<Auth> findByUserName(String username);
}
