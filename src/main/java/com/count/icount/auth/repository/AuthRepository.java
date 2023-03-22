package com.count.icount.auth.repository;

import com.count.icount.auth.model.Entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    public Optional<Auth> findByComCodeAndAndUserName(String comCode, String userName);
    public Optional<Auth> findByUserName(String username);
}
