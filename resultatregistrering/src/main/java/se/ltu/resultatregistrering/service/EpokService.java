


package se.ltu.resultatregistrering.service;

import java.util.List;
import org.springframework.stereotype.Service;

import se.ltu.resultatregistrering.model.Module;
import se.ltu.resultatregistrering.repository.epok.ModuleRepository;

@Service
public class EpokService {

    private final ModuleRepository moduleRepository;

    public EpokService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public List<Module> getActiveModules(String courseCode) {
        return moduleRepository.findByCourseCodeAndActiveTrue(courseCode);
    }
}