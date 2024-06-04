package com.riwi_learn.Riwi.learn.api.dto.request;

import com.riwi_learn.Riwi.learn.util.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateRequest{
    @Size(min = 0, max = 50, message = "El nombre supera la cantidad de caracteres")
    @NotNull(message = "El nombre del usuario es requerido")
    private String username;

    @NotNull(message = "La contraseña es requerido")
    private String password;

    @NotNull(message = "El correo del usuario es requerido")
    @Email(message = "El email no es válido")
    private String email;

    private String full_name;
    private UserRole role;
}
