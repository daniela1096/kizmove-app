package co.com.kizmove.controller;

import co.com.kizmove.dao.PersonDao;
import co.com.kizmove.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class ControllerKiz {

    @Autowired
    private PersonDao personDao;

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Bienvenidos a KIZMOVE";
        var persons = personDao.findAll();

        /*Person person = new Person();
        person.setName("Dani");
        person.setLastName("Diaz");
        person.setPhoneNumber("3224242");

        Person person1 = new Person();
        person1.setName("Vero");
        person1.setLastName("Gut");
        person1.setPhoneNumber("343422");

        Person person2 = new Person();
        person2.setName("Katy");
        person2.setLastName("Diaz");
        person2.setPhoneNumber("43422");

        var persons = Arrays.asList(person,person1, person2);*/

        log.info("ejecutando el controlador spring mvc");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persons", persons);

        return "index";
    }

}
