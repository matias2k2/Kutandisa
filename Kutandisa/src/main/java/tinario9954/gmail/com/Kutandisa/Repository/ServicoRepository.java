package tinario9954.gmail.com.Kutandisa.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByEmpresaId(Long empresaId);
    List<Servico> findByCategoriaId(Long categoriaId);
    List<Servico> findByDestinoId(Long destinoId);
    List<Servico> findByDisponivel(Boolean disponivel);
    List<Servico> findByPrecoLessThanEqual(BigDecimal preco);
    List<Servico> findByTituloContainingIgnoreCase(String titulo);
}