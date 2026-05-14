package tinario9954.gmail.com.Kutandisa.DTOS.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponseDTO(
        Long id,
        BigDecimal valor,
        String metodoPagamento,
        String estado,
        LocalDateTime dataPagamento,
        Long reservaId
) {}