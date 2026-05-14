package tinario9954.gmail.com.Kutandisa.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataReserva;

    private LocalDate dataEntrada;

    private LocalDate dataSaida;

    private Integer quantidadePessoas;

    private BigDecimal valorTotal;

    private String estado; 
    // PENDENTE, CONFIRMADA, CANCELADA, CONCLUIDA

    @ManyToOne
    @JoinColumn(name = "turista_id")
    private User turista;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
}