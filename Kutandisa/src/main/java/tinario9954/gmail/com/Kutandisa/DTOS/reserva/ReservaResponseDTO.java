package tinario9954.gmail.com.Kutandisa.DTOS.reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaResponseDTO(
        Long id,
        LocalDate dataReserva,
        LocalDate dataEntrada,
        LocalDate dataSaida,
        Integer quantidadePessoas,
        BigDecimal valorTotal,
        String estado,
        String turista,
        String servico
) {}