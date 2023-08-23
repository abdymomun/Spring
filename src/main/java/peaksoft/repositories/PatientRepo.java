package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Patient;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {

}
