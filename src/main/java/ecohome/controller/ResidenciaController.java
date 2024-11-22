package ecohome.controller;

import ecohome.model.Residencia;
import ecohome.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ResidenciaController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    ResidenciaRepository residenciaRepository;

    @GetMapping("/residencias")
    public String getAllResidencias(@RequestParam(required = false) String nome, Model model) {
        List<Residencia> residencias = nome == null ?
                residenciaRepository.findAll() :
                residenciaRepository.findByNomeResidenciaContaining(nome.trim());

        model.addAttribute("residencias", residencias);
        model.addAttribute("pageTitle",
                messageSource.getMessage("residencia.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "residencias";
    }

    @GetMapping("/residencias/{id}")
    public String getResidenciaById(@PathVariable("id") long id, Model model) {
        Optional<Residencia> residencia = residenciaRepository.findById(id);
        if (residencia.isEmpty()) {
            return "redirect:/admin/residencias";
        }
        model.addAttribute("residencia", residencia.get());
        return "residencia-detalhes";
    }

    @PostMapping("/residencias")
    public String createResidencia(@ModelAttribute Residencia residencia) {
        residenciaRepository.save(residencia);
        return "redirect:/admin/residencias";
    }

    @PostMapping("/residencias/{id}")
    public String updateResidencia(@PathVariable("id") long id, @ModelAttribute Residencia residencia) {
        Optional<Residencia> _residencia = residenciaRepository.findById(id);
        if (_residencia.isPresent()) {
            residencia.setIdResidencia(id);
            residenciaRepository.save(residencia);
        }
        return "redirect:/admin/residencias";
    }

    @PostMapping("/residencias/{id}/delete")
    public String deleteResidencia(@PathVariable("id") long id) {
        residenciaRepository.deleteById(id);
        return "redirect:/admin/residencias";
    }

    @PostMapping("/residencias/delete")
    public String deleteResidenciaById(@RequestParam("id") long id) {
        residenciaRepository.deleteById(id);
        return "redirect:/admin/residencias";
    }
}
