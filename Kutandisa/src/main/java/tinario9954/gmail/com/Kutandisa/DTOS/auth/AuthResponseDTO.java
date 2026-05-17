package tinario9954.gmail.com.Kutandisa.DTOS.auth;

public record AuthResponseDTO(
        String token,
        String tipo,
        Long id,
        String nomeCompleto,
        String email,
        String role
) {
    public AuthResponseDTO(String token, Long id, String nomeCompleto, String email, String role) {
        this(token, "Bearer", id, nomeCompleto, email, role);
    }
}
 