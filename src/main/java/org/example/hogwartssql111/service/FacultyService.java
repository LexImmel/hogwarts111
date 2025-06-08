package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);

    Faculty findFaculty(long id);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(long id);

    Collection<Faculty> findByNameOrColor(String name, String color);

    Faculty get(long facultyId);

    Faculty updateFaculty(Long id, Faculty faculty);

    Faculty getFaculty(Long id);

    void deleteFaculty(Long id);

    List<Faculty> getAll();

    Faculty getFacultyByName(String name);


    List<Student> getStudentByFaculty(Long Id);

    List<Faculty> getFacultyByColor(String color);

}