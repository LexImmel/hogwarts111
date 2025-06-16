package org.example.hogwartssql111.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.exception.NotFoundException;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.repository.FacultyRepository;
import org.example.hogwartssql111.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private static final Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);
    private final FacultyRepository facultyRepository;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        logger.info("Was invoked method to add faculty with id {}", faculty.getId());
        facultyRepository.save(faculty);
        return faculty;
    }

    @Override
    public Long findFaculty(long facultyId) {
        logger.info("Was invoked method to find faculty with id {}", facultyId);
        return getFaculty(facultyId).getId();
    }

    @Override
    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method to edit faculty with id {}", faculty.getId());
        return null;
    }

    @Override
    public void deleteFaculty(long id) {
        logger.info("Was invoked method to delete faculty with id {}", id);
    }

    @Override
    public Collection<Faculty> findByNameOrColor(String name, String color) {
        logger.info("Was invoked method to find faculty with name {} or color {}", name, color);
        return List.of();
    }

    @Override
    public Faculty get(long facultyId) {
        logger.info("Was invoked method to get faculty with id {}", facultyId);
        return null;
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        return null;
    }

    @Override
    public Faculty updateFaculty(long facultyId, Faculty faculty) {
        logger.info("Was invoked method to update faculty with id {}", facultyId);
        Optional<Faculty> currentFaculty = facultyRepository.findById(facultyId);
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
        return null;
    }

    @Override
    public Faculty getFaculty(long facultyId) {
        logger.info("Was invoked method to get Faculty with id {}", facultyId);
        return facultyRepository.findById(facultyId).orElseThrow(() -> new NotFoundException("Faculty with id " + facultyId + " does not exist"));
    }

    @Override
    public void deleteFaculty(Long id) {
        logger.info("Was invoked method to delete Faculty with id {}", id);
        if (facultyRepository.existsById(id)) {
        }
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> getAll() {
        logger.info("Was invoked method to get all Faculties");
        return facultyRepository.findAll();
    }

    public Faculty getFacultyByName(String name) {
        logger.info("Was invoked method to get Faculty with name {}", name);
        return facultyRepository.findByName(name).orElseThrow(() -> new NotFoundException("Faculty with name " + name + " does not exist"));
    }

    @Override
    public List<Student> getStudentByFaculty(Long Id) {
        logger.info("Was invoked method to get faculty of a Student with id {}", Id);
        Faculty faculty = facultyRepository.findById(Id).orElseThrow(
                () -> new NotFoundException("Faculty not found with student id: " + Id));
        return faculty.getStudents();
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        logger.info("Was invoked method to get faculty by color {}", color);
        return List.of();
    }


}