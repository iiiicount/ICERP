package com.count.icount.company.repository;

import com.count.icount.company.Model.Entity.PK.UserPK;
import com.count.icount.company.Model.Entity.User;
import com.count.icount.trade.product.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserPK> {
    Optional<User> findByComCodeAndUid(String comCode, String uid);
    Optional<User> findByComCodeAndNickname(String comCode, String nickName);
}