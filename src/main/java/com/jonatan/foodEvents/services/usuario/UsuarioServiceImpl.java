package com.jonatan.foodEvents.services.usuario;

import com.jonatan.foodEvents.entities.User;
import com.jonatan.foodEvents.requests.CrearUserRequest;
import com.jonatan.foodEvents.requests.EditarUserRequest;
import com.jonatan.foodEvents.responses.RegisterResponse;
import com.jonatan.foodEvents.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UserRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse crearUser(CrearUserRequest crearUserRequest) {
        var user = User.builder()
                .username(crearUserRequest.getUsername())
                .email(crearUserRequest.getEmail())
                .password(passwordEncoder.encode(crearUserRequest.getPassword()))
                .telefono(crearUserRequest.getTelefono())
                .acepta(crearUserRequest.getAcepta())
                .rol(crearUserRequest.getRol())
                .build();
        usuarioRepository.save(user);
        return RegisterResponse.builder()
                .usuario(user)
                .build();
    }

    @Override
    public User editarUser(Long id_user, EditarUserRequest editarUserRequest) {
        Optional<User> optionalUser = usuarioRepository.findById(id_user);
        if(optionalUser.isPresent()){

            User user = optionalUser.get();
            user.setUsername(editarUserRequest.getUsername());
            user.setRol(editarUserRequest.getRol());
            user.setEmail(editarUserRequest.getEmail());
            if(!editarUserRequest.getPassword().isEmpty()){
                user.setPassword(passwordEncoder.encode(editarUserRequest.getPassword()));
            }
            user.setTelefono(editarUserRequest.getTelefono());
            return usuarioRepository.save(user);
        }else{
            throw new EntityNotFoundException("No existe ningun usuario con éste ID");
        }
    }

    @Override
    public void deleteUser(Long id_user) {
        Optional<User> optionalUser = usuarioRepository.findById(id_user);
        if (optionalUser.isPresent()) {
            usuarioRepository.deleteById(id_user);
        } else {
            throw new EntityNotFoundException("No existe ningun usuario con este ID");
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        List<User> usuarios = usuarioRepository.findAll();
        Optional<User> optionalUser = Optional.empty();
        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                optionalUser = Optional.of(usuario);
            }
        }
        return optionalUser;
    }

    @Override
    public List<User> getAllUsers() {
        return this.usuarioRepository.findAll();
    }




    @Override
    public User findById(Long id) {
        Optional<User> optionalUsuario = this.usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }
        throw new EntityNotFoundException("No existe ningún usuario con ese ID");
    }

    @Override
    public Boolean existsByUsername(String username) {
        List<User> usuarios = this.usuarioRepository.findAll();

        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean existsByPhone(String phone) {
        List<User> usuarios = this.usuarioRepository.findAll();
        for (User usuario : usuarios) {
            if (usuario.getTelefono().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean existsByEmail(String email) {
        List<User> usuarios = this.usuarioRepository.findAll();
        for (User usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }


}
