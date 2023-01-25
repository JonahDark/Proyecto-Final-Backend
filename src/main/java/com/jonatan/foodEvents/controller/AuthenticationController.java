package com.jonatan.foodEvents.controller;

import com.jonatan.foodEvents.requests.AuthenticationRequest;
import com.jonatan.foodEvents.responses.AuthenticationResponse;
import com.jonatan.foodEvents.requests.RegisterRequest;
import com.jonatan.foodEvents.responses.RegisterResponse;
import com.jonatan.foodEvents.services.auth.AuthenticationService;
import com.jonatan.foodEvents.services.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        if (usuarioService.existsByUsername(request.getUsername()) || usuarioService.existsByPhone(request.getTelefono())|| usuarioService.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(RegisterResponse.builder().usuario(null).build());
        }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }


}
