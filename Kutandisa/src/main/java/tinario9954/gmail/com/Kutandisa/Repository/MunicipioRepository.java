package tinario9954.gmail.com.Kutandisa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tinario9954.gmail.com.Kutandisa.Model.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    List<Municipio> findByProvinciaId(Long provinciaId);
}