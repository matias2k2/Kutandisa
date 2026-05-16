package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Optional<Pagamento> findByReservaId(Long reservaId);
}