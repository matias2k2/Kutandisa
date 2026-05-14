package tinario9954.gmail.com.Kutandisa.DTOS.pagamento;

import java.math.BigDecimal;

public record PagamentoRequestDTO(
        BigDecimal valor,
        String metodoPagamento,
        Long reservaId
) {}