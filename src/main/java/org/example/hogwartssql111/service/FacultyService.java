package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);

    Long findFaculty(long id);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(long id);

    Collection<Faculty> findByNameOrColor(String name, String color);

    Faculty get(long facultyId);

    Faculty updateFaculty(Long id, Faculty faculty);

    Faculty updateFaculty(long facultyId, Faculty faculty);

    Faculty getFaculty(Long id);

    Faculty getFaculty(long facultyId);

    void deleteFaculty(Long id);

    List<Faculty> getAllFaculties();

    Faculty getFacultyByName(String name);


    List<Student> getStudentByFaculty(Long Id);

    List<Faculty> getFacultyByColor(String color);

    Optional<String> getFacultyByLongestName();

}