package com.electro.app.repository;


import com.electro.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Méthode pour trouver un utilisateur par son nom d'utilisateur

    User findByUsername(String username);

}