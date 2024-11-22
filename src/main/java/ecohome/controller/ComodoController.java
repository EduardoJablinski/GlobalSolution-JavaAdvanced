package ecohome.controller;

import ecohome.model.Comodo;
import ecohome.model.Residencia;
import ecohome.repository.ComodoRepository;
import ecohome.repository.ResidenciaRepository;
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
public class ComodoController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    ComodoRepository comodoRepository;

    @Autowired
    ResidenciaRepository residenciaRepository;

    @GetMapping("/comodos")
    public String getAllComodos(@RequestParam(required = false) String nome, Model model) {
        List<Comodo> comodos = nome == null ?
                comodoRepository.findAll() :
                comodoRepository.findByNomeComodoContaining(nome.trim());

        List<Residencia> residencias = residenciaRepository.findAll();

        model.addAttribute("comodos", comodos);
        model.addAttribute("residencias", residencias);
        model.addAttribute("pageTitle",
                messageSource.getMessage("comodo.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "comodos";
    }

    @ModelAttribute("residencias")
    public List<Residencia> getResidencias() {
        return residenciaRepository.findAll();
    }

    @GetMapping("/comodos/{id}")
    public String getComodoById(@PathVariable("id") long id, Model model) {
        Optional<Comodo> comodo = comodoRepository.findById(id);
        if (comodo.isEmpty()) {
            return "redirect:/admin/comodos";
        }
        model.addAttribute("comodo", comodo.get());
        return "comodo-detalhes";
    }

    @PostMapping("/comodos")
    public String createComodo(@ModelAttribute Comodo comodo) {
        Optional<Residencia> residencia = residenciaRepository.findById(comodo.getResidencia().getIdResidencia());
        if (residencia.isPresent()) {
            comodoRepository.save(comodo);
            return "redirect:/admin/comodos";
        } else {
            return "redirect:/admin/comodos?error=residencia-nao-encontrada";
        }
    }
    @PostMapping("/comodos/{id}")
    public String updateComodo(@PathVariable("id") long id, @ModelAttribute Comodo comodo) {
        Optional<Comodo> _comodo = comodoRepository.findById(id);
        if (_comodo.isPresent()) {
            comodo.setIdComodo(id);
            comodoRepository.save(comodo);
        }
        return "redirect:/admin/comodos";
    }

    @PostMapping("/comodos/{id}/delete")
    public String deleteComodo(@PathVariable("id") long id) {
        comodoRepository.deleteById(id);
        return "redirect:/admin/comodos";
    }
}
