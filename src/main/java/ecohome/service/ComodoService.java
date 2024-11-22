package ecohome.service;

import ecohome.model.Comodo;
import ecohome.repository.ComodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComodoService {

    @Autowired
    private ComodoRepository comodoRepository;

    public Comodo save(Comodo comodo) {
        return comodoRepository.save(comodo);
    }

    public Comodo update(Comodo comodo) {
        return comodoRepository.save(comodo);
    }

    public Optional<Comodo> findById(Long id) {
        return comodoRepository.findById(id);
    }

    public void deleteById(Long id) {
        comodoRepository.deleteById(id);
    }

    public List<Comodo> findAll() {
        return comodoRepository.findAll();
    }

    public List<Comodo> findByNameContaining(String nomeComodo) {
        return comodoRepository.findByNomeComodoContaining(nomeComodo);
    }

    public void deleteAll() {
        comodoRepository.deleteAll();
    }
}
