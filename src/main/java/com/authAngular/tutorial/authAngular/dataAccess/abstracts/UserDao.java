package com.authAngular.tutorial.authAngular.dataAccess.abstracts;


import com.authAngular.tutorial.authAngular.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Long>  {
    Optional<User> findByLogin(String login);
}
