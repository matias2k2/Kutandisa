package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.MensagemSuporteIA;

public interface MensagemSuporteIARepository extends JpaRepository<MensagemSuporteIA, Long> {
    List<MensagemSuporteIA> findByUsuarioId(Long usuarioId);
}