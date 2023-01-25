package com.jonatan.foodEvents.services.usuario;

import com.jonatan.foodEvents.entities.User;
import com.jonatan.foodEvents.requests.CrearUserRequest;
import com.jonatan.foodEvents.requests.EditarUserRequest;
import com.jonatan.foodEvents.responses.RegisterResponse;


import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<User> getAllUsers();
    Optional<User> findByUsername(String username);
    User findById(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByPhone(String phone);
    Boolean existsByEmail(String email);
    void deleteUser(Long id_user);

    RegisterResponse crearUser(CrearUserRequest registerRequest);
    User editarUser(Long id_user, EditarUserRequest editarUserRequest);











}
