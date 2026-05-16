package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.TicketSuporte;

public interface TicketSuporteRepository extends JpaRepository<TicketSuporte, Long> {
    List<TicketSuporte> findByUsuarioId(Long usuarioId);
    List<TicketSuporte> findByEstado(String estado);
}