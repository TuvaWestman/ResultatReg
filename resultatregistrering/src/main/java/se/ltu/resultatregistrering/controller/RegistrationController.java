/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package se.ltu.resultatregistrering.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import se.ltu.resultatregistrering.model.Registration;
import se.ltu.resultatregistrering.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(
            RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
}
