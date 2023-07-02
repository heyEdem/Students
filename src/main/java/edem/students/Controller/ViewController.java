package edem.students.Controller;

import edem.students.Entities.Student;
import edem.students.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ViewController {

    private StudentService service;

    public ViewController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAll(Model model){
        List<Student> studentList = service.findAllStudents();
        model.addAttribute("students",studentList);
        return "index";
    }

    @GetMapping("/api/add")
    public String addNewStudent(Student student){
        return "new-student";
    }

    @PostMapping("/api/add")
    public String addStudent(Student student){
        service.createStudent(student);
        return "redirect:/api";
    }

    @PutMapping
    @RequestMapping("/api/edit")
    public String updateStudent(Model model , @RequestBody Student student){
        service.updateStudent(student);
        model.addAttribute("editedStudent",student);
//        if (id.isPresent()) {
//           Optional <Student> editedStudent = service.updateStudent(id.get());
//           if(editedStudent.isPresent()){
//               model.addAttribute("editedStudent", student);
//           }
//            model.addAttribute("editedStudent", student);
//        }
        return "new-student";
    }

    @DeleteMapping
    @RequestMapping("/api/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return "redirect:/api";
    }



}
