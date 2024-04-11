package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.models.Aktor;
import demo.repository.AktorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AktorService {

    private final AktorRepository aktorRepository;

    @Autowired
    public AktorService(AktorRepository aktorRepository) {
        this.aktorRepository = aktorRepository;
    }

    public List<Aktor> findAll() {
        return aktorRepository.findAll();
    }

    public Optional<Aktor> findById(Long id) {
        return aktorRepository.findById(id);
    }

    public Aktor save(Aktor aktor) {
        return aktorRepository.save(aktor);
    }

    public void deleteById(Long id) {
        aktorRepository.deleteById(id);
    }
}
