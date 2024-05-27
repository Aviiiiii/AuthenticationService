package com.avi.authenticationservice.dao;

import com.avi.authenticationservice.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
    //List<User> getAllUsers();
}
