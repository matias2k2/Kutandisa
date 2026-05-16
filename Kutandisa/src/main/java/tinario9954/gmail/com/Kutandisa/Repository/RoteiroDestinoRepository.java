package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.RoteiroDestino;

public interface RoteiroDestinoRepository extends JpaRepository<RoteiroDestino, Long> {
    List<RoteiroDestino> findByRoteiroIdOrderByOrdemVisitaAsc(Long roteiroId);
}