package tinario9954.gmail.com.Kutandisa.DTOS.roteiro;

import java.math.BigDecimal;
import java.util.List;

import tinario9954.gmail.com.Kutandisa.DTOS.destino.DestinoResponseDTO;

public record RoteiroResponseDTO(
        Long id,
        String titulo,
        String tipoViagem,
        BigDecimal orcamento,
        Integer dias,
        String turista,
        List<DestinoResponseDTO> destinos
) {}