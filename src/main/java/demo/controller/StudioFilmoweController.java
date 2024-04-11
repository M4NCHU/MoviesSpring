package demo.controller;

import demo.models.StudioFilmowe;
import demo.service.StudioFilmoweService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudioFilmoweController {

    @Autowired
    private StudioFilmoweService studioFilmoweService;

    @GetMapping("/studiaFilmowe")
    public String listaStudiowFilmowych(Model model) {
        model.addAttribute("studiaFilmowe", studioFilmoweService.findAll());
        return "listaStudiowFilmowych";
    }

    @GetMapping("/zapiszStudioFilmowe")
    public String pokazFormularzDlaStudiaFilmowego(Model model) {
        model.addAttribute("studioFilmowe", new StudioFilmowe());
        return "dodajStudioFilmowe";
    }

    @PostMapping("/zapiszStudioFilmowe")
    public String zapiszStudioFilmowe(@ModelAttribute StudioFilmowe studioFilmowe) {
        studioFilmoweService.save(studioFilmowe);
        return "redirect:/studiaFilmowe";
    }

    @GetMapping("/edytujStudioFilmowe/{id}")
    public String edytujStudioFilmowe(@PathVariable Long id, Model model) {
        StudioFilmowe studioFilmowe = studioFilmoweService.findById(id).orElse(null);
        if (studioFilmowe != null) {
            model.addAttribute("studioFilmowe", studioFilmowe);
            return "edytujStudioFilmowe";
        } else {
            return "redirect:/studiaFilmowe";
        }
    }

    @PostMapping("/edytujStudioFilmowe")
    public String edytujStudioFilmowe(@ModelAttribute StudioFilmowe studioFilmowe) {
        studioFilmoweService.save(studioFilmowe);
        return "redirect:/studiaFilmowe";
    }

    @GetMapping("/usunStudioFilmowe/{id}")
    public String usunStudioFilmowe(@PathVariable Long id) {
        studioFilmoweService.deleteById(id);
        return "redirect:/studiaFilmowe";
    }
}
