package juliancambraia.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author juliancambraia
 */
@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index", "/vetsindex.html"})
    public String listVets() {
        return "vets/index";
    }
}
