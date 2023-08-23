package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctor_gen")
    @SequenceGenerator(sequenceName = "doctor_seq",name = "doctor_gen")
    private Long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    private String position;
    @Column(unique = true)
    @NotNull
    private String email;
    @ManyToMany(mappedBy = "doctors")
    private List<Department>departments;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment>appointments;
    @ManyToOne
    private Hospital hospital;
}
