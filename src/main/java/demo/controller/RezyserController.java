package demo.controller;

import demo.models.Rezyser;
import demo.service.RezyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RezyserController {

    @Autowired
    private RezyserService rezyserService;

    @GetMapping("/rezyserzy")
    public String listaRezyserow(Model model) {
        model.addAttribute("rezyserzy", rezyserService.findAll());
        return "listaRezyserow";
    }

    @GetMapping("/zapiszRezysera")
    public String pokazFormularzDlaRezysera(Model model) {
        model.addAttribute("rezyser", new Rezyser());
        return "dodajRezysera";
    }

    @PostMapping("/zapiszRezysera")
    public String zapiszRezysera(@ModelAttribute Rezyser rezyser) {
        rezyserService.save(rezyser);
        return "redirect:/rezyserzy";
    }

    @GetMapping("/edytujRezysera/{id}")
    public String edytujRezysera(@PathVariable Long id, Model model) {
        Rezyser rezyser = rezyserService.findById(id).orElse(null);
        if (rezyser != null) {
            model.addAttribute("rezyser", rezyser);
            return "edytujRezysera";
        } else {
            return "redirect:/rezyserzy";
        }
    }

    @PostMapping("/edytujRezysera")
    public String edytujRezysera(@ModelAttribute Rezyser rezyser) {
        rezyserService.save(rezyser);
        return "redirect:/rezyserzy";
    }

    @GetMapping("/usunRezysera/{id}")
    public String usunRezysera(@PathVariable Long id) {
        rezyserService.deleteById(id);
        return "redirect:/rezyserzy";
    }
}
