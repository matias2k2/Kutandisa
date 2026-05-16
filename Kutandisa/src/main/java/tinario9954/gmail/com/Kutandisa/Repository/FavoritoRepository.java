package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    List<Favorito> findByTuristaId(Long turistaId);
    Optional<Favorito> findByTuristaIdAndServicoId(Long turistaId, Long servicoId);
    boolean existsByTuristaIdAndServicoId(Long turistaId, Long servicoId);
}