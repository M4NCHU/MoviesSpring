package demo.controller;

import demo.models.Aktor;
import demo.service.AktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AktorController {

    @Autowired
    private AktorService aktorService;

    @GetMapping("/aktorzy")
    public String listaAktorow(Model model) {
        model.addAttribute("aktorzy", aktorService.findAll());
        return "listaAktorow";
    }

    @GetMapping("/zapiszAktora")
    public String pokazFormularzDlaAktora(Model model) {
        model.addAttribute("aktor", new Aktor());
        return "dodajAktora";
    }

    @PostMapping("/zapiszAktora")
    public String zapiszAktora(@ModelAttribute Aktor aktor) {
        aktorService.save(aktor);
        return "redirect:/aktorzy";
    }

    @GetMapping("/edytujAktora/{id}")
    public String edytujAktora(@PathVariable Long id, Model model) {
        Aktor aktor = aktorService.findById(id).orElse(null);
        if (aktor != null) {
            model.addAttribute("aktor", aktor);
            return "edytujAktora";
        } else {
            return "redirect:/aktorzy";
        }
    }

    @PostMapping("/edytujAktora")
    public String edytujAktora(@ModelAttribute Aktor aktor) {
        aktorService.save(aktor);
        return "redirect:/aktorzy";
    }

    @GetMapping("/usunAktora/{id}")
    public String usunAktora(@PathVariable Long id) {
        aktorService.deleteById(id);
        return "redirect:/aktorzy";
    }
}
