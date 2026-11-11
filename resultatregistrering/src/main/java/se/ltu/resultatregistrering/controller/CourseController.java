/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package se.ltu.resultatregistrering.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import se.ltu.resultatregistrering.model.Course;
import se.ltu.resultatregistrering.repository.epok.CourseRepository;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    @GetMapping("/{courseCode}")
public ResponseEntity<Course> getCourse(
        @PathVariable String courseCode) {

    return courseRepository.findById(courseCode)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}
}
