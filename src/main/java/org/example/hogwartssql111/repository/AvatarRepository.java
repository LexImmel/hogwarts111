package org.example.hogwartssql111.repository;

import org.example.hogwartssql111.model.Avatar;
import org.example.hogwartssql111.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findAvatarByStudent (Student student);
}
