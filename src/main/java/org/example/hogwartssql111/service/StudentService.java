package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student updateStudent(Long id, Student student);

    Student getStudent(Long id);

    void deleteStudent(Long id);

    List<Student> getAll();

    List<Student> getStudentsByFacultyId(Long id);

    Faculty getFacultyOfStudent(Long id);

    List<Student> findByAgeBetween(int minAge, int maxAge);

    void countStudents();

    double getAverageAge();

    List<Student> getFiveLastStudents();

    List<String> getAllNamesOfStudentsStartingWith(String letter);

    int averageAgeOfStudents();
}
