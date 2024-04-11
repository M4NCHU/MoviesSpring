package demo.controller;

import demo.models.Gatunek;
import demo.service.GatunekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gatunki")
public class GatunekController {

    @Autowired
    private GatunekService gatunekService;

    @GetMapping
    public String getAllGatunki(Model model) {
        model.addAttribute("gatunki", gatunekService.findAll());
        return "gatunki/lista";
    }

    @GetMapping("/{id}")
    public String getGatunekById(@PathVariable Long id, Model model) {
        model.addAttribute("gatunek", gatunekService.findById(id));
        return "gatunki/szczegoly";
    }


}
