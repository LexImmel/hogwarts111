package org.example.hogwartssql111.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.hogwartssql111.exception.NotFoundException;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.repository.StudentRepository;
import org.example.hogwartssql111.service.FacultyService;
import org.example.hogwartssql111.service.StudentService;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FacultyService facultyService;

    @Override
    public Student addStudent(Student student) {
        Faculty currentFaculty = facultyService.getFacultyByName(student.getFaculty().getName());
        student.setFaculty(currentFaculty);
        return studentRepository.save(student);
    }

    @SneakyThrows
    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> currentStudent = studentRepository.findById(id);
        if (currentStudent.isPresent()) {
            student.setId(currentStudent.get().getId());
            return studentRepository.save(student);
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
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
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

    public Faculty getFacultyOfStudent(Long Id) {
        Student student = studentRepository.findById(Id).orElseThrow(
                () -> new NotFoundException("Student not found with id: " + Id));
        return student.getFaculty();
    }

    @Override
    public List<Student> findByAgeBetween(int minAge, int maxAge) {
        return findByAgeBetween(minAge, maxAge).stream()
                .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    @Override
    public void countStudents() {
        studentRepository.countStudents();
    }

    @Override
    public Student getAverageAge() {
        return null;
    }

    public List<Student> getFiveLastStudents() {
        return studentRepository.getFiveLastStudents();
    }

}