/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import se.ltu.resultatregistrering.model.CourseEnrollment;
import se.ltu.resultatregistrering.repository.studentits.CourseEnrollmentRepository;

@RestController
@RequestMapping("/api/enrollments")
public class CourseEnrollmentController {

    private final CourseEnrollmentRepository enrollmentRepository;

    public CourseEnrollmentController(
            CourseEnrollmentRepository enrollmentRepository) {

        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping
    public List<CourseEnrollment> getEnrollments(
            @RequestParam String courseCode) {

        return enrollmentRepository.findByCourseCode(courseCode);
    }
}