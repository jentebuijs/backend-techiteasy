package nl.novi.backend.techiteasy.repositories;

import nl.novi.backend.techiteasy.models.entities.RemoteControl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControlRepository extends JpaRepository<RemoteControl, Long> {
}
