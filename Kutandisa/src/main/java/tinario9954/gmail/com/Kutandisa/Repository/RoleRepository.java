package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNome(String nome);
    boolean existsByNome(String nome);
}