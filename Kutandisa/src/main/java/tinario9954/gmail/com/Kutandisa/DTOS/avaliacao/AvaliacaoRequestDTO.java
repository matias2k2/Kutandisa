package tinario9954.gmail.com.Kutandisa.DTOS.avaliacao;

public record AvaliacaoRequestDTO(
        Integer nota,
        String comentario,
        Long turistaId,
        Long servicoId
) {}