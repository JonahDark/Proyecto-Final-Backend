package com.jonatan.foodEvents.requests;

import com.jonatan.foodEvents.entities.Rol;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String username;
  private String email;
  private String password;
  private String telefono;
  private Boolean acepta;
  
  @Enumerated(EnumType.STRING)
  private Rol rol;
}
