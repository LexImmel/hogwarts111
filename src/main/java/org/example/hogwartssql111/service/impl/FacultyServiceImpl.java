package org.example.hogwartssql111.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.exception.NotFoundException;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.repository.FacultyRepository;
import org.example.hogwartssql111.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
        return faculty;
    }

    @Override
    public Faculty findFaculty(long id) {
        return null;
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        return null;
    }

    @Override
    public void deleteFaculty(long id) {

    }

    @Override
    public Collection<Faculty> findByNameOrColor(String name, String color) {
        return List.of();
    }

    @Override
    public Faculty get(long facultyId) {
        return null;
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        Optional<Faculty> currentFaculty = facultyRepository.findById(id);
        if (currentFaculty.isPresent()) {
            faculty.setId(currentFaculty.get().getId());
            facultyRepository.save(faculty);
            return faculty;
        } else {
            return null;
        }
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException("Faculty with id " + id + " does not exist"));
    }

    @Override
    public void deleteFaculty(Long id) {
        if (facultyRepository.existsById(id)) {
        }
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyByName(String name) {
        return facultyRepository.findByName(name).orElseThrow(() -> new NotFoundException("Faculty with name " + name + " does not exist"));
    }

    @Override
    public List<Student> getStudentByFaculty(Long Id) {
        Faculty faculty = facultyRepository.findById(Id).orElseThrow(
                () -> new NotFoundException("Faculty not found with student id: " + Id));
        return faculty.getStudents();
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        return List.of();
    }


}