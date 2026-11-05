package se.ltu.resultatregistrering.model;

import jakarta.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "course_code", length = 12)
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 150)
    private String courseName;

    @Column(name = "total_credits", nullable = false, precision = 4, scale = 1)
    private BigDecimal totalCredits;

    public Course() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(BigDecimal totalCredits) {
        this.totalCredits = totalCredits;
    }
}