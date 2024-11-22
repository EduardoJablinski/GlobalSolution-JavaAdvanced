package ecohome.service;

import ecohome.model.Eletrodomestico;
import ecohome.repository.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EletrodomesticoService {

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    public Eletrodomestico save(Eletrodomestico eletrodomestico) {
        return eletrodomesticoRepository.save(eletrodomestico);
    }

    public Eletrodomestico update(Eletrodomestico eletrodomestico) {
        return eletrodomesticoRepository.save(eletrodomestico);
    }

    public Optional<Eletrodomestico> findById(Long id) {
        return eletrodomesticoRepository.findById(id);
    }

    public void deleteById(Long id) {
        eletrodomesticoRepository.deleteById(id);
    }

    public List<Eletrodomestico> findAll() {
        return eletrodomesticoRepository.findAll();
    }

    public List<Eletrodomestico> findByNameContaining(String nomeEletrodomestico) {
        return eletrodomesticoRepository.findByNomeEletrodomesticoContaining(nomeEletrodomestico);
    }

    public void deleteAll() {
        eletrodomesticoRepository.deleteAll();
    }
}
