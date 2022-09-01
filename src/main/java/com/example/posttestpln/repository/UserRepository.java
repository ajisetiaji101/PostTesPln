package com.example.posttestpln.repository;

import com.example.posttestpln.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
