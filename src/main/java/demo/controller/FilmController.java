package demo.controller;

import demo.models.Film;
import demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;


    @GetMapping("/filmy")
    public String listaFilmow(@RequestParam(value = "szukaj", required = false) String szukaj, Model model) {
        List<Film> filmy;
        if (szukaj != null && !szukaj.isEmpty()) {
            filmy = filmService.findByTytulContaining(szukaj);
        } else {
            filmy = filmService.findAll();
        }
        model.addAttribute("filmy", filmy);
        return "film/listaFilmow";
    }


    @GetMapping("/dodaj-film")
    public String pokazFormularz(Model model) {
        model.addAttribute("film", new Film());
        return "dodajFilm";
    }


    @PostMapping("/dodaj-film")
    public String zapiszFilm(@ModelAttribute Film film) {
        filmService.save(film);
        return "redirect:/filmy";
    }

    @GetMapping("/edytuj-film/{id}")
    public String edytujFilm(@PathVariable Long id, Model model) {
        Film film = filmService.findById(id).orElse(null);
        if (film != null) {
            model.addAttribute("film", film);
            return "film/edytujFilm";
        } else {
            return "redirect:/filmy";
        }
    }

    @GetMapping("/film/{id}")
    public String pokazSzczegolyFilmu(@PathVariable Long id, Model model) {
        Film film = filmService.findById(id).orElse(null);
        if (film != null) {
            model.addAttribute("film", film);
            return "film/szczegoly"; // Nazwa pliku html ze szczegółami filmu
        } else {
            // Jeśli film nie istnieje, przekieruj na listę filmów z komunikatem o błędzie
            model.addAttribute("errorMessage", "Film o podanym ID nie istnieje");
            return "redirect:/filmy";
        }
    }


    @PostMapping("/edytujFilm")
    public String edytujFilm(@ModelAttribute Film film) {
        filmService.save(film);
        return "redirect:/filmy";
    }

    @PostMapping("/usunFilm/{id}")
    public String usunFilmPost(@PathVariable Long id) {
        filmService.deleteById(id);
        return "redirect:/filmy";
    }

    @DeleteMapping("/usunFilm/{id}")
    public String usunFilmDelete(@PathVariable Long id) {
        filmService.deleteById(id);
        return "redirect:/filmy";
    }




}
