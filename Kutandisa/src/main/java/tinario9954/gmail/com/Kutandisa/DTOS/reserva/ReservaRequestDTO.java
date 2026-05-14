package tinario9954.gmail.com.Kutandisa.DTOS.reserva;

import java.time.LocalDate;

public record ReservaRequestDTO(
        LocalDate dataEntrada,
        LocalDate dataSaida,
        Integer quantidadePessoas,
        Long turistaId,
        Long servicoId
) {}