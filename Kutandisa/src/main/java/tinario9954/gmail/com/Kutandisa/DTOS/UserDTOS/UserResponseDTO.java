package tinario9954.gmail.com.Kutandisa.DTOS.UserDTOS;

public record UserResponseDTO(
        Long id,
        String nomeCompleto,
        String email,
        String telefone,
        String fotoPerfil,
        Boolean activo,
        String role
) {}