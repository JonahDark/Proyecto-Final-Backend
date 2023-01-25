package com.jonatan.foodEvents.controller;


import com.jonatan.foodEvents.entities.User;
import com.jonatan.foodEvents.requests.CrearUserRequest;
import com.jonatan.foodEvents.requests.EditarUserRequest;
import com.jonatan.foodEvents.responses.RegisterResponse;
import com.jonatan.foodEvents.services.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
/*@RequiredArgsConstructor Genera un constructor con los argumentos requeridos.
 Los argumentos obligatorios son campos finales no inicializados y
  campos con restricciones como @NonNull.
  El modificador de acceso predeterminado es público*/
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/getUserByUsername/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return usuarioService.findByUsername(username);
    }

    @GetMapping("/getUserById/{id}")
    public User findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/getAllUsuarios")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(usuarioService.getAllUsers());
    }

    @DeleteMapping("/deleteUser/{id_usuario}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id_usuario) {
        usuarioService.deleteUser(id_usuario);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/editUser/{id_usuario}")
    public ResponseEntity<User> updateUser(@PathVariable Long id_usuario, @RequestBody EditarUserRequest editarUserRequest) {
        return ResponseEntity.ok(usuarioService.editarUser(id_usuario, editarUserRequest));
    }

    @PostMapping("/createUser")
    public ResponseEntity<RegisterResponse> createUser(@RequestBody CrearUserRequest registerRequest) {
        if (usuarioService.existsByUsername(registerRequest.getUsername()) || usuarioService.existsByPhone(registerRequest.getTelefono())|| usuarioService.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body(RegisterResponse.builder().usuario(null).build());
        }
        return ResponseEntity.ok(usuarioService.crearUser(registerRequest));
    }


}
