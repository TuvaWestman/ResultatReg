/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package se.ltu.resultatregistrering.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import se.ltu.resultatregistrering.model.Results;
import se.ltu.resultatregistrering.repository.ResultRepository;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultRepository resultRepository;

    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public List<Results> getAllResults() {
        return resultRepository.findAll();
    }
}
