package org.example.hogwartssql111.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
@Tag(name= "Контроллер для работы с факультетами", description = "Контроллер для работы с факультетами")
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable (name = "id") Long id, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(id, faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable (name = "id") Long id) {
        return facultyService.getFaculty(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable(name = "id") Long id) {
        facultyService.deleteFaculty(id);
    }

    @GetMapping("/color/{color}")
    public List<Faculty> getFacultyByColor(@PathVariable String color) {
        return facultyService.getFacultyByColor(color);
    }

    @GetMapping("/faculty/{id}")
    public List<Student> getStudentByFaculty(@PathVariable(name = "id") Long id) {
        return facultyService.getStudentByFaculty(id);
    }

    @PutMapping("/all")
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/longestFacultyNameIs")
    public Optional<String> getFacultyByLongestName() {
        return facultyService.getFacultyByLongestName();
    }

}