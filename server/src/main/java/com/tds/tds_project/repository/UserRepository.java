package com.tds.tds_project.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    List<User> findAll();
}


