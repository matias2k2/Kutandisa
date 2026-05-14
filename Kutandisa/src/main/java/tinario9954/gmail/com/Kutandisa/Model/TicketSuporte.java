package tinario9954.gmail.com.Kutandisa.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tickets_suporte")
public class TicketSuporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assunto;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String estado;
    // ABERTO, EM_ANALISE, RESOLVIDO, FECHADO

    private LocalDateTime criadoEm;

    @ManyToOne
    private User usuario;
}