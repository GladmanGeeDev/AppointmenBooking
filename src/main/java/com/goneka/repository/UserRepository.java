package com.goneka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.goneka.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
