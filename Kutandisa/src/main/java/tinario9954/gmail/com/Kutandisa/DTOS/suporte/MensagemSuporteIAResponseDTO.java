package tinario9954.gmail.com.Kutandisa.DTOS.suporte;

import java.time.LocalDateTime;

public record MensagemSuporteIAResponseDTO(
        Long id,
        String perguntaUsuario,
        String respostaIA,
        LocalDateTime dataMensagem,
        String usuario
) {}
