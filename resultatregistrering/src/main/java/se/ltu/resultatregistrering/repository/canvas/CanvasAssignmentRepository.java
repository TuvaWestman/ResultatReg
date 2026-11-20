/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.repository.canvas;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import se.ltu.resultatregistrering.model.CanvasAssignment;

public interface CanvasAssignmentRepository
        extends JpaRepository<CanvasAssignment, Integer> {

    // Hämta alla Canvas-uppgifter för en kurs
    List<CanvasAssignment> findByCourseCode(String courseCode);
}