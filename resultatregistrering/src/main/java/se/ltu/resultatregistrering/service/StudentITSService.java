

package se.ltu.resultatregistrering.service;

import org.springframework.stereotype.Service;
import se.ltu.resultatregistrering.model.Student;
import se.ltu.resultatregistrering.repository.studentits.StudentRepository;

import java.util.Optional;

@Service
public class StudentITSService {

    private final StudentRepository studentRepository;

    public StudentITSService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudentByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}