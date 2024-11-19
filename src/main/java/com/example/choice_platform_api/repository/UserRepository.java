package com.example.choice_platform_api.repository;

import com.example.choice_platform_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,Long>,JpaRepository<User, Long> {
    boolean existsByLogin(String login);
    boolean existsByEmail(String email);
}
