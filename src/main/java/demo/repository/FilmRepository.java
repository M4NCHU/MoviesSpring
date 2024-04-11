package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.models.Film;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTytulContaining(String tytul);

}
