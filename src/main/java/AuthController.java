package com.example.demo.controller;

import com.example.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // En este ejemplo, usamos un usuario fijo. En producción, conecta con una base de datos.
        if ("admin".equals(username) && "password".equals(passwordEncoder.encode("password"))) {
            return jwtService.generateToken(username);
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
