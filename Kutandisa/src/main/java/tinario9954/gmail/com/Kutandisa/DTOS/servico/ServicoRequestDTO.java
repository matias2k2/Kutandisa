package tinario9954.gmail.com.Kutandisa.DTOS.servico;

import java.math.BigDecimal;

public record ServicoRequestDTO(
        String titulo,
        String descricao,
        BigDecimal preco,
        String contacto,
        Boolean disponivel,
        Double latitude,
        Double longitude,
        Long empresaId,
        Long categoriaId,
        Long destinoId
) {}