package nl.novi.backend.techiteasy.repositories;

import nl.novi.backend.techiteasy.models.entities.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
