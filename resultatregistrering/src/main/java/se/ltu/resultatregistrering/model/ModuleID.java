
package se.ltu.resultatregistrering.model;

import java.io.Serializable;
import java.util.Objects;

public class ModuleId implements Serializable {

    private String courseCode;
    private String moduleCode;

    public ModuleId() {
    }

    public ModuleId(String courseCode, String moduleCode) {
        this.courseCode = courseCode;
        this.moduleCode = moduleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModuleId)) return false;
        ModuleId that = (ModuleId) o;
        return Objects.equals(courseCode, that.courseCode)
                && Objects.equals(moduleCode, that.moduleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, moduleCode);
    }
}
