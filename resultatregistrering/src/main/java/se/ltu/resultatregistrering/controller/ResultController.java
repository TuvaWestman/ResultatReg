/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import se.ltu.resultatregistrering.model.Result;
import se.ltu.resultatregistrering.repository.ladok.ResultRepository;
import se.ltu.resultatregistrering.service.LadokService;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultRepository resultRepository;
    private final LadokService ladokService;

    public ResultController(
            ResultRepository resultRepository,
            LadokService ladokService) {

        this.resultRepository = resultRepository;
        this.ladokService = ladokService;
    }

    @GetMapping
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        result.setStatus("registrerad");
        return ladokService.registerResult(result);
    }
}