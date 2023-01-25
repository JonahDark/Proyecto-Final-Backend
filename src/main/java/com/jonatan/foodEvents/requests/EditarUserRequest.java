package com.jonatan.foodEvents.requests;

import com.jonatan.foodEvents.entities.Rol;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EditarUserRequest {
    private String username;
    private String email;
    private String password;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}
