package tinario9954.gmail.com.Kutandisa.Model;

import jakarta.persistence.Column;
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
@Table(name = "users")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String nomeCompleto;
 
    @Column(unique = true, nullable = false)
    private String email;
 
    @Column(unique = true)
    private String telefone;
 
    @Column(nullable = false)
    private String password;
 
    private String fotoPerfil;
 
    @Column(nullable = false)
    private Boolean activo = true;
 
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}