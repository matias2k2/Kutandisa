package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByTuristaId(Long turistaId);
    List<Chat> findByEmpresaId(Long empresaId);
}