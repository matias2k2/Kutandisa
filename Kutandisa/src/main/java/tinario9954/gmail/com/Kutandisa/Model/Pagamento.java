package tinario9954.gmail.com.Kutandisa.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String metodoPagamento;
    // MULTICAIXA, TRANSFERENCIA, CARTAO, CASH

    private String estado;
    // PENDENTE, PAGO, FALHOU

    private LocalDateTime dataPagamento;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}