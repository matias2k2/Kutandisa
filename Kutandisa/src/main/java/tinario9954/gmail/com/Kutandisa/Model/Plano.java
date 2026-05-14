package tinario9954.gmail.com.Kutandisa.Model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "planos")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    // STARTER, PRO, ENTERPRISE

    private BigDecimal precoMensal;

    private Integer limiteServicos;

    private Boolean destaqueMapa;

    private Boolean analytics;

    private Boolean suporteDedicado;
}
