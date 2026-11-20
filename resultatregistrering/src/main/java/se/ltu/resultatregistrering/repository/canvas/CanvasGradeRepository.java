/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.repository.canvas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import se.ltu.resultatregistrering.model.CanvasGrade;

public interface CanvasGradeRepository
        extends JpaRepository<CanvasGrade, Integer> {

    // Hämta betyg tillsammans med Canvas-uppgiften
    @EntityGraph(attributePaths = {"assignment"})
    List<CanvasGrade> findByAssignment_CourseCode(
            String courseCode);

    // Hämta betyg för en specifik uppgift
    @EntityGraph(attributePaths = {"assignment"})
    List<CanvasGrade>
            findByAssignment_CourseCodeAndAssignment_AssignmentName(
                    String courseCode,
                    String assignmentName);
}