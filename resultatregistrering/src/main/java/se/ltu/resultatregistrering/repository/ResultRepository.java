

package se.ltu.resultatregistrering.repository;

import se.ltu.resultatregistrering.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}