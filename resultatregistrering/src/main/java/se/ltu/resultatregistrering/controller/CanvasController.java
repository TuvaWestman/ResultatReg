/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/canvas")
public class CanvasController {

    // Simulerade Canvas-omdömen
    private static final List<Map<String, String>> GRADES =
            new ArrayList<>();

    static {

        // D0031N - Enterprise Architecture
        // Inlämningsuppgift 1
        add("D0031N", "Inlämningsuppgift 1", 1, "VG");
        add("D0031N", "Inlämningsuppgift 1", 2, "G");
        add("D0031N", "Inlämningsuppgift 1", 3, "G");
        add("D0031N", "Inlämningsuppgift 1", 4, "U");
        add("D0031N", "Inlämningsuppgift 1", 5, "VG");
        add("D0031N", "Inlämningsuppgift 1", 6, "G");
        add("D0031N", "Inlämningsuppgift 1", 7, "VG");
        add("D0031N", "Inlämningsuppgift 1", 8, "G");
        add("D0031N", "Inlämningsuppgift 1", 9, "U");
        add("D0031N", "Inlämningsuppgift 1", 10, "G");
        add("D0031N", "Inlämningsuppgift 1", 11, "VG");
        add("D0031N", "Inlämningsuppgift 1", 12, "G");
        add("D0031N", "Inlämningsuppgift 1", 13, "G");
        add("D0031N", "Inlämningsuppgift 1", 14, "VG");
        add("D0031N", "Inlämningsuppgift 1", 15, "U");

        // Slutprojekt
        add("D0031N", "Slutprojekt", 1, "G");
        add("D0031N", "Slutprojekt", 2, "VG");
        add("D0031N", "Slutprojekt", 3, "G");
        add("D0031N", "Slutprojekt", 4, "U");
        add("D0031N", "Slutprojekt", 5, "VG");
        add("D0031N", "Slutprojekt", 6, "G");
        add("D0031N", "Slutprojekt", 7, "VG");
        add("D0031N", "Slutprojekt", 8, "G");
        add("D0031N", "Slutprojekt", 9, "G");
        add("D0031N", "Slutprojekt", 10, "VG");

        // D0025E - Data Mining
        // Laboration
        add("D0025E", "Laboration", 15, "G");
        add("D0025E", "Laboration", 16, "VG");
        add("D0025E", "Laboration", 17, "G");
        add("D0025E", "Laboration", 18, "G");
        add("D0025E", "Laboration", 19, "U");
        add("D0025E", "Laboration", 20, "VG");
        add("D0025E", "Laboration", 21, "G");
        add("D0025E", "Laboration", 22, "G");

        // Tentamen
        add("D0025E", "Tentamen", 15, "VG");
        add("D0025E", "Tentamen", 16, "G");
        add("D0025E", "Tentamen", 17, "U");
        add("D0025E", "Tentamen", 18, "G");
        add("D0025E", "Tentamen", 19, "G");
        add("D0025E", "Tentamen", 20, "VG");
        add("D0025E", "Tentamen", 21, "G");

        // D0001A - Introduction to Programming
        // Programmeringsuppgift
        add("D0001A", "Programmeringsuppgift", 35, "G");
        add("D0001A", "Programmeringsuppgift", 36, "VG");
        add("D0001A", "Programmeringsuppgift", 37, "G");
        add("D0001A", "Programmeringsuppgift", 38, "U");
        add("D0001A", "Programmeringsuppgift", 39, "VG");
        add("D0001A", "Programmeringsuppgift", 40, "G");

        // Projekt
        add("D0001A", "Projekt", 35, "VG");
        add("D0001A", "Projekt", 36, "G");
        add("D0001A", "Projekt", 37, "G");
        add("D0001A", "Projekt", 38, "U");
        add("D0001A", "Projekt", 39, "VG");
    }

    // Skapar ett simulerat Canvas-resultat
    private static void add(
            String courseCode,
            String assignment,
            int studentNumber,
            String grade) {

        String personalNumber =
                String.format("20990101-%04d", studentNumber);

        GRADES.add(Map.of(
                "courseCode", courseCode,
                "assignment", assignment,
                "personalNumber", personalNumber,
                "grade", grade
        ));
    }

    // Hämta Canvas-omdömen för kurs och uppgift
    @GetMapping("/grades")
    public List<Map<String, String>> getGrades(
            @RequestParam String courseCode,
            @RequestParam(required = false) String assignment) {

        return GRADES.stream()
                .filter(g ->
                    g.get("courseCode").equals(courseCode))
                .filter(g ->
                    assignment == null ||
                    g.get("assignment").equals(assignment))
                .toList();
    }
}