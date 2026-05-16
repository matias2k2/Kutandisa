package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByNif(String nif);
    boolean existsByNif(String nif);
    List<Empresa> findByVerificada(Boolean verificada);
}