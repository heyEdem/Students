package edem.students;

import org.springframework.stereotype.Service;
import edem.students.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements ServiceInterface {
    final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
       repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return repository.findById(id);
    }
}
