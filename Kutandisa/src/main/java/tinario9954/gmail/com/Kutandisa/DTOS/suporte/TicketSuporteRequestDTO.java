package tinario9954.gmail.com.Kutandisa.DTOS.suporte;

public record TicketSuporteRequestDTO(
        String assunto,
        String descricao,
        Long usuarioId
) {}