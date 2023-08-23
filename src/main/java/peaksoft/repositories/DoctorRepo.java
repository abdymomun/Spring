package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Doctor;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

}
