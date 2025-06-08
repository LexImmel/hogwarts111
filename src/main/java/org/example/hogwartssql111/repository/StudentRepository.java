package org.example.hogwartssql111.repository;

import org.example.hogwartssql111.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Object findByAgeBetween(Integer any, Integer any1);

    Object findAllByAge(Integer any);
}
