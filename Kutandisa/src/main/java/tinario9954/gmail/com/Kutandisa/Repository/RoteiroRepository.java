package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Roteiro;

public interface RoteiroRepository extends JpaRepository<Roteiro, Long> {
    List<Roteiro> findByTuristaId(Long turistaId);
    List<Roteiro> findByTipoViagem(String tipoViagem);
}