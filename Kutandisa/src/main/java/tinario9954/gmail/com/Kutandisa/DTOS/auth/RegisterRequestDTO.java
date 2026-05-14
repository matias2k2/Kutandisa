package tinario9954.gmail.com.Kutandisa.DTOS.auth;

public record RegisterRequestDTO(
        String nomeCompleto,
        String email,
        String telefone,
        String password,
        String role
) {}