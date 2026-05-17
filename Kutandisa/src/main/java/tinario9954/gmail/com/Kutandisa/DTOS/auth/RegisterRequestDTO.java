package tinario9954.gmail.com.Kutandisa.DTOS.auth;

import tinario9954.gmail.com.Kutandisa.Enum.RoleNome;

public record RegisterRequestDTO(
        String nomeCompleto,
        String email,
        String telefone,
        String password,
        RoleNome role
) {}
 