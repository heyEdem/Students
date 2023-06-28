package edem.students;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
     List<Student> findAllStudents();

     Student createStudent(Student student);
     void updateStudent(Student student);
     void deleteStudent(Long id);
     Optional <Student>findStudentById(Long id);


}
