/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import se.ltu.resultatregistrering.model.CanvasGrade;
import se.ltu.resultatregistrering.repository.canvas.CanvasGradeRepository;

@RestController
@RequestMapping("/api/canvas")
public class CanvasController {

    private final CanvasGradeRepository canvasGradeRepository;

    public CanvasController(
            CanvasGradeRepository canvasGradeRepository) {

        this.canvasGradeRepository = canvasGradeRepository;
    }

    // Hämta Canvas-omdömen från MySQL
    @GetMapping("/grades")
    public List<Map<String, String>> getGrades(
            @RequestParam String courseCode,
            @RequestParam(required = false) String assignment) {

        List<CanvasGrade> grades;

        // Filtrera på kurs och eventuellt uppgift
        if (assignment == null || assignment.isBlank()) {

            grades = canvasGradeRepository
                    .findByAssignment_CourseCode(courseCode);

        } else {

            grades = canvasGradeRepository
                    .findByAssignment_CourseCodeAndAssignment_AssignmentName(
                            courseCode,
                            assignment
                    );
        }

        // Returnera samma JSON-format som tidigare
        return grades.stream()
                .map(g -> Map.of(
                        "courseCode",
                        g.getAssignment().getCourseCode(),

                        "assignment",
                        g.getAssignment().getAssignmentName(),

                        "personalNumber",
                        g.getPersonalNumber(),

                        "grade",
                        g.getGrade()
                ))
                .toList();
    }
}