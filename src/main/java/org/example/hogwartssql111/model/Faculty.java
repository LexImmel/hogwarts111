package org.example.hogwartssql111.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.function.IntPredicate;

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

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Student> students;

    public Faculty(int i, String fenix, String color) {
    }

    public void setFacultyId(long l) {
    }

    public IntPredicate getFacultyId() {
        return null;
    }
}
