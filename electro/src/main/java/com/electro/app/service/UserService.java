package com.electro.app.service;

import com.electro.app.model.User;
import com.electro.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Enregistrer un nouvel utilisateur
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Chiffrer le mot de passe
        return userRepository.save(user);
    }

    // Connexion d'un utilisateur
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);  // Récupérer l'utilisateur par son nom
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {  // Vérifier le mot de passe
            return user;
        }
        return null;  // Si l'utilisateur n'existe pas ou que le mot de passe est incorrect
    }

    // Vérifier si un utilisateur existe déjà
    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;  // Vérifier si l'utilisateur existe dans la base de données
    }
}