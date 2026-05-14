package tinario9954.gmail.com.Kutandisa.DTOS.destino;

import java.math.BigDecimal;

public record DestinoResponseDTO(
        Long id,
        String nome,
        String descricao,
        String imagemPrincipal,
        Double latitude,
        Double longitude,
        BigDecimal precoMedio,
        MunicipioDTO municipio
) {}