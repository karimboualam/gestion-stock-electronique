package com.electro.app.controller;

import com.electro.app.model.User;
import com.electro.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Inscription d'un nouvel utilisateur
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Vérifier si l'utilisateur existe déjà (optionnel)
        if (userService.userExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);  // Retourner l'utilisateur enregistré
    }
     //RequestBody // DANS POSTMAN IL FAUT ENVOYER DANS BODY
            //RequestParam  // DANS POSTMAN IL FAUT ENVOYER DANS LES PARAMETRES
    // Connexion d'un utilisateur
     @PostMapping("/login")
     public ResponseEntity<?> login(@RequestBody User user) {
         User foundUser = userService.loginUser(user.getUsername(), user.getPassword());
         if (foundUser == null) {
             return ResponseEntity.status(401).body("Invalid username or password.");
         }
         return ResponseEntity.ok(foundUser);  // Retourner l'utilisateur connecté
     }

}