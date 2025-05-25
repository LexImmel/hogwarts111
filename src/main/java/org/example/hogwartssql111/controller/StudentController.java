package org.example.hogwartssql111.controller;

import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}


