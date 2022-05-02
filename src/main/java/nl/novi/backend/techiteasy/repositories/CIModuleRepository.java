package nl.novi.backend.techiteasy.repositories;

import nl.novi.backend.techiteasy.models.entities.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
