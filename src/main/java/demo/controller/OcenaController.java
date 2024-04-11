package demo.controller;

import demo.models.Ocena;
import demo.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oceny")
public class OcenaController {

    @Autowired
    private OcenaService ocenaService;

    @GetMapping
    public String getAllOceny(Model model) {
        model.addAttribute("oceny", ocenaService.findAll());
        return "oceny/lista";
    }

    @GetMapping("/{id}")
    public String getOcenaById(@PathVariable Long id, Model model) {
        model.addAttribute("ocena", ocenaService.findById(id));
        return "oceny/szczegoly";
    }


}
