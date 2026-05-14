package tinario9954.gmail.com.Kutandisa.Model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roteiros")
public class Roteiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String tipoViagem;
    // CULTURA, NATUREZA, AVENTURA, ROMANTICO, FAMILIA

    private BigDecimal orcamento;

    private Integer dias;

    @ManyToOne
    @JoinColumn(name = "turista_id")
    private User turista;
}