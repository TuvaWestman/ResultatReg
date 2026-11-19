/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/canvas")
public class CanvasController {

    // Simulerade Canvas-omdömen
    // Kopplas till kurs, uppgift och student
    private static final List<Map<String, String>> GRADES = List.of(
        Map.of("courseCode", "D0031N",
               "assignment", "Inlämningsuppgift 1",
               "personalNumber", "20990101-0001",
               "grade", "VG"),

        Map.of("courseCode", "D0031N",
               "assignment", "Inlämningsuppgift 1",
               "personalNumber", "20990101-0002",
               "grade", "G"),

        Map.of("courseCode", "D0031N",
               "assignment", "Inlämningsuppgift 1",
               "personalNumber", "20990101-0003",
               "grade", "G"),

        Map.of("courseCode", "D0031N",
               "assignment", "Inlämningsuppgift 1",
               "personalNumber", "20990101-0004",
               "grade", "U"),

        Map.of("courseCode", "D0031N",
               "assignment", "Inlämningsuppgift 1",
               "personalNumber", "20990101-0005",
               "grade", "VG"),

        Map.of("courseCode", "D0031N",
               "assignment", "Slutprojekt",
               "personalNumber", "20990101-0006",
               "grade", "G"),

        Map.of("courseCode", "D0031N",
               "assignment", "Slutprojekt",
               "personalNumber", "20990101-0007",
               "grade", "VG"),

        Map.of("courseCode", "D0025E",
               "assignment", "Tentamen",
               "personalNumber", "20990101-0010",
               "grade", "VG")
    );

    @GetMapping("/grades")
    public List<Map<String, String>> getGrades(
            @RequestParam String courseCode,
            @RequestParam String assignment) {

        return GRADES.stream()
                .filter(g -> g.get("courseCode").equals(courseCode))
                .filter(g -> g.get("assignment").equals(assignment))
                .toList();
    }
}