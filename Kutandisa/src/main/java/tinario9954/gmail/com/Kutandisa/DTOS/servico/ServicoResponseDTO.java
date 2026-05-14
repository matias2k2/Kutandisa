package tinario9954.gmail.com.Kutandisa.DTOS.servico;

import java.math.BigDecimal;

public record ServicoResponseDTO(
        Long id,
        String titulo,
        String descricao,
        BigDecimal preco,
        String contacto,
        Boolean disponivel,
        Double latitude,
        Double longitude,
        String empresa,
        String categoria,
        String destino
) {}