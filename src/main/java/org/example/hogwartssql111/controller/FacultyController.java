package org.example.hogwartssql111.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.model.Faculty;
import org.example.hogwartssql111.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/all")
    public List<Faculty> getAllFaculties() {
        return facultyService.getAll();
    }

}
