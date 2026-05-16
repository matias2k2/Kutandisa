package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
    List<Destino> findByMunicipioId(Long municipioId);
    List<Destino> findByNomeContainingIgnoreCase(String nome);
}
