package tinario9954.gmail.com.Kutandisa.DTOS.auth;

public record AuthResponseDTO(
        Long userId,
        String nomeCompleto,
        String email,
        String role,
        String token
) {}