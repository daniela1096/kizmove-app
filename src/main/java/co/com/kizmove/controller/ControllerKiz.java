package co.com.kizmove.controller;

import co.com.kizmove.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class ControllerKiz {

    @Autowired
    private PersonService personService;

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Bienvenidos a KIZMOVE";
        var persons = personService.listPersons();

        log.info("ejecutando el controlador spring mvc");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persons", persons);

        return "index";
    }

}
