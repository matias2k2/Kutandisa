package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.CategoriaServico;

public interface CategoriaServicoRepository extends JpaRepository<CategoriaServico, Long> {
    Optional<CategoriaServico> findByNome(String nome);
}