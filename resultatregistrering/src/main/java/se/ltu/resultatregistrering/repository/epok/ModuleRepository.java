
package se.ltu.resultatregistrering.repository.epok;

import se.ltu.resultatregistrering.model.Module;
import se.ltu.resultatregistrering.model.ModuleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, ModuleId> {

    List<Module> findByCourseCodeAndActiveTrue(String courseCode);

}
