package tinario9954.gmail.com.Kutandisa.DTOS.UserDTOS;

public record UserRequestDTO(
        String nomeCompleto,
        String email,
        String telefone,
        String password,
        Long roleId
) {}