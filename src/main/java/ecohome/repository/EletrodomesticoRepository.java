package ecohome.repository;

import ecohome.model.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {

    List<Eletrodomestico> findByNomeEletrodomesticoContaining(String nomeEletrodomestico);
}
