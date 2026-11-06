
package se.ltu.resultatregistrering.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "modules")
@IdClass(ModuleId.class)


public class Module {

    @Id
    @Column(name = "course_code", length = 12)
    private String courseCode;

    @Id
    @Column(name = "module_code", length = 4)
    private String moduleCode;

    @Column(name = "module_name", nullable = false, length = 150)
    private String moduleName;

    @Column(nullable = false, precision = 4, scale = 1)
    private BigDecimal credits;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    public Module() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
