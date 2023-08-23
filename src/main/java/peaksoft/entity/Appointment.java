package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appointment_gen")
    @SequenceGenerator(sequenceName = "appointment_seq",name = "appointment_gen")
    private Long id;
    @NotNull
    private LocalDate date;
    @ManyToOne
    @NotNull
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
