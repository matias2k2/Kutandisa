package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByTuristaId(Long turistaId);
    List<Reserva> findByServicoId(Long servicoId);
    List<Reserva> findByEstado(String estado);
}