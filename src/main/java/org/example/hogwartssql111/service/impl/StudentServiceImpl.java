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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student addStudent(Student student) {
        Faculty currentFaculty = facultyService.getFacultyByName(student.getFaculty().getName());
        student.setFaculty(currentFaculty);
        logger.info("Was invoked method to create student");
        return studentRepository.save(student);
    }

    @SneakyThrows
    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> currentStudent = studentRepository.findById(id);
        if (currentStudent.isPresent()) {
            student.setId(currentStudent.get().getId());
            logger.info("Was invoked method to update student");
            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    @Override
    public Student getStudent(Long id) {
        logger.info("Was invoked method to find student");
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty with id " + id + " does not exist"));
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Was invoked method to delete student");
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }

    @Override
    public List<Student> getAll() {
        logger.info("Was invoked method to get all students");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByFacultyId(Long id) {
        logger.info("Was invoked method to get students by faculty");
        Faculty currentFaculty = facultyService.getFaculty(id);
        return currentFaculty.getStudents();
    }

    public Faculty getFacultyOfStudent(Long Id) {
        Student student = studentRepository.findById(Id).orElseThrow(
                () -> new NotFoundException("Student not found with id: " + Id));
        logger.info("Was invoked method to get faculty of a student");
        return student.getFaculty();
    }

    @Override
    public List<Student> findByAgeBetween(int minAge, int maxAge) {
        logger.info("Was invoked method to find students by requested age");
        return findByAgeBetween(minAge, maxAge).stream()
                .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    @Override
    public void countStudents() {
        logger.info("Was invoked method to count all students");
        studentRepository.countStudents();
    }

    @Override
    public Student getAverageAge() {
        logger.info("Was invoked method to get average age of students");
        return null;
    }

    public List<Student> getFiveLastStudents() {
        logger.info("Was invoked method to get five last students");
        return studentRepository.getFiveLastStudents();
    }

}