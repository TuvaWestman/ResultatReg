




package se.ltu.resultatregistrering.repository;

import se.ltu.resultatregistrering.model.RegistrationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationLogRepository extends JpaRepository<RegistrationLog, Integer> {
}