package ecohome.controller;

import ecohome.model.Eletrodomestico;
import ecohome.model.Comodo;
import ecohome.repository.EletrodomesticoRepository;
import ecohome.repository.ComodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class EletrodomesticoController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    EletrodomesticoRepository eletrodomesticoRepository;

    @Autowired
    ComodoRepository comodoRepository;

    @GetMapping("/eletrodomesticos")
    public String getAllEletrodomesticos(@RequestParam(required = false) String nome, Model model) {
        List<Eletrodomestico> eletrodomesticos = nome == null ?
                eletrodomesticoRepository.findAll() :
                eletrodomesticoRepository.findByNomeEletrodomesticoContaining(nome.trim());

        List<Comodo> comodos = comodoRepository.findAll();

        model.addAttribute("eletrodomesticos", eletrodomesticos);
        model.addAttribute("comodos", comodos);
        model.addAttribute("pageTitle",
                messageSource.getMessage("eletrodomestico.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "eletrodomesticos";
    }

    @GetMapping("/eletrodomesticos/{id}")
    public String getEletrodomesticoById(@PathVariable("id") long id, Model model) {
        Optional<Eletrodomestico> eletrodomestico = eletrodomesticoRepository.findById(id);
        if (eletrodomestico.isEmpty()) {
            return "redirect:/admin/eletrodomesticos";
        }
        model.addAttribute("eletrodomestico", eletrodomestico.get());
        return "eletrodomestico-detalhes";
    }

    @PostMapping("/eletrodomesticos")
    public String createEletrodomestico(@ModelAttribute Eletrodomestico eletrodomestico) {
        eletrodomesticoRepository.save(eletrodomestico);
        return "redirect:/admin/eletrodomesticos";
    }

    @PostMapping("/eletrodomesticos/{id}")
    public String updateEletrodomestico(@PathVariable("id") long id, @ModelAttribute Eletrodomestico eletrodomestico) {
        Optional<Eletrodomestico> _eletrodomestico = eletrodomesticoRepository.findById(id);
        if (_eletrodomestico.isPresent()) {
            eletrodomestico.setIdEletrodomestico(id);
            eletrodomesticoRepository.save(eletrodomestico);
        }
        return "redirect:/admin/eletrodomesticos";
    }

    @PostMapping("/eletrodomesticos/{id}/delete")
    public String deleteEletrodomestico(@PathVariable("id") long id) {
        eletrodomesticoRepository.deleteById(id);
        return "redirect:/admin/eletrodomesticos";
    }
}
