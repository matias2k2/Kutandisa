package tinario9954.gmail.com.Kutandisa.DTOS.empresa;

import tinario9954.gmail.com.Kutandisa.DTOS.UserDTOS.UserResponseDTO;

public record EmpresaResponseDTO(
        Long id,
        String nomeEmpresa,
        String nif,
        String descricao,
        String telefone,
        String email,
        String website,
        Boolean verificada,
        UserResponseDTO usuario
) {}