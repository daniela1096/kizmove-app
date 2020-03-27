package co.com.kizmove.controller;

import co.com.kizmove.domain.Person;
import co.com.kizmove.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


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

    @GetMapping("/add")
    public String addPerson(Person person){
        return "viewPerson";
    }

    @PostMapping("/save")
    public String savePerson(@Valid Person person, Errors errors){
        if(errors.hasErrors()){
            return "viewPerson";
        }
        personService.savePerson(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(Person person, Model model){
        person =personService.findPerson(person);
        model.addAttribute("person",person);
        return "viewPerson";
    }

    //@GetMapping("/delete/{id}")
    @GetMapping("/delete")
    public String deletePerson(Person person){
        personService.deletePerson(person);
        return "redirect:/";
    }

}
