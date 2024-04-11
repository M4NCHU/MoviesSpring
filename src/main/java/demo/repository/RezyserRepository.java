package demo.repository;

import demo.models.Rezyser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezyserRepository extends JpaRepository<Rezyser, Long> {
}
