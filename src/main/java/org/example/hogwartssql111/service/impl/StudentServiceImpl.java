package org.example.hogwartssql111.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.hogwartssql111.exception.NotFoundException;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.repository.StudentRepository;
import org.example.hogwartssql111.service.FacultyService;
import org.example.hogwartssql111.service.StudentService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FacultyService facultyService;

    @Override
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @SneakyThrows
    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> currentStudent = studentRepository.findById(id);
        if (currentStudent.isPresent()) {
            student.setId(currentStudent.get().getId());
            studentRepository.save(student);
            return student;
        } else {
            return null;
        }
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty with id " + id + " does not exist"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {}
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByFacultyId(Long id) {
        Faculty currentFaculty = facultyService.getFaculty(id);
        return currentFaculty.getStudents();
    }


}
