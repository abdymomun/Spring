package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Appointment;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
List<Appointment> getAllApointment(Long hospitalId);
}
