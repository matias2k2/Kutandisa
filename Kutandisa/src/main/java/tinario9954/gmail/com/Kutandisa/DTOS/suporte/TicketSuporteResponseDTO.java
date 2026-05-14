package tinario9954.gmail.com.Kutandisa.DTOS.suporte;

import java.time.LocalDateTime;

public record TicketSuporteResponseDTO(
        Long id,
        String assunto,
        String descricao,
        String estado,
        LocalDateTime criadoEm,
        String usuario
) {}