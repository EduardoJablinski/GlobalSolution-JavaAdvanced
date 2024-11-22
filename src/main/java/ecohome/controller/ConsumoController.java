package ecohome.controller;

import ecohome.model.Consumo;
import ecohome.model.Eletrodomestico;
import ecohome.repository.ConsumoRepository;
import ecohome.repository.EletrodomesticoRepository;
import ecohome.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class ConsumoController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    ConsumoRepository consumoRepository;

    @Autowired
    EletrodomesticoRepository eletrodomesticoRepository;

    @GetMapping("/consumos")
    public String getAllConsumos(@RequestParam(required = false) String eletrodomestico, Model model) {
        List<Consumo> consumos = consumoRepository.findAll();
        List<Eletrodomestico> eletrodomesticos = eletrodomesticoRepository.findAll();

        model.addAttribute("consumos", consumos);
        model.addAttribute("eletrodomesticos", eletrodomesticos);
        model.addAttribute("pageTitle",
                messageSource.getMessage("consumo.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "consumos";
    }

    @GetMapping("/consumos/{id}")
    public String getConsumoById(@PathVariable("id") long id, Model model) {
        Optional<Consumo> consumo = consumoRepository.findById(id);
        if (consumo.isEmpty()) {
            return "redirect:/admin/consumos";
        }
        model.addAttribute("consumo", consumo.get());
        return "consumo-detalhes";
    }

    @PostMapping("/consumos")
    public String createConsumo(@ModelAttribute Consumo consumo) {
        consumoRepository.save(consumo);
        return "redirect:/admin/consumos";
    }

    @PostMapping("/consumos/{id}")
    public String updateConsumo(@PathVariable("id") long id, @ModelAttribute Consumo consumo) {
        Optional<Consumo> existingConsumo = consumoRepository.findById(id);
        if (existingConsumo.isPresent()) {
            consumo.setIdConsumo(id);
            consumoRepository.save(consumo);
        }
        return "redirect:/admin/consumos";
    }

    @PostMapping("/consumos/{id}/delete")
    public String deleteConsumo(@PathVariable("id") long id) {
        consumoRepository.deleteById(id);
        return "redirect:/admin/consumos";
    }
}
