package org.example.hogwartssql111.controller;

import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable(name = "id") Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name = "id") Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/faculty/{id}")
    public List<Student> getStudentsByFacultyId(@PathVariable(name = "id") Long id) {
        return studentService.getStudentsByFacultyId(id);
    }

    @GetMapping("/age-between")
    public List<Student> findByAgeBetween(@RequestParam int minAge, @RequestParam int maxAge) {
        return studentService.findByAgeBetween(minAge, maxAge);
    }


    @GetMapping("faculty-of-student/{id}")
    public Faculty getFacultyOfStudent(@PathVariable(name = "id") Long id) {
        return studentService.getFacultyOfStudent(id);
    }

    @GetMapping("/countStudents")
    public void countStudents() {
        studentService.countStudents();
    }

    @GetMapping("/getAverageAge")
    public double getAverageAge() {
        return studentService.getAverageAge();

    }
    @GetMapping("/get-five-last-students")
    public List<Student> getFiveLastStudents() {
        return studentService.getFiveLastStudents();

    }

    @GetMapping("/getAllNamesOfStudentsStartingWith/{letter}")
    public List<String> getAllNamesOfStudentsStartingWith(@PathVariable(name = "letter") String letter) {
        return studentService.getAllNamesOfStudentsStartingWith(letter);
    }

    @GetMapping("/averageAgeOfStudents")
    public int averageAgeOfStudents() {
        return studentService.averageAgeOfStudents();
    }
    @GetMapping ("/students/print-parallel")
    public void printParallel() {
        studentService.printParallel();
    }

    @GetMapping ("/students/print-synchronized")
    public void printSynchronised() {
        studentService.printSynchronized();
    }

}


