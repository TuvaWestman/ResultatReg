
package se.ltu.resultatregistrering.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "results",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_result_registration",
                        columnNames = {
                                "personal_number",
                                "course_code",
                                "module_code",
                                "examination_date"
                        }
                )
        }
)
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @Column(name = "personal_number", nullable = false, length = 13)
    private String personalNumber;

    @Column(name = "course_code", nullable = false, length = 12)
    private String courseCode;

    @Column(name = "module_code", nullable = false, length = 4)
    private String moduleCode;

    @Column(name = "examination_date", nullable = false)
    private LocalDate examinationDate;

    @Column(nullable = false, length = 5)
    private String grade;

    @Column(nullable = false, length = 20)
    private String status = "registrerad";

    @Column(name = "registered_at", nullable = false,
            insertable = false, updatable = false)
    private LocalDateTime registeredAt;

    public Result() {
    }

    // Getters och setters

    public Integer getResultId() { return resultId; }
    public void setResultId(Integer resultId) { this.resultId = resultId; }

    public String getPersonalNumber() { return personalNumber; }
    public void setPersonalNumber(String personalNumber) { this.personalNumber = personalNumber; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getModuleCode() { return moduleCode; }
    public void setModuleCode(String moduleCode) { this.moduleCode = moduleCode; }

    public LocalDate getExaminationDate() { return examinationDate; }
    public void setExaminationDate(LocalDate examinationDate) { this.examinationDate = examinationDate; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getRegisteredAt() { return registeredAt; }
    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }
}
