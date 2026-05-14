package tinario9954.gmail.com.Kutandisa.DTOS.empresa;

public record EmpresaRequestDTO(
        String nomeEmpresa,
        String nif,
        String descricao,
        String telefone,
        String email,
        String website,
        Long userId
) {}
