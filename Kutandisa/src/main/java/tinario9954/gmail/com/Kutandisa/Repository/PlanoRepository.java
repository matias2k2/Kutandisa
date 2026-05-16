package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Optional<Plano> findByNome(String nome);
}