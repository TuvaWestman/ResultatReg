/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.ltu.resultatregistrering.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canvas_grades")
public class CanvasGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Integer gradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", nullable = false)
    private CanvasAssignment assignment;

    @Column(name = "personal_number", nullable = false, length = 13)
    private String personalNumber;

    @Column(name = "grade", nullable = false, length = 5)
    private String grade;

    public CanvasGrade() {
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public CanvasAssignment getAssignment() {
        return assignment;
    }

    public void setAssignment(CanvasAssignment assignment) {
        this.assignment = assignment;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}