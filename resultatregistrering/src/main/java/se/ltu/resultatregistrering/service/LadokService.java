


package se.ltu.resultatregistrering.service;

import org.springframework.stereotype.Service;
import se.ltu.resultatregistrering.model.Result;
import se.ltu.resultatregistrering.model.RegistrationLog;
import se.ltu.resultatregistrering.repository.ladok.ResultRepository;
import se.ltu.resultatregistrering.repository.ladok.RegistrationLogRepository;

@Service
public class LadokService {

    private final ResultRepository resultRepository;
    private final RegistrationLogRepository registrationLogRepository;

    public LadokService(
            ResultRepository resultRepository,
            RegistrationLogRepository registrationLogRepository) {
        this.resultRepository = resultRepository;
        this.registrationLogRepository = registrationLogRepository;
    }

    public Result registerResult(Result result) {
        Result savedResult = resultRepository.save(result);

        RegistrationLog log = new RegistrationLog();
        log.setResult(savedResult);
        log.setEventType("CREATED");
        log.setDescription("Resultat registrerat");

        registrationLogRepository.save(log);

        return savedResult;
    }
}