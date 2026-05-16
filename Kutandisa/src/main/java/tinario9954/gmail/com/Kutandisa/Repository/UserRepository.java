package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import tinario9954.gmail.com.Kutandisa.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
 
    // ── Por role ──────────────────────────────────────────
    List<User> findByRole_Nome(String nomeRole);
    List<User> findByRole_Id(Long roleId);
 
    // ── Por estado ────────────────────────────────────────
    List<User> findByActivo(Boolean activo);
 
    // ── Busca por nome ────────────────────────────────────
    List<User> findByNomeCompletoContainingIgnoreCase(String nome);
 
    // ── Busca por telefone ────────────────────────────────
    Optional<User> findByTelefone(String telefone);
    boolean existsByTelefone(String telefone);
 
    // ── Activos por role ──────────────────────────────────
    @Query("SELECT u FROM User u WHERE u.role.nome = :role AND u.activo = true")
    List<User> findActivosByRole(@Param("role") String role);
 
    // ── Contagem por role ─────────────────────────────────
    @Query("SELECT COUNT(u) FROM User u WHERE u.role.nome = :role")
    Long countByRole(@Param("role") String role);
 
    // ── Adicionados: necessários pelo UserService ─────────
    boolean existsById(Long id);


}