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
@Table(name = "mensagens_suporte_ia")
public class MensagemSuporteIA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String perguntaUsuario;

    @Column(columnDefinition = "TEXT")
    private String respostaIA;

    private LocalDateTime dataMensagem;

    @ManyToOne
    private User usuario;
}