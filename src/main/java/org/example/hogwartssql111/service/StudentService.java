package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Student;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    Student updateStudent(Long id, Student student);

    Student getStudent(Long id);

    void deleteStudent(Long id);

    List<Student> getAll();

    List<Student> getStudentsByFacultyId(Long id);
}
