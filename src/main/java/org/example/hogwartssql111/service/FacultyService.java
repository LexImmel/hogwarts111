package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);

    Faculty updateFaculty(Long id, Faculty faculty);

    Faculty getFaculty(Long id);

    void deleteFaculty(Long id);

    List<Faculty> getAll();
}
