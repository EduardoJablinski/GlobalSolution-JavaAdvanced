package ecohome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecohome.model.Comodo;

import java.util.List;

@Repository
public interface ComodoRepository extends JpaRepository<Comodo, Long> {

    List<Comodo> findByNomeComodoContaining(String nomeComodo);
}
