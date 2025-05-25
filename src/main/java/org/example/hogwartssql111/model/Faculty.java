package org.example.hogwartssql111.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name="hw_faculty")
public class Faculty {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "faculty_name")
    private String name;

    @Column(name = "faculty_color")
    private String color;

    @OneToMany(mappedBy = "faculty")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Student> students;
}
