package ecohome.service;

import ecohome.model.Residencia;
import ecohome.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenciaService {

    @Autowired
    private ResidenciaRepository residenciaRepository;

    public Residencia save(Residencia residencia) {
        return residenciaRepository.save(residencia);
    }

    public Residencia update(Residencia residencia) {
        return residenciaRepository.save(residencia);
    }

    public Optional<Residencia> findById(Long id) {
        return residenciaRepository.findById(id);
    }

    public void deleteById(Long id) {
        residenciaRepository.deleteById(id);
    }

    public List<Residencia> findAll() {
        return residenciaRepository.findAll();
    }

    public List<Residencia> findByNameContaining(String nomeResidencia) {
        return residenciaRepository.findByNomeResidenciaContaining(nomeResidencia);
    }

    public void deleteAll() {
        residenciaRepository.deleteAll();
    }
}
