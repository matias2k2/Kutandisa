package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import tinario9954.gmail.com.Kutandisa.Enum.RoleNome;
import tinario9954.gmail.com.Kutandisa.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
 
    List<User> findByRole_Nome(RoleNome nomeRole);
    List<User> findByRole_Id(Long roleId);
 
    List<User> findByActivo(Boolean activo);
 
    List<User> findByNomeCompletoContainingIgnoreCase(String nome);
 
    Optional<User> findByTelefone(String telefone);
    boolean existsByTelefone(String telefone);
 
    @Query("SELECT u FROM User u WHERE u.role.nome = :role AND u.activo = true")
    List<User> findActivosByRole(@Param("role") RoleNome role);
 
    @Query("SELECT COUNT(u) FROM User u WHERE u.role.nome = :role")
    Long countByRole(@Param("role") RoleNome role);
}