package ecohome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecohome.model.Residencia;

import java.util.List;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia, Long> {

    List<Residencia> findByNomeResidenciaContaining(String nomeResidencia);
}
