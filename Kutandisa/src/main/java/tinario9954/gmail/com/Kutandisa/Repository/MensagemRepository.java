package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findByChatIdOrderByEnviadaEmAsc(Long chatId);
}