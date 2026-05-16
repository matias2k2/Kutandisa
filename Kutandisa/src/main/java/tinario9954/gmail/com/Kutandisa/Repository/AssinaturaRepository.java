package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Assinatura;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByEmpresaId(Long empresaId);
    List<Assinatura> findByEstado(String estado);
}