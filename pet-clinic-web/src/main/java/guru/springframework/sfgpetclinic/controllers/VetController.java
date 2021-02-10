package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets","/vets/allvets","/vets/allvets.html"})
    public String listVets(){
        return "vets/allvets";
    }
}
