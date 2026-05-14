package tinario9954.gmail.com.Kutandisa.DTOS.avaliacao;

import java.time.LocalDateTime;

public record AvaliacaoResponseDTO(
        Long id,
        Integer nota,
        String comentario,
        LocalDateTime dataAvaliacao,
        String turista,
        String servico
) {}