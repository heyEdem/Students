package edem.students.Service;

import edem.students.Entities.Student;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
     List<Student> findAllStudents();

     Student createStudent(Student student);
     Student updateStudent(Student student);
     void deleteStudent(Long id);
     Optional <Student>findStudentById(Long id);


}
