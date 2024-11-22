package ecohome.service;

import ecohome.model.Consumo;
import ecohome.model.Eletrodomestico;
import ecohome.repository.ConsumoRepository;
import ecohome.repository.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;


    public Consumo save(Consumo consumo) {
        return consumoRepository.save(consumo);
    }

    public Consumo update(Consumo consumo) {
        return consumoRepository.save(consumo);
    }

    public Optional<Consumo> findById(Long id) {
        return consumoRepository.findById(id);
    }

    public void deleteById(Long id) {
        consumoRepository.deleteById(id);
    }

    public List<Consumo> findAll() {
        return consumoRepository.findAll();
    }

    public void deleteAll() {
        consumoRepository.deleteAll();
    }

}

