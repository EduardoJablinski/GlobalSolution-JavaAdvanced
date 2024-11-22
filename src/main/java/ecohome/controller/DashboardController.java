package ecohome.controller;

import ecohome.model.Consumo;
import ecohome.model.Eletrodomestico;
import ecohome.model.Residencia;
import ecohome.model.Comodo;
import ecohome.repository.ComodoRepository;
import ecohome.repository.ConsumoRepository;
import ecohome.service.ConsumoService;
import ecohome.repository.EletrodomesticoRepository;
import ecohome.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ResidenciaRepository residenciaRepository;

    @Autowired
    private ComodoRepository comodoRepository;

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ChatbotController chatbotController;

    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    @Autowired
    private ConsumoService consumoService;

    @GetMapping
    public String dashboard(Model model) {

        // Mantém a lógica existente
        model.addAttribute("pageTitle",
                messageSource.getMessage("app.dashboard", null, LocaleContextHolder.getLocale()));

        // Adiciona as mensagens do chat se existirem no flash attribute
        if (!model.containsAttribute("chatMessages")) {
            model.addAttribute("chatMessages", chatbotController.getChatMessages());
        }

        return "dashboard";
    }


    @GetMapping("/residencias")
    public String residencias(Model model) {
        List<Residencia> residencias = residenciaRepository.findAll();
        model.addAttribute("residencias", residencias);
        model.addAttribute("pageTitle",
                messageSource.getMessage("residencia.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "residencias";
    }


    @GetMapping("/comodos")
    public String comodos(Model model) {
        List<Comodo> comodos = comodoRepository.findAll();
        model.addAttribute("comodos", comodos);
        model.addAttribute("pageTitle",
                messageSource.getMessage("comodo.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "comodos";
    }

    @GetMapping("/eletrodomesticos")
    public String eletrodomesticos(Model model) {
        List<Eletrodomestico> eletrodomesticos = eletrodomesticoRepository.findAll();
        model.addAttribute("eletrodomesticos", eletrodomesticos);
        model.addAttribute("pageTitle",
                messageSource.getMessage("eletrodomestico.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "eletrodomesticos";
    }


    @GetMapping("/consumos")
    public String consumos(Model model) {
        List<Consumo> consumos = consumoRepository.findAll();
        model.addAttribute("consumos", consumos);
        model.addAttribute("pageTitle",
                messageSource.getMessage("consumo.lista.titulo", null, LocaleContextHolder.getLocale()));
        return "consumos";
    }

}
