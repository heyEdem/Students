package edem.students;

import edem.students.Entities.Student;
import edem.students.Service.StudentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StudentsApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }

    private StudentService service;

    public StudentsApplication(StudentService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Student> studentList = service.findAllStudents();

        Student edem = Student.builder().firstname("Edem").lastname("Akato").age(21).location("Ghana").number("0549767056").build();
        Student vera = Student.builder().firstname("Vera").lastname("Caesar").age(21).location("Ghana").number("0549767056").build();
        Student eugene = Student.builder().firstname("Eugene").lastname("Fiakuna").age(21).location("Ghana").number("0549767056").build();
        Student winner = Student.builder().firstname("Winner").lastname("Kpodo").age(21).location("Ghana").number("0549767056").build();
        Arrays.asList(edem,vera,winner,eugene).forEach(s-> service.createStudent(s));
        System.out.println("new students added");
    }
}
