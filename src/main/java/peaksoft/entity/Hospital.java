package peaksoft.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hospital_gen")
    @SequenceGenerator(sequenceName = "hospital_seq",name = "hospital_gen")
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @OneToMany(mappedBy = "hospital")
    private List<Doctor>doctors;
    @OneToMany(mappedBy = "hospital")
    private List<Patient>patients;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private List<Department>departments;
    @OneToMany
    private List<Appointment>appointments;

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
