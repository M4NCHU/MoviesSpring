package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.models.Rezyser;
import demo.repository.RezyserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RezyserService {

    private final RezyserRepository rezyserRepository;

    @Autowired
    public RezyserService(RezyserRepository rezyserRepository) {
        this.rezyserRepository = rezyserRepository;
    }

    public List<Rezyser> findAll() {
        return rezyserRepository.findAll();
    }

    public Optional<Rezyser> findById(Long id) {
        return rezyserRepository.findById(id);
    }

    public Rezyser save(Rezyser rezyser) {
        return rezyserRepository.save(rezyser);
    }

    public void deleteById(Long id) {
        rezyserRepository.deleteById(id);
    }
}
