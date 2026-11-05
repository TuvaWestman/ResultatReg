

package se.ltu.resultatregistrering.repository;

import se.ltu.resultatregistrering.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
