package com.jonatan.foodEvents.services.auth;

import com.jonatan.foodEvents.requests.AuthenticationRequest;
import com.jonatan.foodEvents.responses.AuthenticationResponse;
import com.jonatan.foodEvents.config.JwtService;
import com.jonatan.foodEvents.entities.User;
import com.jonatan.foodEvents.requests.RegisterRequest;
import com.jonatan.foodEvents.responses.RegisterResponse;
import com.jonatan.foodEvents.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .telefono(request.getTelefono())
                .acepta(request.getAcepta())
                .rol(request.getRol())
                .build();
        repository.save(user);
        return RegisterResponse.builder()
                .usuario(user)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
