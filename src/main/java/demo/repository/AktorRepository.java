package demo.repository;

import demo.models.Aktor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AktorRepository extends JpaRepository<Aktor, Long> {
}