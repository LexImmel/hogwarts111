package org.example.hogwartssql111.repository;

import org.example.hogwartssql111.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Object findByAgeBetween(Integer any, Integer any1);

    Object findAllByAge(Integer any);

    @Query("select count (*) from Student ")
    int countStudents();

    @Query("SELECT AVG (age) FROM Student")
    double getAverageAge();

    @Query(value = "SELECT * FROM Student ORDER BY id DESC limit 5", nativeQuery = true)
    List<Student> getFiveLastStudents();

}
