package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.ImagemServico;

public interface ImagemServicoRepository extends JpaRepository<ImagemServico, Long> {
    List<ImagemServico> findByServicoId(Long servicoId);
}