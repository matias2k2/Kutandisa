package tinario9954.gmail.com.Kutandisa.Model;

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
@Table(name = "roteiro_destinos")
public class RoteiroDestino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ordemVisita;

    @ManyToOne
    @JoinColumn(name = "roteiro_id")
    private Roteiro roteiro;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;
}