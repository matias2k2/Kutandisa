package tinario9954.gmail.com.Kutandisa.DTOS.roteiro;

import java.math.BigDecimal;
import java.util.List;

public record RoteiroRequestDTO(
        String titulo,
        String tipoViagem,
        BigDecimal orcamento,
        Integer dias,
        Long turistaId,
        List<Long> destinosIds
) {}
