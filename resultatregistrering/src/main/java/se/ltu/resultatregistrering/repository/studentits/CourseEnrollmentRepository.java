/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.repository.studentits;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import se.ltu.resultatregistrering.model.CourseEnrollment;

public interface CourseEnrollmentRepository
        extends JpaRepository<CourseEnrollment, Integer> {

    List<CourseEnrollment> findByCourseCode(String courseCode);
}