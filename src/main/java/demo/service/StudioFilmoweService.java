package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.models.StudioFilmowe;
import demo.repository.StudioFilmoweRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudioFilmoweService {

    private final StudioFilmoweRepository studioFilmoweRepository;

    @Autowired
    public StudioFilmoweService(StudioFilmoweRepository studioFilmoweRepository) {
        this.studioFilmoweRepository = studioFilmoweRepository;
    }

    public List<StudioFilmowe> findAll() {
        return studioFilmoweRepository.findAll();
    }

    public Optional<StudioFilmowe> findById(Long id) {
        return studioFilmoweRepository.findById(id);
    }

    public StudioFilmowe save(StudioFilmowe studioFilmowe) {
        return studioFilmoweRepository.save(studioFilmowe);
    }

    public void deleteById(Long id) {
        studioFilmoweRepository.deleteById(id);
    }
}
