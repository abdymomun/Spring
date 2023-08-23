package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_gen")
    @SequenceGenerator(sequenceName = "department_seq",name = "department_gen",allocationSize = 1)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Doctor>doctors;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @ToString.Exclude
    private Hospital hospital;

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}

