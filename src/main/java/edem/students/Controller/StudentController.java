package edem.students.Controller;

import edem.students.Service.ServiceInterface;
import edem.students.Entities.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private ServiceInterface service;

    public StudentController(ServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List <Student>> findAllStudents() {
         List <Student> students = service.findAllStudents();
         return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/add")
    //try  passing a Long if Student doesn't work
    public ResponseEntity <Student> addStudent(@RequestBody Student student){
        Student newStudent = service.createStudent(student);
        if (newStudent == null){
            return new ResponseEntity<>(newStudent,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        service.updateStudent(student);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@RequestParam("id") Long id){
        service.deleteStudent(id);
        return new ResponseEntity <> (HttpStatus.OK);
    }
}
